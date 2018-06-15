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
public class GestFinition
{
	private List<FinitionTemplate> finitionTemplate;
	
	@PostConstruct
	public void init()
	{
		this.finitionTemplate = new ArrayList<FinitionTemplate>();	
		
		Client client = ClientBuilder.newClient();
		
		this.finitionTemplate = client.target("http://localhost:8080/WebServiceSR03/req/finitions")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<FinitionTemplate>>() {});
	}

	public List<FinitionTemplate> getFinitionTemplate() {
		return finitionTemplate;
	}

	public void setFinitionTemplate(List<FinitionTemplate> finitionTemplate) {
		this.finitionTemplate = finitionTemplate;
	}
	
	
}
