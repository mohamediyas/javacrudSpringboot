package com.mission.employee.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mission.employee.exeception.DuplicateResourceException;
import com.mission.employee.exeception.RequestValidationException;
import com.mission.employee.exeception.ResourceNotFound;


//@Component
@Service
public class CustomerService {
	
	private final CustomerDao customerDao;

	public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
		this.customerDao = customerDao; 
	}
	
	public List<Customer> getAllCustomers(){
		return customerDao.selectAllCustomer();
		
	}
	
	public Customer getCustomer(Integer id) {
		return customerDao.selectCustomerById(id).orElseThrow(()-> new ResourceNotFound("customer not found"));
	}
	
	public void addCustomer(CustomerRegistrationRequest customerRegistration) {
	
		
		if(customerDao.existsPersonWithEmail(customerRegistration.email())) {
			throw new DuplicateResourceException("Email already there");
		}
		
		customerDao.insertCustomer(
				  new Customer(
						    customerRegistration.name(),
						    customerRegistration.email(),
						    customerRegistration.age()
						  )
				  
				);
		
		
		
		
	}

	
	
	public void deleteCustomerById(Integer customerId) {
		if(!customerDao.existsPersonWithId(customerId)) {
			
			throw new ResourceNotFound("Customer not found");
			
		}
		
		customerDao.deleteCustomerById(customerId);
	}
	
	
	public void updateCustomer(Integer customerId, CustomerRegistrationRequest customerRegistrationRequest) {

		Customer customer = getCustomer(customerId);
		
		boolean changes = false;
		
		if(customerRegistrationRequest.name() != null && !customerRegistrationRequest.name().equals(customer.getName()) ) {
			 customer.setName(customerRegistrationRequest.name());
			 changes = true;
		}
		
		if(customerRegistrationRequest.age() != null && !customerRegistrationRequest.age().equals(customer.getAge()) ) {
			 customer.setAge(customerRegistrationRequest.age());
			 changes = true;
		}
		
		if(customerRegistrationRequest.email() != null && !customerRegistrationRequest.email().equals(customer.getEmail()) ) {
		
			if(customerDao.existsPersonWithEmail(customerRegistrationRequest.email())) {
				throw new DuplicateResourceException("Email already taken");
			}
			
			
			customer.setEmail(customerRegistrationRequest.email());
			 changes = true;
		}
		
		
		if(!changes) {
			throw new RequestValidationException("No data changes found");
		}
		
		customerDao.updateCustomer(customer);
		
		
		
	}
	
	
	
}
