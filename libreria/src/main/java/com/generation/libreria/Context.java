package com.generation.libreria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.generation.libreria.dao.DAOLibri;
import dao.Database;

//le classi con annotation @Configuration sono le classi a cui spring fa rigerimento quando deve creare/costruire oggetti
//spring sa che nelle classi con questa annotation ci saranno i metodi per creare oggetti, come se fossero factory
@Configuration 
public class Context {
	
	// i @Bean sono degli OGGETTI speciali di Spring che vengono instanziati e gestiti in modo speciale.
	//context è come un contenitore di costruttori. Quando nel programma avremo bisogno di creare un oggetto, spring
	//andrà in questa classe a pescare il bean che ci consente di creare quell'oggetto
	@Bean //i bean di default seguono il pattern Singleton anche se non mettiamo l'annotation, metre quando si usa il pattern prototipe bisogna specificarlo (per esempio quando creo i libri)
	@Scope("singleton")  //scope definisce il pattern 
	public Database db() {
		
		return new Database("springlibreria","root","");
	}
	
	@Bean
	public DAOLibri dl() {
		
		return new DAOLibri();
	}
	
	
	
}