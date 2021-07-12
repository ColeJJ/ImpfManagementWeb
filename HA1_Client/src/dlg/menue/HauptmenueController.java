package dlg.menue;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HauptmenueController implements Initializable, ControlledScreen{
	
	@FXML Button buttonPatVerwaltung;
	@FXML Button buttonBeenden;
	@FXML Button buttonVakVerwaltung;
	@FXML Button buttonTermVerwaltung;
	@FXML Button bt_refresh;
	
	private ScreensController myController;

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	@FXML
	public void beenden() {
		System.out.println("Beenden");
		System.exit(0);
	}
	
	@FXML
	public void buttonPatVerwaltungClicked() {
		System.out.println("Starte PatientenVerwaltung");
		myController.setScreen(Hauptmenue.PATVW_SCREEN);
	}
	
	@FXML
	public void buttonVakVerwaltungClicked() {
		System.out.println("Starte VakzineVerwaltung");
		myController.setScreen(Hauptmenue.VAKVW_SCREEN);
	}
	
	@FXML
	public void buttonTermVerwaltungClicked() {
		System.out.println("Starte TerminVerwaltung");
		myController.setScreen(Hauptmenue.TERMVW_SCREEN);
	}
	
	

}
