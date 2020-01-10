package fr.adaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.adaming.model.User;
import fr.adaming.services.IEtatService;
import fr.adaming.services.IMedecinService;
import fr.adaming.services.IOperationService;
import fr.adaming.services.IPatientService;
import fr.adaming.services.ISalleService;
import fr.adaming.services.IServiceService;
import fr.adaming.services.IUserService;

@SpringBootApplication
public class FirstSpringApplication implements CommandLineRunner{
	
	@Autowired
	IPatientService patientService;
	
	@Autowired
	IEtatService etatService;
	
	@Autowired
	IMedecinService medecinService;
	
	@Autowired
	ISalleService salleService;
	
	@Autowired
	IServiceService serviceService;
	
	@Autowired
	IOperationService operationService;
	
	@Autowired
	IUserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Override en marche");

//		Etat e3 = new Etat();
//		e3.setLibelle("Mort");
//		etatService.saveEtat(e3);
		
//		Patient p1 = new Patient();
//		p1.setNom("Nom");
//		p1.setPrenom("Prenom");
//		p1.setDossierMedical("fghjk");
//		patientService.savePatient(p1);
		
//		patientService.supPatient(2);
		
//		System.out.println(patientService.getPatientById(1));
		
//		System.out.println(patientService.getAllPatient());
		
//		Operation o1 = new Operation();
//		o1.setId(1);
//		o1.setDate(Date.valueOf("2013-12-25"));
//		o1.setMedecin(medecinService.getMedecinById(1));
//		o1.setPatient(patientService.getPatientById(1));
//		o1.setSalle(salleService.getSalleById(1));
//		operationService.modifOperation(o1);
		
//		Operation o1 = operationService.getOperationById(1);
//		o1.setDate(Date.valueOf("2013-12-25"));
//		operationService.modifOperation(o1);
//		o1=operationService.getOperationById(1);
//		System.out.println(o1.getDate());
		
//		patientService.affecterEtatPatient(1, 2);
		
//		operationService.affecterDateOperation(1, "26/11/2019");
		
//		Patient pat = new Patient();
//		pat.setNom("TOto");
//		pat.setPrenom("TITI");
//		pat.setEtat(etatService.getEtatById(1));
//		pat.setDossierMedical("Cancer");
//		patientService.savePatient(pat);
		
//		User u1 = new User();
//		u1.setLogin("Arthur");
//		u1.setMotDePasse("LoL28469");
//		u1.setEmail("arthur.movellan@gmail.com");
//		userService.saveUser(u1);
		
//		System.out.println(userService.getUserbyId(1));
		
//		User u1 = new User();
//		u1.setId(1);
//		u1.setLogin("Arthur");
//		u1.setMotDePasse("LoL28469");
//		u1.setEmail("arthur.movellan@gmail.co");
//		userService.modifUser(u1);
		
//		System.out.println(userService.getAllUser());
		
//		userService.supUser(1);
		
//		System.out.println(userService.getUserbyLogin("fegr"));
	}
	
}
