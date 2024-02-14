package com.blueyonder.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.bookapp.entities.Address;
import com.blueyonder.bookapp.exceptions.AddressNotFoundException;
import com.blueyonder.bookapp.repository.AddressRepository;
import com.blueyonder.bookapp.services.AddressServiceImpl;


@RestController
@RequestMapping("/bookapp/api/v1/address")
public class AddressController {
	
	@Autowired
	private AddressServiceImpl addrepo;
	
	@PostMapping("/addaddress")
	public Address addaddress(@RequestBody Address address) {
		return addrepo.addaddress(address);
	}
	
	@GetMapping("/getaddressbyid")
	public Address getAddressById(@RequestParam(name="id") Integer id) throws AddressNotFoundException{
		return addrepo.getAddressById(id); 
	}
	
	
	
	@PostMapping("/updateaddress")
	public Address UpdateAddress(@RequestBody Address address) throws AddressNotFoundException{
		if(addrepo.getAddressById(address.getAddressId())!=null) {
			 addrepo.UpdateAddress(address);
			 return address;
			
		}else
		{
			throw new AddressNotFoundException();
		}
	}
	@GetMapping("/deleteaddressbyid")
	public String DeleteAddressById(@RequestParam(name="id") Integer addressId)  throws AddressNotFoundException{
		if(addrepo.getAddressById(addressId)!=null) {
			return addrepo.DeleteAddressById(addressId);
			
		}else
		{
			throw new AddressNotFoundException();
		}
	}
}
