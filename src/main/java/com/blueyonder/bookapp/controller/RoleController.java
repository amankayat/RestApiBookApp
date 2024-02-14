package com.blueyonder.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.bookapp.entities.Role;
import com.blueyonder.bookapp.exceptions.RoleNotFoundExceptions;
import com.blueyonder.bookapp.services.RoleService;

@RestController
@RequestMapping("/bookapp/api/v1")
public class RoleController {
	@Autowired
	private RoleService roleservice;
	
	
	@PostMapping("/addrole")
	public Role addRole(@RequestBody Role role) {
		return roleservice.addrole(role);
	}
	
	@GetMapping("/getrolebyid")
	public Role getRoleById(@RequestParam(name="id") Integer id) throws RoleNotFoundExceptions{
		return roleservice.getRoleById(id);
	}
	@GetMapping("/getrolebyname")
	public List<Role> getRoleByName(@RequestParam(name="name") String name)throws RoleNotFoundExceptions {
		return roleservice.getRoleByName(name);
	}
	@GetMapping("/deleterole")
	public void deleteRole(@RequestBody Role role) {
		 roleservice.DeleteRole(role);
	}
	
	@PostMapping("/updaterole")
	public Role updateRoll(@RequestBody Role role)throws RoleNotFoundExceptions {
		if(roleservice.getRoleById(role.getRoleId())!=null) {
			roleservice.UpdateRole(role);
			return role;
		}else {
			throw new RoleNotFoundExceptions();
		}
		 
		
	}
}
