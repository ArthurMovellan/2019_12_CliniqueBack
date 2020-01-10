package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Service;
import fr.adaming.repository.IServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService{
	@Autowired
	IServiceRepository serviceRepository;
	
	public void saveService(Service service) {
		serviceRepository.save(service);
	}
	
	public void modifService(Service service) {
		serviceRepository.save(service);
	}
	
	public void supService (long idService) {
		serviceRepository.deleteById(idService);
	}
	
	public Service getServiceById(long idService) {
		return serviceRepository.findById(idService).get();
	}
	
	public List<Service> getAllService(){
		return serviceRepository.findAll();
	}
}
