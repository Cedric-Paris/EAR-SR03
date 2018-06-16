package fr.car;

public class MotorisationTemplate {
	private String id;
	private String nomMoteur;
	private String puissance;
	private String prix;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNomMoteur() {
		return nomMoteur;
	}
	public void setNomMoteur(String nomMoteur) {
		this.nomMoteur = nomMoteur;
	}
	public String getPuissance() {
		return puissance+" CV";
	}
	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	
	
}
