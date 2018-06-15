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
public class GestColor {
	
	//http://localhost:8080/SR03_WEB/car/index.xhtml
	
	private List<ColorTemplate> colorTemplate;
	
	@PostConstruct
	public void init()
	{
		this.colorTemplate = new ArrayList<ColorTemplate>();	
		
		Client client = ClientBuilder.newClient();
		
		this.colorTemplate = client.target("http://localhost:8080/WebServiceSR03/req/colors")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<ColorTemplate>>() {});
	}

	public List<ColorTemplate> getColorTemplate() {
		return colorTemplate;
	}

	public void setColorTemplate(List<ColorTemplate> colorTemplate) {
		this.colorTemplate = colorTemplate;
	}

	

}
