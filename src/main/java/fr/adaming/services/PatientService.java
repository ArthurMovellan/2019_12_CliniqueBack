package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Etat;
import fr.adaming.model.Patient;
import fr.adaming.repository.IEtatRepository;
import fr.adaming.repository.IPatientRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	IPatientRepository patientRepository;
	
	@Autowired
	IEtatRepository etatRepository;
	
	public Patient savePatient (Patient patient) {
		return patientRepository.save(patient);
	}
	
	public Patient modifPatient (Patient patient) {
		return patientRepository.save(patient);
	}
	
	public void supPatient (long idPatient) {
		patientRepository.deleteById(idPatient);
	}
	
	public Patient getPatientById (long idPatient) {
		return patientRepository.findById(idPatient).get();
	}
	
	public List<Patient> getAllPatient (){
		return patientRepository.findAll();
	}

	public boolean affecterEtatPatient(long idPatient, long idEtat) {
		Etat etat = etatRepository.getOne(idEtat);
		Patient patient = patientRepository.getOne(idPatient);
		patient.setEtat(etat);
		patientRepository.save(patient);
		return true;
	}
}
