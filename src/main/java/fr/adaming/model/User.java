package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String login;
	private String motDePasse;
	private String email;

	// Constructeurs
	public User() {
		super();
	}

	public User(String login, String motDePasse, String email) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.email = email;
	}

	// Getters and setters
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// ToString
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", motDePasse=" + motDePasse + ", email=" + email + "]";
	}

}
