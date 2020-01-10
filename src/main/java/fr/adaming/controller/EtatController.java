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

import fr.adaming.model.Etat;
import fr.adaming.services.IEtatService;

@RestController
@RequestMapping("etat")
@CrossOrigin(origins = "http://localhost:4200")
//les requetes http commenceront par "http://localhost:8080/etat"
public class EtatController {
	
	@Autowired
	IEtatService etatService;

	@GetMapping() //get sur http://localhost:4200/etat
	public List<Etat> getAllEtat() {
		return etatService.getAllEtat();
	}

	@GetMapping("/{id}") //get sur http://localhost:4200/etat/"n°id"
	public Etat getEtatById(@PathVariable long id) {
		return etatService.getEtatById(id);
	}

	@DeleteMapping("/{id}") //delete sur http://localhost:4200/etat/"n°id"
	public boolean delEtatById(@PathVariable long id) {
		try {
			etatService.supEtat(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PostMapping() //post sur http://localhost:4200/etat
	public boolean addEtat(@RequestBody Etat etat) {
		etatService.saveEtat(etat);
		return true;
	}

	@PutMapping("/{id}") //put sur http://localhost:4200/etat/"n°id"
	public boolean updateEtat(@RequestBody Etat etat, @PathVariable long id) {
		etat.setId(id);
		etatService.modifEtat(etat);
		return true;
	}

}
