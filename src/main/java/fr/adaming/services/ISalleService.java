package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Salle;

public interface ISalleService {
	
	public void saveSalle(Salle salle);

	public void modifSalle(Salle salle);

	public Salle getSalleById(long idSalle);

	public List<Salle> getAllSalle();

	public void supSalle (long idSalle);
}
