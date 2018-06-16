package sr03.utc.fr;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.*;

/**
 * Session Bean implementation class Request
 */
@Stateless
public class Request implements RequestLocal
{

	@PersistenceContext(name = "JBA_SR03")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public Request() {
        // TODO Auto-generated constructor stub
    }
    
    @SuppressWarnings("unchecked")
	public List<String> getColorNames()
    {
    	Query q = em.createQuery("select c.couleur from Couleur c");
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<String> getColors()
    {
    	Query q = em.createQuery("select c from Couleur c");
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Modele> getModeles()
    {
    	Query q = em.createQuery("SELECT m FROM Modele m");
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Modele> getFinitions()
    {
    	Query q = em.createQuery("SELECT m FROM TypeFinition m");
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<TypeFinition> getTypeFinitionByModele(Integer modeleId){
		 		
		 Query q = em.createQuery("SELECT m.typeFinitions FROM Modele m WHERE m.id =:modele ");
		 q.setParameter("modele", modeleId);
		 
		 return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Motorisation> getMotorisations()
    {
    	Query q = em.createQuery("SELECT m FROM Motorisation m");
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Motorisation> getMotorisationByFinition(Integer finitionId){
		 Query q = em.createQuery("SELECT m.motorisations FROM TypeFinition m WHERE m.id =:finition ");
		 q.setParameter("finition", finitionId);
		 return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Motorisation> getColorByFinition(Integer finitionId){
		 Query q = em.createQuery("SELECT m.couleurs FROM TypeFinition m WHERE m.id =:finition ");
		 q.setParameter("finition", finitionId);
		 return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Motorisation> getTypeJanteByFinition(Integer finitionId){
		 Query q = em.createQuery("SELECT m.typeJantes FROM TypeFinition m WHERE m.id =:finition ");
		 q.setParameter("finition", finitionId);
		 return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Motorisation> getOptionSupByFinition(Integer finitionId){
		 Query q = em.createQuery("SELECT m.optionSups FROM TypeFinition m WHERE m.id =:finition ");
		 q.setParameter("finition", finitionId);
		 return q.getResultList();
    }
    
	@SuppressWarnings("unchecked")
	public List<OptionSup> getOptionSupForVoiture(int voitureId)
    {
    	Query q = em.createQuery("SELECT op"
    							+ "FROM option_sup op"
    							+ "JOIN op.voitures v"
    							+ "WHERE v.id = :id");
    	q.setParameter(":id", voitureId);
		return q.getResultList();
    }

}
