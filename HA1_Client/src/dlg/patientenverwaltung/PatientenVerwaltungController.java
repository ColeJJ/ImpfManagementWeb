package dlg.patientenverwaltung;

import java.io.Serializable;

import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PatientenVerwaltungController implements Serializable, ControlledScreen{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2908840259275360540L;
	
	@FXML Button bt_kundeAnlegen;
	@FXML Button bt_zurueckHauptmenue;
	
	ScreensController myController;
	
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;	
	}
	
	@FXML
	public void patientenAnlegenClicked() {
		myController.setScreen(Hauptmenue.PATANLEGEN_SCREEN);
	}
	
	@FXML
	public void zurueckHauptmenueClicked() {
		myController.setScreen(Hauptmenue.MAIN_SCREEN);
	}

}
