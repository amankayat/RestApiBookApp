package com.blueyonder.bookapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.bookapp.entities.Role;
import com.blueyonder.bookapp.entities.Users;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.blueyonder.bookapp.exceptions.RoleNotFoundExceptions;
import com.blueyonder.bookapp.exceptions.UserNotfoundException;
import com.blueyonder.bookapp.repository.UsersRepository;

@Service
public class UserServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersrepo;
	@Override
	public Users createUsers(Users Users) {
		// TODO Auto-generated method stub
		return usersrepo.save(Users);
	}

	@Override
	public Users getUsersById(Integer custId) throws UserNotfoundException {
		Optional<Users> user = usersrepo.findById(custId);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new UserNotfoundException();
		}
	}

	@Override
	public List<Users> getUsersByName(String cname) throws UserNotfoundException {
		
		return usersrepo.findByUserName(cname);
	}

	@Override
	public Users updateUsers(Users Users) throws UserNotfoundException {
		
		return usersrepo.save(Users);
	}

	

	@Override
	public String LoginUser(Users users) throws UserNotfoundException {
		Users usr = getUsersById(users.getUserId());
		if(usr!=null) {
			if(usr.getUserName()==users.getUserName() && usr.getPassword()==users.getPassword()) {
				return "login successfull";
			}else {
				return "username and password are incorrect";
			}
		}else {
			throw new UserNotfoundException();
		}
	}

	@Override
	public String deleteUsers(Integer id) throws UserNotfoundException {
		usersrepo.deleteById(id);
		return "user deleted successfully";
	}

}
