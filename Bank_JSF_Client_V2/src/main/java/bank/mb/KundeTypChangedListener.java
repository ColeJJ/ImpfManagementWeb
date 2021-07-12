package bank.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import de.bank.kunde.entity.GeschaeftskundeTO;
import de.bank.kunde.entity.PrivatkundeTO;

@SessionScoped
@Named("kundeTypChangedBean")
public class KundeTypChangedListener implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isPrivatkunde = Boolean.FALSE;
	private boolean isGeschaeftskunde = Boolean.FALSE;
	
	
	public KundeTypChangedListener() {
		this.isGeschaeftskunde = Boolean.FALSE;
		this.isPrivatkunde = Boolean.FALSE;
	}

	public void ajaxListener(AjaxBehaviorEvent event)  {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		@SuppressWarnings("deprecation")
		KundeMB kundeMB = (KundeMB)facesContext.getApplication().
				createValueBinding("#{kundeMB}").getValue(facesContext);
		
//		System.out.println("KundeTypChangedListener called "+kundeMB.getKundenArt());
		
		if (kundeMB.getKundenArt().equals("privatkunde")){
			isPrivatkunde = Boolean.TRUE;
			isGeschaeftskunde = Boolean.FALSE;
			kundeMB.setPkTo(new PrivatkundeTO());
			System.out.println("KundeTO in MB zum PrivatkundeTO initialisiert");
			
		} else if (kundeMB.getKundenArt().equals("geschaeftskunde")){
			isPrivatkunde = Boolean.FALSE;
			isGeschaeftskunde = Boolean.TRUE;
			kundeMB.setGkTo(new GeschaeftskundeTO());
			System.out.println("KundeTO in MB zum GeschaeftskundeTO initialisiert");
		} 			
	}
	
	public boolean isPrivatkunde() {
		return isPrivatkunde;
	}

	public void setPrivatkunde(boolean isPrivatkunde) {
		this.isPrivatkunde = isPrivatkunde;
	}

	public boolean isGeschaeftskunde() {
		return isGeschaeftskunde;
	}

	public void setGeschaeftskunde(boolean isGeschaeftskunde) {
		this.isGeschaeftskunde = isGeschaeftskunde;
	}
	
}
