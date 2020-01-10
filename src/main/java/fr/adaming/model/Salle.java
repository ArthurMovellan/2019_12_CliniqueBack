package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_salle")
public class Salle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private int numero;
	private String type;
	
	//Constructeurs
	public Salle() {
		super();
	}
	public Salle(int numero, String type) {
		super();
		this.numero = numero;
		this.type = type;
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
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	//toString
	@Override
	public String toString() {
		return "Salle [id=" + id + ", numero=" + numero + ", type=" + type + "]";
	}
	
	
}
