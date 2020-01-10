package fr.adaming.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.Medecin;
import fr.adaming.model.Operation;
import fr.adaming.model.Patient;
import fr.adaming.model.Salle;
import fr.adaming.repository.IMedecinRepository;
import fr.adaming.repository.IOperationRepository;
import fr.adaming.repository.IPatientRepository;
import fr.adaming.repository.ISalleRepository;

@Service
public class OperationService implements IOperationService{

	@Autowired
	IOperationRepository operationRepository;
	
	@Autowired
	IMedecinRepository medecinRepository;
	
	@Autowired
	IPatientRepository patientRepository;
	
	@Autowired
	ISalleRepository salleRepository;
	
	public Operation saveOperation (Operation operation) {
		return operationRepository.save(operation);
	}
	
	public Operation modifOperation(Operation operation) {
		return operationRepository.save(operation);
	}
	
	public void supOperation(long idOperation) {
		operationRepository.deleteById(idOperation);
	}
	
	public Operation getOperationById(long idOperation) {
		return operationRepository.findById(idOperation).get();
	}
	
	public List<Operation> getAllOperation(){
		return operationRepository.findAll();
	}

	public void affecterMedecinOperation(long idOperation, long idMedecin) {
		Operation operation = operationRepository.getOne(idOperation);
		Medecin medecin = medecinRepository.getOne(idMedecin);
		operation.setMedecin(medecin);
		operationRepository.save(operation);
	}

	public void affecterPatientOperation(long idOperation, long idPatient) {
		Operation operation = operationRepository.getOne(idOperation);
		Patient patient = patientRepository.getOne(idPatient);
		operation.setPatient(patient);
		operationRepository.save(operation);
	}

	public void affecterSalleOperation(long idOperation, long idSalle) {
		Operation operation = operationRepository.getOne(idOperation);
		Salle salle = salleRepository.getOne(idSalle);
		operation.setSalle(salle);
		operationRepository.save(operation);
	}

	public void affecterDateOperation(long idOperation, String dateStr) throws Exception {
		Operation operation = operationRepository.getOne(idOperation);
		if(dateStr.matches("\\d{2}-\\d{2}-\\d{4}")) {
			String jour = dateStr.substring(0, 2);
			String mois = dateStr.substring(3, 5);
			String annee = dateStr.substring(6,10);
			try {
			operation.setDate(Date.valueOf(annee+"-"+mois+"-"+jour));
			operationRepository.save(operation);
			}catch(java.lang.IllegalArgumentException e){
				throw new Exception("format date invalide : la date doit exister");
			}
		}else {
			throw new Exception("format date invalide : la date doit être en format jj/MM/aaaa");
		}
	}
	
	
}
