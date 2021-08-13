package rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import de.awk.facade.IKundeFacade;
//import de.awk.model.Kunde;


@RequestScoped
@Path("/hello")
public class HelloEndpoint {


	
	  // This method is called if TEXT_PLAIN is request
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  @Path("sayplaintexthello/{param}")
	  public String sayPlainTextHello(@PathParam("param") String name) {
	    return "Hallo " + name + " Web im Plain-Text-Format";
	  }
	  
	  // This method is called if XML is request
	  @GET
	  @Produces(MediaType.TEXT_XML)
	  @Path("sayxmlhello")
	  public String sayXMLHello() {
	    return "<?xml version=\"1.0\"?>" + "<hello> Hallo Web im XML-Format" + "</hello>";
	  }

	  // This method is called if HTML is request
	  @GET
	  @Produces(MediaType.TEXT_HTML)
	  @Path("sayhtmlhello")
	  public String sayHtmlHello() {
	    return "<html> " + "<title>" + "Hello Studies" + "</title>"
	        + "<body><h3>" + "Hallo Web im HTML-Format" + "</body></h3>" + "</html> ";
	  }
	
	  // This method is called if JSON is request
	  @GET
	  @Produces("application/json")
	  @Path("getartikelinjason")
	  public Artikel getArtikelInJSON() {
		  
		  Artikel aArtikel = new Artikel();
		  aArtikel.setId(1);
		  aArtikel.setName("iPhone 6s");
		  aArtikel.setPreis(599.95);
		  
	    return aArtikel;
	  }
	  
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  @Path("getauftrag")
	  public Auftrag getAuftragInJSON() {
		  Auftrag aAuftrag = new Auftrag(1);
		  
		  Artikel aArtikel1 = new Artikel();
		  aArtikel1.setId(1);
		  aArtikel1.setName("iPhone 6s");
		  aArtikel1.setPreis(599.95);
		  
		  Auftragsposition aPos1 = new Auftragsposition(1, "iPhone", 500.0, 2, 1000.0, aArtikel1);
		  aAuftrag.addAuftragsposition(aPos1);
		  
		  Artikel aArtikel2 = new Artikel();
		  aArtikel2.setId(2);
		  aArtikel2.setName("Nexus 6");
		  aArtikel2.setPreis(399.95);
		  Auftragsposition aPos2 = new Auftragsposition(2, "Nexus 6 Handy", 350.0, 3, 1050.0, aArtikel2);
		  aAuftrag.addAuftragsposition(aPos2);
		  
	    return aAuftrag;
	  }
	  
	  
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  @Path("getAuftragByID/{param}")
	  public Auftrag getAuftragByID(@PathParam("param") int key) {
		  
		  Artikel aArtikel1 = new Artikel();
		  aArtikel1.setId(1);
		  aArtikel1.setName("iPhone 6s");
		  aArtikel1.setPreis(600.00);
		  Artikel aArtikel2 = new Artikel();
		  aArtikel2.setId(2);
		  aArtikel2.setName("Nexus 6");
		  aArtikel2.setPreis(300.00);
		  Artikel aArtikel3 = new Artikel();
		  aArtikel2.setId(3);
		  aArtikel2.setName("Samsung Galaxy 7");
		  aArtikel2.setPreis(550.00);		  
		  
		  AuftragListe aListe = new AuftragListe();
		  
		  Auftrag aAuftrag1 = new Auftrag(4711);
		  Auftragsposition pos1 = new Auftragsposition(1, "iPhone", 590.0, 1, 590.0, aArtikel1);
		  aAuftrag1.addAuftragsposition(pos1);
		  aListe.addAuftrag(aAuftrag1);
		  
		  
		  Auftrag aAuftrag2 = new Auftrag(4712);
		  pos1 = new Auftragsposition(1, "Nexus6", 290.0, 1, 290.0, aArtikel2);
		  aAuftrag2.addAuftragsposition(pos1);
		  aListe.addAuftrag(aAuftrag2);
		  
		  Auftrag aAuftrag3 = new Auftrag(4713);
		  pos1 = new Auftragsposition(1, "Samsung", 490.0, 1, 490.0, aArtikel3);
		  Auftragsposition pos2 = new Auftragsposition(2, "iPhone", 590.0, 1, 590.0, aArtikel1);
		  aAuftrag3.addAuftragsposition(pos1);
		  aAuftrag3.addAuftragsposition(pos2);
		  aListe.addAuftrag(aAuftrag3);
		  
		  Auftrag aAuftrag = aListe.getAuftragById(key);
		  
	    return aAuftrag;
	  }
	  
}
