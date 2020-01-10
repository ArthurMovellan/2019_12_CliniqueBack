package fr.adaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Service;

public interface IServiceRepository extends JpaRepository<Service, Long>{

}
