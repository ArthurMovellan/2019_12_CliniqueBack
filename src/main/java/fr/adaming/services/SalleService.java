package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Salle;
import fr.adaming.repository.ISalleRepository;

@Service
public class SalleService implements ISalleService{
	@Autowired
	ISalleRepository salleRepository;
	
	public void saveSalle(Salle salle) {
		salleRepository.save(salle);
	}
	
	public void modifSalle(Salle salle) {
		salleRepository.save(salle);
	}
	
	public void supSalle(long idSalle) {
		salleRepository.deleteById(idSalle);
	}
	
	public Salle getSalleById(long idSalle) {
		return salleRepository.findById(idSalle).get();
	}
	
	public List<Salle> getAllSalle(){
		return salleRepository.findAll();
	}
}
