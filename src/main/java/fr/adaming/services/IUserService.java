package fr.adaming.services;

import java.util.List;

import fr.adaming.model.User;

public interface IUserService {

	public void saveUser(User user);
	
	public void modifUser(User user);
	
	public User getUserbyId(long id);
	
	public List<User> getAllUser();
	
	public void supUser(long id);
	
	public List<User> getUserbyLogin(String login);
	
	public boolean existsUserByLogin(String login);
	
	public User findByLoginAndMotDePasse(String login, String mdp);
}
