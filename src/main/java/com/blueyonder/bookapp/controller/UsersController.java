package com.blueyonder.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.bookapp.entities.Users;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.blueyonder.bookapp.exceptions.UserNotfoundException;

import com.blueyonder.bookapp.services.UserServiceImpl;


@RestController
@RequestMapping("/bookapp/api/v1/users")
public class UsersController {
	
	@Autowired
	private UserServiceImpl userservice;
	
	
	@PostMapping("/register")
	public Users createUsers(@RequestBody Users Users) {
		return userservice.createUsers(Users);
	}
	
	@GetMapping("/getuserbyid")
	public Users getUsersById(@RequestParam(name="id") Integer userId)throws UserNotfoundException{
		return userservice.getUsersById(userId);
		
	}
	@GetMapping("/getuserbyname")
	public List<Users> getUsersByName(@RequestParam(name="name")String uname) throws UserNotfoundException{
		return userservice.getUsersByName(uname);
	}
	
	@PostMapping("/updateuser")
	public Users updateUsers(@RequestBody  Users Users) throws UserNotfoundException{
		if(userservice.getUsersById(Users.getUserId())!=null) {
			userservice.updateUsers(Users);
			return Users;
		}else {
			throw new UserNotfoundException();
		}
	}
	
	@GetMapping("/deletebyid")
	public String deleteUsers(@RequestParam(name="id")Integer id) throws UserNotfoundException{
		if(userservice.getUsersById(id)!=null) {
			return userservice.deleteUsers(id);
			 
		}else {
			throw new UserNotfoundException();
		}
	}
	@PostMapping("/loginuser")
	public String LoginUser(@RequestBody Users users) throws UserNotfoundException{
		return userservice.LoginUser(users);
	}
}
