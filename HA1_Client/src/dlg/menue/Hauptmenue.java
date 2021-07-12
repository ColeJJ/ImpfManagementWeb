package dlg.menue;

import java.util.Optional;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;


public class Hauptmenue extends Application{
	
	private Stage mainStage;
	private static HauptmenueService awkService;
	
	public static final String MAIN_SCREEN = "main";
	public static final String MAIN_SCREEN_FXML = "dlg/menue/Hauptmenue.fxml";
	public static final String PATVW_SCREEN = "PatientVerwaltungController";
	public static final String PATVW_SCREEN_FXML = "dlg/patientenverwaltung/PatientenVerwaltung.fxml";
	public static final String PATANLEGEN_SCREEN = "PatientAnlegenController";
	public static final String PATANLEGEN_SCREEN_FXML = "dlg/patientenverwaltung/PatientenAnlegen.fxml";
	public static final String VAKVW_SCREEN = "VakzineVerwaltungController";
	public static final String VAKVW_SCREEN_FXML = "dlg/vakzineverwaltung/VakzineVerwaltung.fxml";
	public static final String CHARGEERFASSEN_SCREEN = "ImpfstoffchargeErfassen";
	public static final String CHARGEERFASSEN_SCREEN_FXML = "dlg/vakzineverwaltung/ImpfstoffchargeErfassen.fxml";
	public static final String DOSENANZEIGE_SCREEN = "AnzeigeImpfdosenMenge";
	public static final String DOSENANZEIGE_SCREEN_FXML = "dlg/vakzineverwaltung/AnzeigeImpfdosenMenge.fxml";
	public static final String TERMVW_SCREEN = "TerminVerwaltungController";
	public static final String TERMVW_SCREEN_FXML = "dlg/termineverwaltung/TermineVerwaltung.fxml";
	public static final String TERMANLEGEN_SCREEN = "TerminAnlegenController";
	public static final String TERMANLEGEN_SCREEN_FXML = "dlg/termineverwaltung/TerminAnlegen.fxml";
	public static final String IMPFERFASSEN_SCREEN = "ImpfungErfassen";
	public static final String IMPFERFASSEN_SCREEN_FXML = "dlg/termineverwaltung/ImpfungErfassen.fxml";
	  
	@Override
	public void start(Stage primaryStage){
		this.mainStage = primaryStage;
		
		
		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(Hauptmenue.MAIN_SCREEN, Hauptmenue.MAIN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.PATVW_SCREEN, Hauptmenue.PATVW_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.PATANLEGEN_SCREEN, Hauptmenue.PATANLEGEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.VAKVW_SCREEN, Hauptmenue.VAKVW_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.CHARGEERFASSEN_SCREEN, Hauptmenue.CHARGEERFASSEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.DOSENANZEIGE_SCREEN, Hauptmenue.DOSENANZEIGE_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.TERMVW_SCREEN, Hauptmenue.TERMVW_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.TERMANLEGEN_SCREEN, Hauptmenue.TERMANLEGEN_SCREEN_FXML);
		mainContainer.loadScreen(Hauptmenue.IMPFERFASSEN_SCREEN, Hauptmenue.IMPFERFASSEN_SCREEN_FXML);
		
		mainContainer.setAwkService(awkService);
		
		mainContainer.setScreen(Hauptmenue.MAIN_SCREEN);
		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(confirmCloseEventHandler);
		primaryStage.show();
		
	}
	
	private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
    	//Quelle: http://stackoverflow.com/questions/29710492/javafx-internal-close-request
        Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to exit?"
        );
        Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(
                ButtonType.OK
        );
        exitButton.setText("Exit");
        closeConfirmation.setHeaderText("Confirm Exit");
        closeConfirmation.initModality(Modality.APPLICATION_MODAL);
        closeConfirmation.initOwner(mainStage);

        // normally, you would just use the default alert positioning,
        // but for this simple sample the main stage is small,
        // so explicitly position the alert so that the main window can still be seen.
        closeConfirmation.setX(mainStage.getX() + 150);
        closeConfirmation.setY(mainStage.getY() - 300 + mainStage.getHeight());

        Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
        if (!ButtonType.OK.equals(closeResponse.get())) {
            event.consume();
        }
    };
	
	public static void main(String[] args, HauptmenueService aService) {	
		awkService = aService;
		launch(args);
	}

}
