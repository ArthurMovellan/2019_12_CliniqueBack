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

import fr.adaming.model.Service;
import fr.adaming.services.IServiceService;

@RestController
@RequestMapping("service")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {

	@Autowired
	IServiceService serviceService;

	@GetMapping()
	public List<Service> getAllService() {
		return serviceService.getAllService();
	}

	@GetMapping("/{id}")
	public Service getServiceById(@PathVariable long id) {
		return serviceService.getServiceById(id);
	}

	@DeleteMapping("/{id}")
	public boolean delServiceById(@PathVariable long id) {
		try{
			serviceService.supService(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@PostMapping()
	public boolean addService(@RequestBody Service service) {
		serviceService.saveService(service);
		return true;
	}

	@PutMapping("/{id}")
	public boolean updateService(@RequestBody Service service, @PathVariable long id) {
		service.setId(id);
		serviceService.modifService(service);
		return true;
	}
}
