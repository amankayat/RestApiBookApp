package com.blueyonder.bookapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.blueyonder.bookapp.entities.Address;
import com.blueyonder.bookapp.entities.Customer;

@Repository
public interface AddressRepository extends CrudRepository<Address,Integer> {
	
	
}
