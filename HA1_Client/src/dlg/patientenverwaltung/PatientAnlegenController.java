package dlg.patientenverwaltung;


import java.net.URL;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import awk.AnwendungskernException;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;

public class PatientAnlegenController implements Initializable, ControlledScreen {

	@FXML TextField tf_name;
	@FXML TextField tf_vorname;
	@FXML DatePicker dp_geburtsdatum;
	@FXML TextField tf_mail;
	@FXML TextField tf_telefonNr;
	@FXML Button bt_anlegen;
	@FXML Button bt_abbruch;
	
	ScreensController myController;

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initGui();
		
		bt_anlegen.disableProperty().bind(
				tf_vorname.textProperty().isEmpty()
				.or(tf_name.textProperty().isEmpty())
				.or(dp_geburtsdatum.valueProperty().isNull()));
	}
	
	private void initGui() {
		tf_name.setText("");
		tf_vorname.setText("");
		tf_mail.setText("");
		dp_geburtsdatum.setValue(null);
		tf_telefonNr.setText("");
	}
	
	@FXML
	public void buttonPatientAnlegenClicked() {
		//...
		String name = tf_name.getText();
		String vorname = tf_vorname.getText();
		String mail = tf_mail.getText();
		LocalDate geburtsdatum = dp_geburtsdatum.getValue();
		String telefonNr = tf_telefonNr.getText();
		boolean ok = false;
		
		try {
			ok = myController.getAwkService().getPatientenPflegenRemote().patientAnlegenR(name, vorname, geburtsdatum, mail, telefonNr);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
		}
		
		if (ok) {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Patient wurde angelegt!");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
			
			this.buttonAbbruchClicked();
		}
		else {
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Fehler beim Anlegen des Patienten!");
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
		myController.setScreen(Hauptmenue.PATVW_SCREEN);
	}
}
