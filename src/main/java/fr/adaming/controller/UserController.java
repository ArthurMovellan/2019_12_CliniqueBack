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

import fr.adaming.model.Token;
import fr.adaming.model.User;
import fr.adaming.services.IUserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	Key cle = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	@Autowired
	IUserService userService;

	@PostMapping()
	public boolean addUser(@RequestBody User user) {
		if (userService.existsUserByLogin(user.getLogin())) {
			return false;
		} else {
			userService.saveUser(user);
			return true;
		}
	}

	@PutMapping("/{id}")
	public boolean updateUser(@RequestBody User user, @PathVariable long id) {
		user.setId(id);
		userService.modifUser(user);
		return true;
	}

	@GetMapping()
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/id{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserbyId(id);
	}

	@DeleteMapping("/{id}")
	public boolean delUserById(@PathVariable long id) {
		try {
			userService.supUser(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@GetMapping("/login{login}")
	public List<User> getUserByLogin(@PathVariable String login) {
		return userService.getUserbyLogin(login);
	}

	@PostMapping("/login")
	public Token findByLoginAndMotDePasse(@RequestBody User user) {
		User u = userService.findByLoginAndMotDePasse(user.getLogin(), user.getMotDePasse());
		if (u.getId()!=0) {
			String tok = Jwts.builder()
					.setSubject(u.getLogin()) //mettre le contenu
					.signWith(cle)//mettre la clé pour le decodage
					.compact();//fermer le token pour le construire
			Token token = new Token();
			token.setToken(tok);
			return token;
		}
		return null;
	}
}
