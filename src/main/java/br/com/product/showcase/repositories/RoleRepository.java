package br.com.product.showcase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.product.showcase.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByRole(String role);

}
