package dlg.vakzineverwaltung;

import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ButtonBar.ButtonData;

public class ImpfstoffchargeErfassenController implements Initializable, ControlledScreen{
	
	@FXML ComboBox<String> cb_hersteller;
	@FXML Spinner<Integer> spin_anzahl;
	@FXML DatePicker dp_datumAnlieferung;
	@FXML Button bt_anlegen;
	@FXML Button bt_abbruch;
	@FXML Button bt_refresh;
	
	ScreensController myController;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 1000, 0);
		spin_anzahl.setValueFactory(spinnerValueFactory);
		
		//Button deaktivieren, bis alle Felder ausgefüllt sind
		bt_anlegen.disableProperty().bind(
				dp_datumAnlieferung.valueProperty().isNull()
				.or(cb_hersteller.valueProperty().isNull())
		        .or (spin_anzahl.valueProperty().isNull()));
		
	}

	private void initGui() {
		cb_hersteller.setValue(null);
		spin_anzahl.getValueFactory().setValue(0);
		dp_datumAnlieferung.setValue(null);
	}
	
	private void initHersteller() {
		//Intialisiere Hersteller
		ObservableList<String> data = FXCollections.observableArrayList(
             "Biontech",
             "Moderna",
             "AstraZeneca",
             "Jonhson&Johnson");   
				
		cb_hersteller.setItems(data);		
	}

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	
	
	@FXML
	public void buttonAnlegenClicked() {
		String hersteller = cb_hersteller.getValue();
		int anzahl = spin_anzahl.getValue();
		LocalDate datum = dp_datumAnlieferung.getValue();
		boolean ok = false;
		
		try {
			ok = myController.getAwkService().getChargeErfassenRemote().chargeErfassenR(anzahl, hersteller, datum);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
		}
		
		if (ok) {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Impfstoffcharge wurde angelegt!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
			
			this.buttonAbbruchClicked();
		}
		else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Fehler beim Anlegen der Impfstoffcharge!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}

	}
	
	@FXML
	public void buttonAbbruchClicked() {
		initGui();
		myController.setScreen(Hauptmenue.VAKVW_SCREEN);
	}	
	
	@FXML
	public void buttonRefreshClicked() {
		initHersteller();
	}
}
