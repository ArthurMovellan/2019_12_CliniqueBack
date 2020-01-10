package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Etat;

public interface IEtatService {

	public void saveEtat(Etat etat);
	
	public void modifEtat(Etat etat);
	
	public Etat getEtatById(long idEtat);
	
	public List<Etat> getAllEtat();
	
	public void supEtat(long idEtat);
}
