package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Operation;
import fr.adaming.services.IOperationService;

@RestController
@RequestMapping("operation")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {

	@Autowired
	IOperationService operationService;

	@GetMapping()
	public List<Operation> getAllOperation() {
		return operationService.getAllOperation();
	}

	@GetMapping("/{id}")
	public Operation getOperationById(@PathVariable long id) {
		return operationService.getOperationById(id);
	}

	@DeleteMapping("/{id}")
	public boolean delOperationById(@PathVariable long id) {
		try{
			operationService.supOperation(id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@PostMapping()
	public Operation addOperation(@RequestBody Operation operation) {
		return operationService.saveOperation(operation);
	}

	@PutMapping("/{id}")
	public Operation updateOperation(@RequestBody Operation operation, @PathVariable long id) {
		operation.setId(id);
		return operationService.modifOperation(operation);
	}
	
	@PutMapping("/{idO}/medecin{idM}")
	public boolean affecterMedecinOperation(@PathVariable long idO, @PathVariable long idM) {
		operationService.affecterMedecinOperation(idO, idM);
		return true;
	}
	
	@PutMapping("/{idO}/patient{idP}")
	public boolean affecterPatientOperation(@PathVariable long idO, @PathVariable long idP) {
		operationService.affecterPatientOperation(idO, idP);
		return true;
	}
	
	@PutMapping("/{idO}/salle{idS}")
	public boolean affecterSalleOperation(@PathVariable long idO, @PathVariable long idS) {
		operationService.affecterSalleOperation(idO, idS);
		return true;
	}
	
	@PutMapping("/{idO}/date{date}")
	public boolean affecterDateOperation(@PathVariable long idO, @PathVariable String date) throws Exception {
		operationService.affecterDateOperation(idO, date);
		return true;
	}
}
