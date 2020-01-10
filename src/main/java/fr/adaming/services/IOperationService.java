package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Operation;

public interface IOperationService {

	public Operation saveOperation(Operation operation);
	
	public Operation modifOperation(Operation operation);
	
	public Operation getOperationById(long idOperation);
	
	public List<Operation> getAllOperation();
	
	public void supOperation(long idOperation);
	
	public void affecterMedecinOperation(long idOperation, long idMedecin);
	
	public void affecterPatientOperation(long idOperation, long idPatient);
	
	public void affecterSalleOperation(long idOperation, long idSalle);
	
	public void affecterDateOperation(long idOperation, String date) throws Exception;
}
