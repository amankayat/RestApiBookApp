package com.blueyonder.bookapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.bookapp.entities.Customer;
import com.blueyonder.bookapp.entities.Role;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.blueyonder.bookapp.exceptions.RoleNotFoundExceptions;
import com.blueyonder.bookapp.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
		
	@Autowired
	private RoleRepository rolerepo;
	
	@Override
	public Role addrole(Role role) {
		// TODO Auto-generated method stub
		return rolerepo.save(role);
	}

	@Override
	public Role getRoleById(Integer id) throws RoleNotFoundExceptions {
		// TODO Auto-generated method stub
		Optional<Role> role = rolerepo.findById(id);
		if(role.isPresent()) {
			return role.get();
		}else {
			throw new RoleNotFoundExceptions();
		}
		
		
	}

	@Override
	public List<Role> getRoleByName(String name) throws RoleNotFoundExceptions {
		// TODO Auto-generated method stub
		return rolerepo.findByRoleName(name);
	}

	@Override
	public Role UpdateRole(Role role)  throws RoleNotFoundExceptions {
		// TODO Auto-generated method stub
		return rolerepo.save(role);
	}

	@Override
	public void DeleteRole(Role role) {
		
		 rolerepo.delete(role);;
	}

}
