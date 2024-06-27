package com.generation.libreria.controllers;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.generation.libreria.dao.DAOLibri;

@Controller
@RequestMapping("/libri")	//localhost:8080/libri/MAPPING
public class LibriController {
	
	
	@Autowired
	public DAOLibri dl;
	
	//localhost:8080/libri/elenco
	@GetMapping("elenco")
	public String elenco(){
		//Siccome il RequestMapping è diventato /libri, i files html di questa classe
		//devono essere INSERITI all'interno della cartella "libri" in webapp
		//altrimenti Spring non li trova perché il percorso sarà webapp/libri/elencolibri.html
		//In HomeController, non avendo il RequestMapping avremo solo webapp/home.html
		return "/libri/elencolibri.html";
	}
	
	//stampa la mappa di elementi ricavati dal db con daoLibri tra parentesi direttamente
	@GetMapping("stampalibri")
	@ResponseBody
	public String stampa() {
		String ris = "";
		for(Map<String, String> m : dl.leggiTutti())
			ris += m.toString() + " ";
		return ris;
	}
	
	@GetMapping("elencolibri")
	public String elencoLibri(Model model){
		/*Model(che va importato) è come uno scatolo che contine altri elementi etichettati (chiave-valore)
		 * possiamo inserirci qualsiasi cosa a patto che sia etichettato(come le mappe).
		 * usiamo il model perché poi possiamo passarlo ai file .jsp */
		
		model.addAttribute("elencolibri",dl.leggiTutti());
		model.addAttribute("saluto","Ciao!");
		//tutta questa roba viene mandata a elencolibri.jsp
		return "/libri/elencolibri.jsp"; //ritorniamo la root del file da visualizzare
	}
	
	//localhost:8080/libri/eliminalibro?id=IDLIBRO
	/*l'id per eliminare lo riceve tramite @RequestParam("id") che va a prendere il valore dalla chiave con 
	 * nome id nell'url */
	@GetMapping("eliminalibro")
	public String elimina(@RequestParam("id") int idLibro) {
		
		if(dl.delete(idLibro))
			return "redirect:elencolibri"; //redirect per richiamare il mapping per far si che sia tutto aggiornato
		else
			return "Errore nell'eliminazione del libro con id = " + idLibro;
	}
	
	@GetMapping("formnuovolibro")
	public String formnuovolibro(){
		
		return "/libri/formnuovolibro.html";
	}
	
	//http://localhost:8080/libri/
	//nuovolibro?
	//autore=Tolkien&titolo=Il+signore+degli+anelli
	@GetMapping("nuovolibro")
	public String aggiungi(@RequestParam Map<String,String> inputs) {
		
		System.out.println("Mappa dalla REQUEST: " + inputs);
		if(dl.create(inputs))
			return "redirect:elencolibri";
		else
			return "Errore nell'inserimento del nuovo libro";
	}
	
	@GetMapping("dettaglio")
	public String dettaglioLibro(@RequestParam("id") int idLibro, Model model)
	{
		//Dopo che ho cliccato sul libro che voglio vedere nel dettaglio
		//cerco sul DB la mappa che gli corrisponde.
		Map<String, String> mappaLibro = dl.cercaPerId(idLibro);
		//Passo quella mappa al model e reindirizzo l'utente alla pagina
		//libri/dettagliolibro.jsp in modo che i valori siano precaricati
		model.addAttribute("libro",mappaLibro);
		return "/libri/dettaglio.jsp";
	}
	
	//http://localhost:8080/libri/
	//formmodifica?id=1
	@GetMapping("formmodifica")
	public String vaiAllaForm(@RequestParam("id") int idLibro, Model model)
	{
		Map<String, String> mappaLibroDaModificare = dl.cercaPerId(idLibro);
		model.addAttribute("libroModifica",mappaLibroDaModificare);
		return "/libri/formmodificalibro.jsp";
	}
	
	//http://localhost:8080/libri/
	//modificalibro?
	//id=1&autore=Rowling&titolo=Harry+Potter
	@GetMapping("modificalibro")
	public String modifica(@RequestParam Map<String,String> inputs)
	{
		System.out.println("Mappa dalla REQUEST MODIFICA: " + inputs);
		if(dl.update(inputs))
			return "redirect:elencolibri";
		else
			return "Errore nell'inserimento del nuovo libro";
	}
}