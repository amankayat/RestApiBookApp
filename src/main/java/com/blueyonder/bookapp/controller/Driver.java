package com.blueyonder.bookapp.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import com.blueyonder.bookapp.entities.Customer;
import com.blueyonder.bookapp.exceptions.CustomerNotFoundExceptions;
import com.fasterxml.jackson.databind.util.JSONPObject;

public class Driver {
	public static void main(String[] args) throws CustomerNotFoundExceptions{

		String uri = "http://localhost:8080/bookapp/api/v1/customer";
		RestTemplate rest = new RestTemplate();

		// for get request
		Integer id = 3;
//	//same for getforobject also
//	ResponseEntity<Customer> res = rest.getForEntity(uri+"/getcustomerbyid?id={id}", Customer.class,id);
//	System.out.println(res.getBody());
//	
//	System.out.println(res.getStatusCode());

		// for post request in rest template
//	Customer cust = new Customer(8,"shaalusharma","M",LocalDate.parse("2023-03-22"),null,null);
//	
//	ResponseEntity<Customer> result = rest.postForEntity(uri+"/addcustomer", cust, Customer.class);
//
//	System.out.println(result.getBody());
//	System.out.println(result.getStatusCode());

		// get request in restclient
		RestClient client = RestClient.create();
//		Customer result = client.get().uri(uri + "/getcustomerbyid?id={id}", id).retrieve().body(Customer.class);
//		System.out.println(result);

		// post request in rest client
//		Customer cust = new Customer(9, "vanshsharma", "M", LocalDate.parse("2000-03-22"), null, null);
//
//		ResponseEntity<Void> response = client.post().uri(uri + "/addcustomer").contentType(MediaType.APPLICATION_JSON)
//				.body(cust).retrieve().toBodilessEntity();
//
//		System.out.println(response);
//
//		System.out.println(response.getStatusCode());

//		 errorhandling
//		Customer cust1=null;
//		try {
//			 cust1 = client.get().uri(uri + "/getcustomerbyid?id={id}", id).retrieve()
//					.onStatus(HttpStatusCode::is4xxClientError, (request,response) -> {
////					
//						
//						throw new CustomerNotFoundExceptions(response.getStatusCode(), response.getHeaders());
//						
//					
//						
//					}).body(Customer.class);
//		}catch(Exception e) {
//			System.out.println("customer not exist..");	
//			}
//		
//		System.out.println(cust1);
		
//		exchange
		Customer cust2 = client.get().uri(uri + "/getcustomerbyid?id={id}", id)
				.accept(MediaType.APPLICATION_JSON)
				  .exchange((request, response) -> {
				    if (response.getStatusCode().is4xxClientError()) {
				      throw new CustomerNotFoundExceptions(response.getStatusCode(), response.getHeaders());
				    }
				    else {
				    
				    	Customer custt=null;
				    	String res = response.toString();
				    	System.out.println(res);
				    	 return  custt;
				      
				    }
				  });
		
		System.out.println(cust2);
		

//	}
}
}
