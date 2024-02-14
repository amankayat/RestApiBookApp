package com.blueyonder.bookapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.bookapp.entities.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {

	public List<Role> findByRoleName(String name);
}
