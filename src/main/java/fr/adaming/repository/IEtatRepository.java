package fr.adaming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.Etat;

public interface IEtatRepository extends JpaRepository<Etat, Long>{

}
