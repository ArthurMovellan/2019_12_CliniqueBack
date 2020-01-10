package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Patient;

public interface IPatientService {
	
	public Patient savePatient(Patient patient);

	public Patient modifPatient(Patient patient);

	public Patient getPatientById(long idPatient);

	public List<Patient> getAllPatient();

	public void supPatient(long idPatient);
	
	public boolean affecterEtatPatient(long idEtat, long idPatient);
}
