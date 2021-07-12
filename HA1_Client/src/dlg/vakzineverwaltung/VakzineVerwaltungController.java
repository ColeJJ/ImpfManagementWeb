package dlg.vakzineverwaltung;

import java.io.Serializable;

import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VakzineVerwaltungController implements Serializable, ControlledScreen{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2733896814084154762L;
	
	
	@FXML Button bt_chargeErfassen;
	@FXML Button bt_zurueckHauptmenue;
	@FXML Button bt_dosenHerstellerAnzeigen;
	
	ScreensController myController;
	
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
	}
	
	@FXML
	public void chargeErfassenClicked() {
		myController.setScreen(Hauptmenue.CHARGEERFASSEN_SCREEN);
	}
	
	@FXML
	public void zurueckHauptmenueClicked() {
		myController.setScreen(Hauptmenue.MAIN_SCREEN);
	}
	
	@FXML
	public void buttonDosenHerstellerAnzeigenClicked() {
		myController.setScreen(Hauptmenue.DOSENANZEIGE_SCREEN);
	}
}
