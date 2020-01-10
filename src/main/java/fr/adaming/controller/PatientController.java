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

import fr.adaming.model.Patient;
import fr.adaming.services.IPatientService;

@RestController
@RequestMapping("patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	IPatientService patientService;

	@GetMapping()
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}

	@GetMapping("/{id}")
	public Patient getPatientById(@PathVariable long id) {
		return patientService.getPatientById(id);
	}

	@DeleteMapping("/{id}")
	public boolean delPatientById(@PathVariable long id) {
		try{
			patientService.supPatient(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@PostMapping()
	public Patient addPatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	@PutMapping("/{id}")
	public Patient updatePatient(@RequestBody Patient patient, @PathVariable long id) {
		patient.setId(id);
		return patientService.modifPatient(patient);
	}
	
	@PutMapping("/{idP}/etat{idE}")
	public boolean affecterEtatPatient(@PathVariable long idP, @PathVariable long idE) {
		patientService.affecterEtatPatient(idP, idE);
		return true;
	}

}
