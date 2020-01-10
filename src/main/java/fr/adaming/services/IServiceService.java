package fr.adaming.services;

import java.util.List;

import fr.adaming.model.Service;

public interface IServiceService {
	
	public void saveService(Service service);

	public void modifService(Service service);

	public Service getServiceById(long idService);

	public List<Service> getAllService();

	public void supService (long idService);
}
