package com.blueyonder.bookapp.services;

import java.util.List;

import com.blueyonder.bookapp.entities.Address;
import com.blueyonder.bookapp.exceptions.AddressNotFoundException;

public interface AddressService {

	public Address addaddress(Address address);
	public Address getAddressById(Integer id) throws AddressNotFoundException;
	
	public Address UpdateAddress(Address address) throws AddressNotFoundException;
	public String DeleteAddressById(Integer addressId)  throws AddressNotFoundException;
}
