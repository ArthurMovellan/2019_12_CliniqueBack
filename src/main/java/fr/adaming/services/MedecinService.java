package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Medecin;
import fr.adaming.repository.IMedecinRepository;
import fr.adaming.repository.IServiceRepository;

@Service
public class MedecinService implements IMedecinService{
	@Autowired
	IMedecinRepository medecinRepository;
	
	@Autowired
	IServiceRepository serviceRepository;
	
	public Medecin saveMedecin(Medecin medecin) {
		return medecinRepository.save(medecin);
	}
	
	public Medecin modifMedecin(Medecin medecin) {
		return medecinRepository.save(medecin);
	}
	
	public void supMedecin(long idMedecin) {
		medecinRepository.deleteById(idMedecin);
	}
	
	public Medecin getMedecinById(long idMedecin) {
		return medecinRepository.findById(idMedecin).get();
	}
	
	public List<Medecin> getAllMedecin(){
		return medecinRepository.findAll();
	}

	public boolean affecterServiceMedecin(long idMedecin, long idService) {
		Medecin medecin = medecinRepository.getOne(idMedecin);
		fr.adaming.model.Service service = serviceRepository.getOne(idService);
		medecin.setService(service);
		medecinRepository.save(medecin);
		return true;
	}

}
