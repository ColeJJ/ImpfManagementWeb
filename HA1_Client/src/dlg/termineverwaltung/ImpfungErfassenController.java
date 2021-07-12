package dlg.termineverwaltung;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.terminverwaltung.entity.TerminTO;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;

public class ImpfungErfassenController implements Initializable, ControlledScreen{
	
	@FXML TextField tf_patient;
	@FXML TextField tf_datum_termin;
	@FXML TextField tf_uhrzeit_termin;
	@FXML DatePicker dp_datum_impfung;
	@FXML TextField tf_uhrzeit_impfung;
	@FXML TableView<TerminTO> table_termine;
	@FXML TableView<ImpfstoffchargeTO> table_chargen;
	@FXML ComboBox<String> cb_hersteller;
	@FXML TextArea ta_bemerkung;
	@FXML Button bt_erfassen;
	@FXML Button bt_abbruch;
	@FXML Button bt_refresh;
	
	ScreensController myController;
	
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Listener, der die deaktivierten TextFelder automatisch mit dem ausgewähltem Termin befüllt
		table_termine.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
	        if (newVal != null) {
	            TerminTO aTerminTO = table_termine.getSelectionModel().getSelectedItem();
	    		String ID = "" + aTerminTO.getPatientID() + "";
	    		String datum = "" + aTerminTO.getDatum() + "";
	    		tf_patient.setText(ID);
	    		tf_datum_termin.setText(datum);
	    		tf_uhrzeit_termin.setText(aTerminTO.getUhrzeit());;
	        }
	    });
		
		//Button deaktivieren, bis alle Felder ausgefüllt sind
		bt_erfassen.disableProperty().bind(
				Bindings.isEmpty(table_termine.getSelectionModel().getSelectedItems())
				.or(dp_datum_impfung.valueProperty().isNull())
				.or(tf_uhrzeit_impfung.textProperty().isEmpty())
				.or(Bindings.isEmpty(table_chargen.getSelectionModel().getSelectedItems()))
		        .or (cb_hersteller.valueProperty().isNull()));
	}
	
	private void initGui() {
		tf_patient.setText("");
		tf_datum_termin.setText("");
		tf_uhrzeit_termin.setText("");
		tf_uhrzeit_impfung.setText("");
		dp_datum_impfung.setValue(null);
		cb_hersteller.setValue(null);;
		ta_bemerkung.setText("");	
		table_termine.getItems().clear();
		table_chargen.getItems().clear();
	}
	
	@FXML
	public void buttonAbbruchClicked() {
		initGui();
		myController.setScreen(Hauptmenue.TERMVW_SCREEN);
	}
	
	@FXML
	public void buttonErfassenClicked() {
		//Get ID of table_termine
		int terminID = table_termine.getSelectionModel().getSelectedItem().getTerminID();
		
		//get Textfield Values
		LocalDate datum = dp_datum_impfung.getValue();
		String uhrzeit = tf_uhrzeit_impfung.getText();
		String bemerkung = ta_bemerkung.getText();
		
		//get ID of table impfcharge
		int chargeID = table_chargen.getSelectionModel().getSelectedItem().getChargeID();
		
		boolean ok = false;
		
		try {
			ok = myController.getAwkService().getImpfungPflegenRemote().impfungAnlegenR(datum, uhrzeit, bemerkung, terminID, chargeID);
			myController.getAwkService().getChargeErfassenRemote().reduceChargeR(chargeID);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
		}
		
		//ok or not ok -> Meldung
		if (ok) {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Impfung wurde erfasst!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
			
			this.buttonAbbruchClicked();
		}
		else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Fehler beim Erfassen der Impfung!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}		
	}
	
	@FXML
	public void buttonRefreshClicked() {
		initTermine();
		initHersteller();
	}

	
	//Chargen
	
	private void initHersteller() {
		ObservableList<String> data =
			    FXCollections.observableArrayList(
			                 "Biontech",
			                 "Moderna",
			                 "AstraZeneca",
			                 "Jonhson&Johnson");   
		
		cb_hersteller.setItems(data);
	}
	
	//Lädt die Impfstoffchargen nach ausgewählten Hersteller
	@FXML
	private void setChargenByHersteller() {
		String hersteller = cb_hersteller.getValue();
		Collection<ImpfstoffchargeTO>chargenMengeListe = new ArrayList<ImpfstoffchargeTO>();
		
		try {
			chargenMengeListe = myController.getAwkService().getChargeSuchenRemote().getChargenByHerstellerR(hersteller);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Chargen nach Hersteller konnten nicht geladen werden.");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		ObservableList<ImpfstoffchargeTO> data = FXCollections.observableArrayList(chargenMengeListe);
		
		//Spalten
		TableColumn<ImpfstoffchargeTO, Integer> chargeIDCol = new TableColumn<ImpfstoffchargeTO, Integer>("ID");
		chargeIDCol.setMinWidth(100);
		chargeIDCol.setCellValueFactory(
				new PropertyValueFactory<ImpfstoffchargeTO, Integer>("chargeID"));
		
		TableColumn<ImpfstoffchargeTO, String> herstellerCol = new TableColumn<ImpfstoffchargeTO, String>("Hersteller");
		herstellerCol.setMinWidth(100);
		herstellerCol.setCellValueFactory(
				new PropertyValueFactory<ImpfstoffchargeTO, String>("hersteller"));
		
		TableColumn<ImpfstoffchargeTO, Integer> MengeCol = new TableColumn<ImpfstoffchargeTO, Integer>("Menge");
		MengeCol.setMinWidth(100);
		MengeCol.setCellValueFactory(
				new PropertyValueFactory<ImpfstoffchargeTO, Integer>("anzahl"));
		
		table_chargen.setItems(data);
		table_chargen.getColumns().clear();
		table_chargen.getColumns().addAll(chargeIDCol, herstellerCol, MengeCol);
	}
	
	//Termine
	
	@SuppressWarnings("unchecked")
	private void initTermine() {
		Collection<TerminTO>terminListe = new ArrayList<TerminTO>();
		
		try {
			terminListe = myController.getAwkService().getTermineSuchenRemote().getAllOpenTermineR();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Termine konnte nicht initialisiert werden.");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		ObservableList<TerminTO> data = FXCollections.observableArrayList(terminListe);
		
		//Spalten
		TableColumn<TerminTO, Integer> terminCol = new TableColumn<TerminTO, Integer>("ID");
		terminCol.setMinWidth(100);
		terminCol.setCellValueFactory(
				new PropertyValueFactory<TerminTO, Integer>("terminID"));
		
		TableColumn<TerminTO, LocalDate> datumCol = new TableColumn<TerminTO, LocalDate>("Datum");
		datumCol.setMinWidth(100);
		datumCol.setCellValueFactory(
				new PropertyValueFactory<TerminTO, LocalDate>("datum"));
		
		TableColumn<TerminTO, String> uhrzeitCol = new TableColumn<TerminTO, String>("Uhrzeit");
		uhrzeitCol.setMinWidth(100);
		uhrzeitCol.setCellValueFactory(
				new PropertyValueFactory<TerminTO, String>("uhrzeit"));
		
		TableColumn<TerminTO, Integer> DatumCol = new TableColumn<TerminTO, Integer>("Patient");
		DatumCol.setMinWidth(100);
		DatumCol.setCellValueFactory(
				new PropertyValueFactory<TerminTO, Integer>("patientID"));
		
		TableColumn<TerminTO, Boolean> wahrgenCol = new TableColumn<TerminTO, Boolean>("isWahrgenommen");
		wahrgenCol.setMinWidth(100);
		wahrgenCol.setCellValueFactory(
				new PropertyValueFactory<TerminTO, Boolean>("wahrgenommen"));
		
		table_termine.setItems(data);
		table_termine.getColumns().clear();
		table_termine.getColumns().addAll(terminCol, datumCol, uhrzeitCol, DatumCol, wahrgenCol);
		
	}
}
