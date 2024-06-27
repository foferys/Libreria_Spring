package com.generation.libreria.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//<--- Annotation per dire che è un controller e che questa classe gestisce le request e le response
//è una servlet e non sarà l'unica servlet, possiamo crearne altre mettendo l'annotation @Controller
@Controller 
public class HomeController {
	//gestisce tutte le richieste della home -> sarà la index
	
	/*Non abbiamo piu bisogno del server Tomcat perché ci pensa direttamente Spring tramite le dipendenze nel pom.xml
	 * che importa in automatico la dipendenza di tomcat
	 * 
	 * per le richieste POST si mette l'annotation @PostMapping*/
	
	@GetMapping("")	//localhost:8080/
	public String home() {
		
		return "home.html";
	}
	
	@GetMapping("/test")
	@ResponseBody // <---- serve per stampare direttamente sul browser
	public String test() {
		return "<h1>Ciao!</h1>";
	}
	
	
}