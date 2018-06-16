package fr.car;

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
public class ConfigurationVoiture
{
	private Client client;
	private String modeleId;
	private ModeleTemplate modele;
	private GestModele gestModele;
	
	private String finitionId;
	private FinitionTemplate finition;
	private List<FinitionTemplate> finitionsTemplate;
	
	private String motorisationId;
	private MotorisationTemplate motorisation;
	private List<MotorisationTemplate> motorisationsTemplate;
	
	private String colorId;
	private ColorTemplate color;
	private List<ColorTemplate> colorsTemplate;
	
	private String typeJanteId;
	private TypeJanteTemplate typeJante;
	private List<TypeJanteTemplate> typeJantesTemplate;
	
	private String optionSupId;
	private OptionSupTemplate optionSup;
	private List<OptionSupTemplate> optionsSupsTemplate;
	
	@PostConstruct
	public void init()
	{
		client = ClientBuilder.newClient();
		
		gestModele = new GestModele();
		gestModele.init();
	}
	
	public String getPrix()
	{
		Integer val = 0;
		if(modele != null) val += Integer.parseInt(modele.getPrix());
		if(finition != null) val += Integer.parseInt(finition.getPrix());
		if(motorisation != null) val += Integer.parseInt(motorisation.getPrix());
		if(color != null) val += Integer.parseInt(color.getPrix());
		if(typeJante != null) val += Integer.parseInt(typeJante.getPrix());
		if(optionSup != null) val += Integer.parseInt(optionSup.getPrix());
		return val.toString();
	}
	
	public String getModeleId() {
		return modeleId;
	}
	public void setModeleId(String modeleId) {
		this.modeleId = modeleId;
	}
	public ModeleTemplate getModele() {
		return modele;
	}
	public void setModele(ModeleTemplate modele) {
		this.modele = modele;
	}
	
	public GestModele getGestModele() {
		return gestModele;
	}

	public void setGestModele(GestModele gestModele) {
		this.gestModele = gestModele;
	}

	public String getFinitionId() {
		return finitionId;
	}

	public void setFinitionId(String finitionId) {
		this.finitionId = finitionId;
	}

	public FinitionTemplate getFinition() {
		return finition;
	}

	public void setFinition(FinitionTemplate finition) {
		this.finition = finition;
	}

	public List<FinitionTemplate> getFinitionsTemplate() {
		return finitionsTemplate;
	}

	public void setFinitionsTemplate(List<FinitionTemplate> finitionsTemplate) {
		this.finitionsTemplate = finitionsTemplate;
	}

	public String getMotorisationId() {
		return motorisationId;
	}

	public void setMotorisationId(String motorisationId) {
		this.motorisationId = motorisationId;
	}

	public MotorisationTemplate getMotorisation() {
		return motorisation;
	}

	public void setMotorisation(MotorisationTemplate motorisation) {
		this.motorisation = motorisation;
	}

	public List<MotorisationTemplate> getMotorisationsTemplate() {
		return motorisationsTemplate;
	}

	public void setMotorisationsTemplate(List<MotorisationTemplate> motorisationsTemplate) {
		this.motorisationsTemplate = motorisationsTemplate;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public ColorTemplate getColor() {
		return color;
	}

	public void setColor(ColorTemplate color) {
		this.color = color;
	}

	public List<ColorTemplate> getColorsTemplate() {
		return colorsTemplate;
	}

	public void setColorsTemplate(List<ColorTemplate> colorsTemplate) {
		this.colorsTemplate = colorsTemplate;
	}

	public String getTypeJanteId() {
		return typeJanteId;
	}

	public void setTypeJanteId(String typeJanteId) {
		this.typeJanteId = typeJanteId;
	}

	public TypeJanteTemplate getTypeJante() {
		return typeJante;
	}

	public void setTypeJante(TypeJanteTemplate typeJante) {
		this.typeJante = typeJante;
	}

	public List<TypeJanteTemplate> getTypeJantesTemplate() {
		return typeJantesTemplate;
	}

	public void setTypeJantesTemplate(List<TypeJanteTemplate> typeJantesTemplate) {
		this.typeJantesTemplate = typeJantesTemplate;
	}

	public String getOptionSupId() {
		return optionSupId;
	}

	public void setOptionSupId(String optionSupId) {
		this.optionSupId = optionSupId;
	}

	public OptionSupTemplate getOptionSup() {
		return optionSup;
	}

	public void setOptionSup(OptionSupTemplate optionSup) {
		this.optionSup = optionSup;
	}

	public List<OptionSupTemplate> getOptionsSupsTemplate() {
		return optionsSupsTemplate;
	}

	public void setOptionsSupsTemplate(List<OptionSupTemplate> optionsSupsTemplate) {
		this.optionsSupsTemplate = optionsSupsTemplate;
	}

	public void updateModeleOnIdChanged()
	{
		this.modele = null;
		for(ModeleTemplate mt : gestModele.getModeleTemplate())
		{
			if(mt.getId().equalsIgnoreCase(modeleId))
			{
				this.modele = mt;
				break;
			}
		}
		if(this.modele != null)
		{
			finitionsTemplate = client.target("http://localhost:8080/WebServiceSR03/req/finitions?mid="+this.modele.getId())
					.request(MediaType.APPLICATION_JSON)
					.get(new GenericType<List<FinitionTemplate>>() {});
		}
		this.finition = null;
		this.finitionId = null;
		motorisationId = null;
		motorisation = null;
		motorisationsTemplate = null;
		colorId = null;
		color = null;
		colorsTemplate = null;
		typeJanteId = null;
		typeJante = null;
		typeJantesTemplate = null;
		optionSupId = null;
		optionSup = null;
		optionsSupsTemplate = null;
	}
	
	public void updateFinitionOnIdChanged()
	{
		this.finition = null;
		for(FinitionTemplate ft : finitionsTemplate)
		{
			if(ft.getId().equalsIgnoreCase(finitionId))
			{
				this.finition = ft;
				break;
			}
		}
		if(this.finition != null)
		{
			motorisationsTemplate = client.target("http://localhost:8080/WebServiceSR03/req/motorisationsfinition?fid="+this.finition.getId())
										.request(MediaType.APPLICATION_JSON)
										.get(new GenericType<List<MotorisationTemplate>>() {});
			colorsTemplate = client.target("http://localhost:8080/WebServiceSR03/req/colorsfinition?fid="+this.finition.getId())
										.request(MediaType.APPLICATION_JSON)
										.get(new GenericType<List<ColorTemplate>>() {});
			typeJantesTemplate = client.target("http://localhost:8080/WebServiceSR03/req/typejantesfinition?fid="+this.finition.getId())
										.request(MediaType.APPLICATION_JSON)
										.get(new GenericType<List<TypeJanteTemplate>>() {});
			optionsSupsTemplate = client.target("http://localhost:8080/WebServiceSR03/req/optionsupsfinition?fid="+this.finition.getId())
										.request(MediaType.APPLICATION_JSON)
										.get(new GenericType<List<OptionSupTemplate>>() {});
		}
		motorisationId = null;
		motorisation = null;
		colorId = null;
		color = null;
		typeJanteId = null;
		typeJante = null;
		optionSupId = null;
		optionSup = null;
	}
	
	public void updateMotorisationOnIdChanged()
	{
		this.motorisation = null;
		for(MotorisationTemplate mt : motorisationsTemplate)
		{
			if(mt.getId().equalsIgnoreCase(motorisationId))
			{
				this.motorisation = mt;
				break;
			}
		}
	}
	
}
