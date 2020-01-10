package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.model.User;
import fr.adaming.repository.IUserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void modifUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUserbyId(long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void supUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getUserbyLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public boolean existsUserByLogin(String login) {
		return userRepository.existsUserByLogin(login);
	}

	@Override
	public User findByLoginAndMotDePasse(String login, String mdp) {
		User user = userRepository.findByLoginAndMotDePasse(login, mdp);
		if (user!= null) {
			user.setMotDePasse("");
			return user;
		}else {
			return new User();
		}
	}

}
