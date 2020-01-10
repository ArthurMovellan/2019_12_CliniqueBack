package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Etat;
import fr.adaming.repository.IEtatRepository;

@Service
public class EtatService implements IEtatService{

	@Autowired
	IEtatRepository etatRepository;
	
	public void saveEtat(Etat etat) {
		etatRepository.save(etat);
	}
	
	public void modifEtat(Etat etat) {
		etatRepository.save(etat);
	}
	
	public void supEtat(long idEtat) {
		etatRepository.deleteById(idEtat);
	}
	
	public Etat getEtatById(long idEtat) {
		return etatRepository.findById(idEtat).get();
	}
	
	public List<Etat> getAllEtat(){
		return etatRepository.findAll();
	}

}
