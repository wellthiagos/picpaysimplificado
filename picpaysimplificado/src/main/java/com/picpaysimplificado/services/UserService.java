package com.picpaysimplificado.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void validateTransaction(User sender, BigDecimal amaunt) throws Exception {
		if(sender.getUserType().equals(UserType.MERCHANT))
			throw new Exception("Usuário do tipo Logista não está autorizado a realizar uma transação.");
		
		if(sender.getBalance().compareTo(amaunt) < 0)
			throw new Exception("Saldo insuficiente.");
	}
	
	public User findUserById(Long id) throws Exception {
		return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
	}
	
	public User createUser(UserDTO data){
		User newUser = new User(data);
		this.saveUser(newUser);
		return newUser;
	}
	
	public void saveUser(User user) {
		this.userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
