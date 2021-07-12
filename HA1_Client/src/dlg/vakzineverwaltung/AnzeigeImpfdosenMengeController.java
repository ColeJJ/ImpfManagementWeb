package dlg.vakzineverwaltung;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

import awk.AnwendungskernException;
import awk.vakzineverwaltung.entity.ImpfstoffchargeTO;
import dlg.menue.ControlledScreen;
import dlg.menue.Hauptmenue;
import dlg.menue.ScreensController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;

public class AnzeigeImpfdosenMengeController implements Serializable, ControlledScreen{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7824893555082411191L;
	
	@FXML Button bt_zurueck;
	@FXML Button bt_refresh;
	@FXML TableView<ImpfstoffchargeTO> table_dosen;
	
	ScreensController myController;
	

	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;	
	}
	
	private void initGui() {
		table_dosen.getItems().clear();
	}

	@SuppressWarnings({ "unchecked" })
	public void initDosenliste() throws RemoteException{
		Collection<ImpfstoffchargeTO>chargenMengeListe = new ArrayList<ImpfstoffchargeTO>();
		
		try {
			chargenMengeListe = myController.getAwkService().getAnzeigeImpfdosenMengeRemote().anzeigeImpfdosenNachHerstellerR();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (AnwendungskernException e) {
			e.printStackTrace();
			Dialog<String> dialog = new Dialog<>();
			dialog.setContentText("Impfdosenliste konnte nicht initialisiert werden.");
			ButtonType okButtonType = new ButtonType("Ok", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().add(okButtonType);
			boolean disabled = false;
			dialog.getDialogPane().lookupButton(okButtonType).setDisable(disabled);
			dialog.show();
		}
		
		ObservableList<ImpfstoffchargeTO> data = FXCollections.observableArrayList(chargenMengeListe);
		
		//Spalten
		TableColumn<ImpfstoffchargeTO, String> herstellerCol = new TableColumn<ImpfstoffchargeTO, String>("Hersteller");
		herstellerCol.setMinWidth(100);
		herstellerCol.setCellValueFactory(
				new PropertyValueFactory<ImpfstoffchargeTO, String>("hersteller"));
		
		TableColumn<ImpfstoffchargeTO, Integer> MengeCol = new TableColumn<ImpfstoffchargeTO, Integer>("Menge");
		MengeCol.setMinWidth(100);
		MengeCol.setCellValueFactory(
				new PropertyValueFactory<ImpfstoffchargeTO, Integer>("anzahl"));
		
		table_dosen.setItems(data);
		table_dosen.getColumns().clear();
		table_dosen.getColumns().addAll(herstellerCol, MengeCol);
	}
	
	public void buttonZurueckClicked() {
		initGui();
		myController.setScreen(Hauptmenue.VAKVW_SCREEN);
	}	
}
