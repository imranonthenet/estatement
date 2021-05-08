package com.bsf.estatement;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsf.estatement.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findByUsername(String username);
	Optional<User> findUserByPassword(String password);
	
	List<User> findByPasswordEqualsAndRolesEquals(String password, String role);
}
