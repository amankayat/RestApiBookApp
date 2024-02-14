package com.blueyonder.bookapp.services;

import java.util.List;

import com.blueyonder.bookapp.entities.Role;
import com.blueyonder.bookapp.exceptions.RoleNotFoundExceptions;

public interface RoleService {

	public Role addrole(Role role);
	public Role getRoleById(Integer id) throws RoleNotFoundExceptions;
	public List<Role> getRoleByName(String name) throws RoleNotFoundExceptions;
	public Role UpdateRole(Role role) throws RoleNotFoundExceptions;
	public void DeleteRole(Role role);
	
}
