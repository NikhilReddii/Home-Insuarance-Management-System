package com.cg.hims.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.cg.hims.entities.Admin;
import com.cg.hims.entities.Agent;
import com.cg.hims.entities.PolicyHolder;
import com.cg.hims.entities.User;
import com.cg.hims.exceptions.InvalidLoginCredentialsException;
import com.cg.hims.exceptions.UserNameAlreadyExistsException;
import com.cg.hims.exceptions.UserNotFoundException;
import com.cg.hims.repository.AdminRepository;
import com.cg.hims.repository.AgentRepository;
import com.cg.hims.repository.LoginRepository;
import com.cg.hims.repository.PolicyHolderRepository;


/**
 * 
 * @author Nikhil
 * Class for implementing Users layer interface
 *
 */
@Service
@org.springframework.transaction.annotation.Transactional
public class LoginServiceImpl implements LoginService{
	Scanner s=new Scanner(System.in);
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private PolicyHolderRepository phRepository;

	@Override
	public  String signup(User user) throws UserNameAlreadyExistsException{
		try {			
			if(userNameExists(user.userName)==true)
			{
				return "Username already exists";
			}
//			{throw new UserNameAlreadyExistsException("Username already exists");}
			else {
				loginRepository.save(user);
				if(user.getUserRole().toLowerCase().equals("admin"))
				{
				Admin admin=new Admin(user.getUserId(),user.getFirstName()+" "+user.getLastName(),user);
				adminRepository.save(admin);
				}
				else if(user.getUserRole().toLowerCase().equals("agent"))
				{
					Agent agent= new Agent(user.getUserId(),user.getFirstName()+" "+user.getLastName(),user);
					agentRepository.save(agent);
				}
				else if(user.getUserRole().toLowerCase().equals("policyholder"))
				{
					PolicyHolder policyHolder=new PolicyHolder(user.getUserId(),user.getFirstName()+" "+user.getLastName(),user);
					phRepository.save(policyHolder);
				}
				return "Added!";
			}
		}catch(Exception e) {
			throw new UserNameAlreadyExistsException(e.getMessage());
		}
	}



//	@Override
//	public User checkUser(String userName, String password) throws InvalidLoginCredentialsException {
//		try
//		{   User check = u.findByUsernameandPassword(userName, password);
//		if(check==null)
//		{throw new InvalidLoginCredentialsException("Invalid UserName or password! Login Failed");
//		}
//		else {
//			return check;
//		}
//		}
//		catch(Exception e )
//		{throw new InvalidLoginCredentialsException(e.getMessage());}	
//
//	}
    
	@Override
	public String checkUser(Integer userid,String pwd) throws  InvalidLoginCredentialsException,UserNotFoundException{
		try {			
			Optional<User> optional = loginRepository.findById(userid);
			if(optional.isPresent()) {
				User temp = optional.get();
				if(temp.getPassword().equals(pwd)) {
					return "Login Successful";
				}else {
					throw new InvalidLoginCredentialsException("Wrong password");
					//return "Wrong password";
				}
			}else {
				//return "User doesn't exist";
				throw new UserNotFoundException("User doesn't exit");
			}
		}catch(DataAccessException e) {
			throw new InvalidLoginCredentialsException(e.getMessage());
		}
		catch(UserNotFoundException e) {
			throw new UserNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	@Override
	public String AuthenticateUser(String username,String pwd) throws  InvalidLoginCredentialsException,UserNotFoundException{
		try {			
			Optional<User> optional = loginRepository.findByUsername(username);
			if(optional.isPresent()) {
				User temp = optional.get();
				String role=temp.getUserRole();
				String res="Login Successful";
				if(temp.getPassword().equals(pwd)) {
					return role+" "+res;
				}else {
					//throw new Exception("Wrong password");
					return "Wrong password";
				}
			}else {
				return "User doesn't exist";
				//throw new Exception("User doesn't exit");
			}
		}catch(DataAccessException e) {
			throw new InvalidLoginCredentialsException(e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}
	
	
//	@Override
//	public String AuthenticateUser(String username,String pwd) throws  InvalidLoginCredentialsException,UserNotFoundException{
//		try {			
//			Optional<User> optional = loginRepository.findByUsername(username);
//			if(optional.isPresent()) {
//				User temp = optional.get();
//				if(temp.getPassword().equals(pwd)) {
//					return "Login Successful";
//				}else {
//					//throw new Exception("Wrong password");
//					return "Wrong password";
//				}
//			}else {
//				return "User doesn't exist";
//				//throw new Exception("User doesn't exit");
//			}
//		}catch(DataAccessException e) {
//			throw new InvalidLoginCredentialsException(e.getMessage());
//		}catch(Exception e) {
//			throw e;
//		}
//	}
	
	
	@Override
	public String changePassword(String username, String newPassword) throws UserNotFoundException{			
			
		try {			
			Optional<User> optional = loginRepository.findByUsername(username);
			if(optional.isPresent()) {
				User user = optional.get();
			    user.setPassword(newPassword);
				return "Password changed!";
				
				}
			else {
				return "Invalid UserName";
				//throw new Exception("Invalid username");
			}
		}catch(DataAccessException e) {
			throw new UserNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw e;
		}
		//finally
		//{ return "Password not changed,Invalid username";}
	}

	
	@Override
	public boolean userNameExists(String userName){
		User check = loginRepository.findByName(userName);
		if(check!=null)
		{
			return true;
			
		} 
		return false;
	}



	@Override
	public User getUserById(int id) throws UserNotFoundException {
		try {
			Optional<User> optional= loginRepository.findById(id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new UserNotFoundException("Invalid Agentno");
			}
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException(e.getMessage());
		}catch(Exception e) {
			throw e;
		}
	}


}
