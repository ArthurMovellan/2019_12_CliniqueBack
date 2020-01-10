package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_patient")
public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	private String prenom;
	private Etat etat;
	private String dossierMedical;
	
	//Constructeurs
	public Patient() {
		super();
	}
	public Patient(String nom, String prenom, Etat etat, String dossierMedical) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.etat = etat;
		this.dossierMedical = dossierMedical;
	}
	
	//Getters and setters
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@OneToOne
	@JoinColumn(name="id_etat")
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public String getDossierMedical() {
		return dossierMedical;
	}
	public void setDossierMedical(String dossierMedical) {
		this.dossierMedical = dossierMedical;
	}
	
	//toString
	@Override
	public String toString() {
		return "Patient [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", etat=" + etat + ", dossierMedical="
				+ dossierMedical + "]";
	}
	
	
}
