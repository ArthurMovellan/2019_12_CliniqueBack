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

import fr.adaming.model.Salle;
import fr.adaming.services.ISalleService;

@RestController
@RequestMapping("salle")
@CrossOrigin(origins = "http://localhost:4200")
public class SalleController {

	@Autowired
	ISalleService salleService;

	@GetMapping()
	public List<Salle> getAllSalle() {
		return salleService.getAllSalle();
	}

	@GetMapping("/{id}")
	public Salle getSalleById(@PathVariable long id) {
		return salleService.getSalleById(id);
	}

	@DeleteMapping("/{id}")
	public boolean delSalleById(@PathVariable long id) {
		try{
			salleService.supSalle(id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@PostMapping()
	public boolean addSalle(@RequestBody Salle salle) {
		salleService.saveSalle(salle);
		return true;
	}

	@PutMapping("/{id}")
	public boolean updateSalle(@RequestBody Salle salle, @PathVariable long id) {
		salle.setId(id);
		salleService.modifSalle(salle);
		return true;
	}
}
