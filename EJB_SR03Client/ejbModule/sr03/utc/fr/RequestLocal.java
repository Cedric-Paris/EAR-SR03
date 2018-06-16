package sr03.utc.fr;

import java.util.List;

import javax.ejb.Local;
import javax.persistence.Query;

import model.*;

@Local
public interface RequestLocal
{
	public List<String> getColorNames();
	
	public List<String> getColors();
    
	public List<Modele> getModeles();
	
	public List<Modele> getFinitions();
	
	public List<TypeFinition> getTypeFinitionByModele(Integer modeleId);
	
	public List<Motorisation> getMotorisations();
	
	public List<Motorisation> getMotorisationByFinition(Integer finitionId);
	
	public List<Motorisation> getColorByFinition(Integer finitionId);

	public List<Motorisation> getTypeJanteByFinition(Integer finitionId);
   
	public List<Motorisation> getOptionSupByFinition(Integer finitionId);

	public List<OptionSup> getOptionSupForVoiture(int voitureId);
}
