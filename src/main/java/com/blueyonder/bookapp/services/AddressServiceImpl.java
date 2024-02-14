package com.blueyonder.bookapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.bookapp.entities.Address;
import com.blueyonder.bookapp.entities.Customer;
import com.blueyonder.bookapp.exceptions.AddressNotFoundException;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.blueyonder.bookapp.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addrepo;
	
	@Override
	public Address addaddress(Address address) {
		// TODO Auto-generated method stub
		return addrepo.save(address);
	}

	@Override
	public Address getAddressById(Integer id) throws AddressNotFoundException {
		Optional<Address> add = addrepo.findById(id);
		if(add.isPresent()) {
			return add.get();
		}else {
			throw new AddressNotFoundException();
		}
	}

	

	@Override
	public Address UpdateAddress(Address address) throws AddressNotFoundException {
		// TODO Auto-generated method stub
		return addrepo.save(address);
	}

	@Override
	public String DeleteAddressById(Integer addressId) throws AddressNotFoundException {
		addrepo.deleteById(addressId);
		return "address deleted successfully";
	}

}
