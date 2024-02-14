package com.blueyonder.bookapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blueyonder.bookapp.entities.Customer;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.blueyonder.bookapp.repository.CustomerRepository;



public interface CustomerService {
	
	
	public Customer addCustomer(Customer customer);
	public Customer getCustomerById(Integer custId) throws CustomerNotFoundExceptions ;
	public List<Customer> getCustomerByName(String cname) throws CustomerNotFoundExceptions ;
	public Customer updateCustomer(Customer customer);
	public String deleteCustomer(Integer custId);
	
	
	
}
