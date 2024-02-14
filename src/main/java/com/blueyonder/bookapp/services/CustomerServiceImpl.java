package com.blueyonder.bookapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.bookapp.entities.Customer;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.blueyonder.bookapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository custrepo;

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return custrepo.save(customer);
	}

	@Override
	public Customer getCustomerById(Integer custId) throws CustomerNotFoundExceptions  {
		// TODO Auto-generated method stub
		Optional<Customer> cust = custrepo.findById(custId);
		if(cust.isPresent()) {
			return cust.get();
		}else {
			throw new CustomerNotFoundExceptions();
		}
	}

	@Override
	public List<Customer> getCustomerByName(String cname) throws CustomerNotFoundExceptions  {
		// TODO Auto-generated method stub
		return custrepo.findByCustomerName(cname);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return custrepo.save(customer);
	}

	@Override
	public String deleteCustomer(Integer custID) {
		// TODO Auto-generated method stub
	
		custrepo.deleteById(custID);
		return "delete successfully";
	}

}
