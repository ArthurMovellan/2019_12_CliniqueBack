package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Medecin;

public interface IMedecinService {

	public Medecin saveMedecin(Medecin medecin);

	public Medecin modifMedecin(Medecin medecin);

	public Medecin getMedecinById(long idMedecin);

	public List<Medecin> getAllMedecin();

	public void supMedecin(long idMedecin);
	
	public boolean affecterServiceMedecin(long idMedecin, long idService);
}
