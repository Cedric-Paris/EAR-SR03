package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the voiture database table.
 * 
 */
@Entity
@NamedQuery(name="Voiture.findAll", query="SELECT v FROM Voiture v")
public class Voiture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nom;

	//bi-directional many-to-one association to Couleur
	@JsonIgnore
	@ManyToOne
	private Couleur couleur;

	//bi-directional many-to-one association to Modele
	@JsonIgnore
	@ManyToOne
	private Modele modele;

	//bi-directional many-to-one association to Motorisation
	@JsonIgnore
	@ManyToOne
	private Motorisation motorisation;

	//bi-directional many-to-many association to OptionSup
	@JsonIgnore
	@ManyToMany
	@JoinTable(
		name="voiture_option_sup"
		, joinColumns={
			@JoinColumn(name="voiture_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="option_sup_id")
			}
		)
	private List<OptionSup> optionSups;

	//bi-directional many-to-one association to TypeFinition
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="type_finition_id")
	private TypeFinition typeFinition;

	//bi-directional many-to-one association to TypeJante
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="type_jante_id")
	private TypeJante typeJante;

	public Voiture() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Modele getModele() {
		return this.modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public Motorisation getMotorisation() {
		return this.motorisation;
	}

	public void setMotorisation(Motorisation motorisation) {
		this.motorisation = motorisation;
	}

	public List<OptionSup> getOptionSups() {
		return this.optionSups;
	}

	public void setOptionSups(List<OptionSup> optionSups) {
		this.optionSups = optionSups;
	}

	public TypeFinition getTypeFinition() {
		return this.typeFinition;
	}

	public void setTypeFinition(TypeFinition typeFinition) {
		this.typeFinition = typeFinition;
	}

	public TypeJante getTypeJante() {
		return this.typeJante;
	}

	public void setTypeJante(TypeJante typeJante) {
		this.typeJante = typeJante;
	}

}