package com.blueyonder.bookapp.services;



import java.util.List;

import com.blueyonder.bookapp.entities.Users;
import com.blueyonder.bookapp.exceptions.UserNotfoundException;

public interface UsersService {

	public Users createUsers(Users Users);
	public Users getUsersById(Integer custId)throws UserNotfoundException;
	public List<Users> getUsersByName(String cname) throws UserNotfoundException;
	public Users updateUsers(Users Users) throws UserNotfoundException;
	public String deleteUsers(Integer id) throws UserNotfoundException;
	public String LoginUser(Users users)throws UserNotfoundException;
	
	
	
}
