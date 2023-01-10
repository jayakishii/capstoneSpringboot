package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepo;

@RestController

@CrossOrigin(origins = "http://localhost:4200" , allowCredentials = "true")
public class CustomerController {
	
	@Autowired
	private CustomerRepo repo;
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
		
		return ResponseEntity.ok(repo.save(customer));
		
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getCustomers(){
		List<Customer> customerlist = new ArrayList<>();
		
		repo.findAll().forEach(customerlist::add);
		try {
		if(customerlist.isEmpty()) {
			return new ResponseEntity<>(customerlist,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(customerlist,HttpStatus.OK);
	}
		catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Integer id){
		repo.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	

}
