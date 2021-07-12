package dlg.termineverwaltung;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import awk.patientenverwaltung.entity.PatientTO;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;

public class TerminAnlegenController implements Initializable, ControlledScreen{

	@FXML DatePicker dp_datum;
	@FXML TextField tf_uhrzeit;
	@FXML ComboBox<PatientTO> cb_patient;
	@FXML Button bt_anlegen;
	@FXML Button bt_abbruch;
	@FXML Button bt_refresh;
	
	ScreensController myController;
	
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Button deaktivieren, bis alle Felder ausgefüllt sind
		bt_anlegen.disableProperty().bind(
				tf_uhrzeit.textProperty().isEmpty()
				.or(cb_patient.valueProperty().isNull())
		        .or (dp_datum.valueProperty().isNull()));
	}
	
	//Init Methods
	
	private void initGui() {
		dp_datum.setValue(null);
		cb_patient.setValue(null);
		tf_uhrzeit.setText("");
	}
	
	private void initPatientChoiceBox() {
		Collection<PatientTO>patientenListe = new ArrayList<PatientTO>();
		
		try {
			patientenListe = myController.getAwkService().getPatientenSuchenRemote().getAllPatientenR();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Patienten konnten nicht initialisiert werden.");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		ObservableList<PatientTO> data = FXCollections.observableArrayList(patientenListe);
		
		cb_patient.setItems(data);
	}
	
	//Buttons
	
	public void buttonAnlegenClicked() {
		LocalDate datum = dp_datum.getValue();
		String uhrzeit = tf_uhrzeit.getText();
		PatientTO aPatient = cb_patient.getValue();
		int patientID = aPatient.getPatientenID();
		System.out.println(patientID);
		boolean ok = false;
		
		
		try {
			ok = myController.getAwkService().getTerminePflegenRemote().terminAnlegenR(patientID, datum, uhrzeit, patientID);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
		}
		
		if (ok) {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Termin wurde angelegt!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
			
			this.buttonAbbruchClicked();
		}
		else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Fehler beim Anlegen des Termins!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
	}
	
	public void buttonAbbruchClicked() {
		initGui();
		myController.setScreen(Hauptmenue.TERMVW_SCREEN);
	}
	
	@FXML
	public void buttonRefreshClicked() {
		System.out.println("Refresh Patienten");
		initPatientChoiceBox();
	}
}
