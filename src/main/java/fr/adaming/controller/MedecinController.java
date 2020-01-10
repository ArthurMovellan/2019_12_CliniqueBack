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

import fr.adaming.model.Medecin;
import fr.adaming.services.IMedecinService;

@RestController
@RequestMapping("medecin")
@CrossOrigin(origins = "http://localhost:4200")
public class MedecinController {

	@Autowired
	IMedecinService medecinService;

	@GetMapping()
	public List<Medecin> getAllMedecin() {
		return medecinService.getAllMedecin();
	}

	@GetMapping("/{id}")
	public Medecin getMedecinById(@PathVariable long id) {
		return medecinService.getMedecinById(id);
	}

	@DeleteMapping("/{id}")
	public boolean delMedecinById(@PathVariable long id) {
		try {
			medecinService.supMedecin(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PostMapping()
	public Medecin addMedecin(@RequestBody Medecin medecin) {
		return medecinService.saveMedecin(medecin);
	}

	@PutMapping("/{id}")
	public Medecin updateMedecin(@RequestBody Medecin medecin, @PathVariable long id) {
		medecin.setId(id);
		return medecinService.modifMedecin(medecin);
	}

	@PutMapping("/{idM}/service{idS}")
	public boolean affecterServiceMedecin(@PathVariable long idM, @PathVariable long idS) {
		medecinService.affecterServiceMedecin(idM, idS);
		return true;
	}
}
