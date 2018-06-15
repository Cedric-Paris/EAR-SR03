package fr.car;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

@ManagedBean
@ViewScoped
public class GestModele {
		private List<ModeleTemplate> modeleTemplate;
		
		@PostConstruct
		public void init()
		{
			this.modeleTemplate = new ArrayList<ModeleTemplate>();	
			
			Client client = ClientBuilder.newClient();
			
			this.modeleTemplate = client.target("http://localhost:8080/WebServiceSR03/req/modeles")
					.request(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<ModeleTemplate>>() {});
		}

		public List<ModeleTemplate> getModeleTemplate() {
			return modeleTemplate;
		}

		public void setModeleTemplate(List<ModeleTemplate> modeleTemplate) {
			this.modeleTemplate = modeleTemplate;
		}
		
		
}
