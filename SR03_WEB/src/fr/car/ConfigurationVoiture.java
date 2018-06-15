package fr.car;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConfigurationVoiture
{
	private String modeleId;
	private ModeleTemplate modele;
	private GestModele gestModele;
	
	private String finitionId;
	private FinitionTemplate finition;
	private GestFinition gestFinition;
	
	@PostConstruct
	public void init()
	{
		gestModele = new GestModele();
		gestModele.init();
		gestFinition = new GestFinition();
		gestFinition.init();
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

	public GestFinition getGestFinition() {
		return gestFinition;
	}

	public void setGestFinition(GestFinition gestFinition) {
		this.gestFinition = gestFinition;
	}

	public void updateModeleOnIdChanged()
	{
		for(ModeleTemplate mt : gestModele.getModeleTemplate())
		{
			if(mt.getId().equalsIgnoreCase(modeleId))
			{
				this.modele = mt;
				break;
			}
		}
	}
	
}
