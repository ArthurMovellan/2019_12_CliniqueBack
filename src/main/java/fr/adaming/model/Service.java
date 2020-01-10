package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_service")
public class Service implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String nom;
	
	//Cosntructeurs
	public Service() {
		super();
	}
	public Service(String nom) {
		super();
		this.nom = nom;
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
	
	//toString
	@Override
	public String toString() {
		return "Service [id=" + id + ", nom=" + nom + "]";
	}
	
}
