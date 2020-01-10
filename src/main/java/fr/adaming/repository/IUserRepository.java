package fr.adaming.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.adaming.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{

	public List<User> findByLogin(String login);
	public boolean existsUserByLogin(String login);
	public User findByLoginAndMotDePasse(String login, String mdp);
}
