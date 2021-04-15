package com.cg.hims.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.hims.application.HomeInsuranceManagementSystemApplication;
import com.cg.hims.entities.User;
import com.cg.hims.exceptions.InvalidLoginCredentialsException;
import com.cg.hims.exceptions.UserNameAlreadyExistsException;
import com.cg.hims.exceptions.UserNotFoundException;
import com.cg.hims.repository.LoginRepository;
import com.cg.hims.service.LoginService;

@SpringBootTest(classes = HomeInsuranceManagementSystemApplication.class)
public  class UserTest 
{
	@Autowired
	private LoginService loginservice;
	@MockBean
	private LoginRepository loginrepository;

	public  User signup() throws UserNameAlreadyExistsException{
		User u = new User(9,"Kumar","pavan123","pavan","kumar","pkumar@gmail.com",543217654,"India","policyholder");
		return u;
	}

	/*
	 * check add user
	 */
	@Test
	public void testSignUp() throws UserNameAlreadyExistsException 
	{ User u = signup();
	when(loginrepository.save(u)).thenReturn(u);
	assertEquals("Added!",loginservice.signup(u));
	}

	/*
	 * check user by ID
	 */
	@Test
	public void testgetuserbyId() throws UserNotFoundException, UserNameAlreadyExistsException 
	{  
		User u =signup();
		int id=u.getUserId();
		Optional<User>optional=loginrepository.findById(id);
		if(optional.isPresent())
		{
			when(optional.get()).thenReturn(optional.get());
			assertEquals(optional.get(),loginservice.getUserById(id));
		}
	}	
	/*
	 * check user login
	 */
	@Test
	public void login() throws  InvalidLoginCredentialsException, UserNameAlreadyExistsException, UserNotFoundException
	{  User u = signup();
	String username=u.getUserName();
	String password=u.getPassword();
	Optional<User>optional=loginrepository.findByUsername(username);
	if(optional.isPresent())
	{
		when(optional.get()).thenReturn(optional.get());
		assertEquals("Login Successful",loginservice.AuthenticateUser(username, password));
	}

	}


	/*
	 * check change Password
	 */
	@Test 
	public void testChangePassword() throws UserNotFoundException, UserNameAlreadyExistsException 
	{   User u = signup();
	u.setPassword("pavan@123");
	loginrepository.save(u);
	Optional<User>optional=loginrepository.findByUsername(u.getUserName());
	if(optional.isPresent())
	{
		when(optional.get()).thenReturn(optional.get());
		assertEquals("Password Changed!",loginservice.changePassword(u.getUserName(),u.getPassword()));
	}
	}



}