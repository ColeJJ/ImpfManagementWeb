package dlg.menue;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ScreensController extends StackPane{
	
	private HashMap<String, Node> screens = new HashMap<>();
	public static String sourcePath = "";
	private HauptmenueService awkService;
	
	public ScreensController(){
		super();
	}
	
	public void addScreen(String name, Node screen) { 
	       screens.put(name, screen); 
	   } 
	
	public boolean loadScreen(String name, String resource) { 
		System.out.println("ID: "+name);
		System.out.println("Resource: "+resource);

		String file = System.getProperty("user.dir")+"/bin/"+resource;
//		System.out.println(file);
		
	    try { 

	       FXMLLoader myLoader = new FXMLLoader();
	       File f = new File(file);
	       URL url = f.toURI().toURL();
	       myLoader.setLocation(url);
//	       System.out.println("Location: "+myLoader.getLocation());
	       
	       Parent loadScreen = (Parent) myLoader.load(); 
	       ControlledScreen myScreenControler = 
	              ((ControlledScreen) myLoader.getController()); 
	       myScreenControler.setScreenParent(this); 
	       addScreen(name, loadScreen); 
	       System.out.println("Anzahl Screens: "+screens.size());
	       return true; 
	     }catch(Exception e) { 
	    	 System.out.println("Fehler beim laden von "+file);
	    	 System.out.println(e.getMessage()); 
	    	 return false; 
	     }
	     
	}
	
	public boolean setScreen(final String name) { 

		/* kleine Animation = langsames Einblenden bzw. Ausblenden */
		
//	     if(screens.get(name) != null) { //screen loaded 
//	       final DoubleProperty opacity = opacityProperty(); 
//
//	       //Is there is more than one screen 
//	       if(!getChildren().isEmpty()){ 
//	         Timeline fade = new Timeline( 
//	           new KeyFrame(Duration.ZERO, new KeyValue(opacity,1.0)), 
//	           new KeyFrame(new Duration(1000), 
//	       		   new EventHandler() {
//	                 @Override 
//	                 public void handle(Event t) { 
//	                   //remove displayed screen 
//	                   getChildren().remove(0); 
//	                   //add new screen 
//	                   getChildren().add(0, screens.get(name)); 
//	                   Timeline fadeIn = new Timeline(
//	                		new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)), 
//	                		new KeyFrame(new Duration(800),new KeyValue(opacity, 1.0))); 
//	                   fadeIn.play();
//					}
//	               }, new KeyValue(opacity, 0.0))); 
//	         fade.play(); 
//	       } else { 
//	         //no one else been displayed, then just show 
//	         setOpacity(0.0); 
//	         getChildren().add(screens.get(name)); 
//	         Timeline fadeIn = new Timeline(
//	        		new KeyFrame(Duration.ZERO,new KeyValue(opacity, 0.0)),
//	        		new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0))
//	        		); 
//	         fadeIn.play(); 
//	       } 
//	       return true; 
//	     } else { 
//	         System.out.println("screen hasn't been loaded!\n"); 
//	         return false; 
//	   } 
	     
	    /*    */
		Node screenToRemove;
        if(screens.get(name) != null){   //screen loaded
        	 if(!getChildren().isEmpty()){    //if there is more than one screen
        		 	getChildren().add(0, screens.get(name));     //add the screen
        		 	screenToRemove = getChildren().get(1);
        		 	getChildren().remove(1);                    //remove the displayed screen
        	 }else{
        		 getChildren().add(screens.get(name));       //no one else been displayed, then just show
        	}
        	return true;
         }else {
        	 System.out.println("screen hasn't been loaded!!! \n");
        	 return false;
         }     
	}
	
	public boolean unloadScreen(String name) { 
		if(screens.remove(name) == null) { 
			System.out.println("Screen didn't exist"); 
	        return false; 
	      } else { 
	           return true; 
	       } 
	}

	public void print() {
		Set<String> keys = screens.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()){
			System.out.println("key: "+it.next());
		} 
		
	} 
	
	public HauptmenueService getAwkService(){
		return this.awkService;
	}
	
	public void setAwkService(HauptmenueService aService){
		this.awkService = aService;
	}
}
