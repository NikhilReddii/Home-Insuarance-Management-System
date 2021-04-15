package com.cg.hims.service;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.cg.hims.entities.User;
import com.cg.hims.exceptions.InvalidLoginCredentialsException;
import com.cg.hims.exceptions.UserNameAlreadyExistsException;
import com.cg.hims.exceptions.UserNotFoundException;
/**
 * 
 * @author Nikhil
 * Interface of Users in service layerS
 * 
 *
 */
@Service
@Transactional
public interface LoginService {
	public String signup(User user) throws  UserNameAlreadyExistsException;
	public String checkUser(Integer user_id, String password) throws  InvalidLoginCredentialsException,UserNotFoundException;
	public boolean userNameExists(String userName) ;
	String AuthenticateUser(String username, String pwd) throws InvalidLoginCredentialsException,UserNotFoundException;
	String changePassword(String username, String newPassword) throws UserNotFoundException;
	public User getUserById(int id) throws UserNotFoundException;
	

}
