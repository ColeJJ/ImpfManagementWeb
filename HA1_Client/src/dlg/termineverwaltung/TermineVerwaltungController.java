package dlg.termineverwaltung;

import java.io.Serializable;

import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TermineVerwaltungController implements Serializable, ControlledScreen{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -282948812825640007L;
	
	
	@FXML Button bt_TerminAnlegen;
	@FXML Button bt_ZurueckHauptmenue;
	@FXML Button bt_ImpfungErfassen;
	
	ScreensController myController;
	
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
		
	}
	
	@FXML 
	public void buttonTerminAnlegenClicked() {
		System.out.println("Starte TerminAnlegen");
		myController.setScreen(Hauptmenue.TERMANLEGEN_SCREEN);
	}
	
	@FXML 
	public void buttonZurueckHauptmenueClicked() {
		myController.setScreen(Hauptmenue.MAIN_SCREEN);
	}
	
	@FXML
	public void buttonImpfungErfassenClicked() {
		myController.setScreen(Hauptmenue.IMPFERFASSEN_SCREEN);
	}

}
