package com.blueyonder.bookapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueyonder.bookapp.entities.Customer;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.blueyonder.bookapp.services.CustomerService;

@RestController
@RequestMapping("/bookapp/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerservice.addCustomer(customer);
	}
	
	@GetMapping("/getcustomerbyid")
	public ResponseEntity<Customer> getCustomerById(@RequestParam(name="id")Integer custId) throws CustomerNotFoundExceptions {
		Customer cust =  customerservice.getCustomerById(custId);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping("/getcustomerbyname")	
	public List<Customer> getCustomerByName(@RequestParam(name="name") String cname) throws CustomerNotFoundExceptions {
		return customerservice.getCustomerByName(cname);
	}
	
	@PostMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundExceptions {
		if(customerservice.getCustomerById(customer.getCustomerId())!=null) {
			customerservice.updateCustomer(customer);
			return customer;
		}else {
			throw new CustomerNotFoundExceptions();
		}
	}
	@GetMapping("/deletebyid")
	public String deleteCustomer(@RequestParam(name="id")Integer custId) throws CustomerNotFoundExceptions {
		if(customerservice.getCustomerById(custId)!=null) {
			return customerservice.deleteCustomer(custId);
		
		}else {
			throw new CustomerNotFoundExceptions();
		}
	}
}
