package br.com.product.showcase.services;

import br.com.product.showcase.entity.User;

public interface UserService {
	
	public User findUserByEmail(String email) ;
	public User saveUser(User user);
	
}
