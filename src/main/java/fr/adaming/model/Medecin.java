package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_medecin")
public class Medecin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	private String prenom;
	private Service service;
	
	//Constructeurs
	public Medecin() {
		super();
	}
	public Medecin(String nom, String prenom, Service service) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.service = service;
	}
	
	//getters and setters
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
	@ManyToOne
	@JoinColumn(name="id_service")
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	//toString
	@Override
	public String toString() {
		return "Medecin [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", service=" + service + "]";
	}
	
	
}
