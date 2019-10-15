package br.com.product.showcase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.product.showcase.entity.Role;
import br.com.product.showcase.entity.User;
import br.com.product.showcase.repositories.RoleRepository;
import br.com.product.showcase.repositories.UserRepository;
import br.com.product.showcase.services.UserService;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
	    this.userRepository = userRepository;
	    this.roleRepository = roleRepository;
	    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public User findUserByEmail(String email) {
	    return userRepository.findByEmail(email);
	}
	
	@Override
	public User saveUser(User user) {
	    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	    user.setActive(1);
	    Role userRole = roleRepository.findByRole("ADMIN");
	    user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	    return userRepository.save(user);
	}
}
