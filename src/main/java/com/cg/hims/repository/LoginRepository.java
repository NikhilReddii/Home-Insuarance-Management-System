package com.cg.hims.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import  com.cg.hims.entities.User;
/**
 * 
 * @author Nikhil
 *User enity's repository
 *
 */
public interface LoginRepository extends JpaRepository<User,Integer> {
	
//	public String addAccount(User us) throws  UserNameAlreadyExistsException;
	
//	@Query("SELECT u FROM User u WHERE u.user_name = ?1 AND u.password = ?2")
//	User findByUsernameandPassword(String username, String password);
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	Optional<User> findByUsername(String username);	
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1")
	User findByName(String username);	
	
	
	
//	public void checkUser( String userName, String password) throws InvalidLoginCredentialsException;
//
//	public boolean userNameExists(String userName) throws  UserNameAlreadyExistsException ;
//	

}