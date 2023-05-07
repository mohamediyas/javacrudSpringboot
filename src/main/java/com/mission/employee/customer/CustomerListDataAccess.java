package com.mission.employee.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;


@Repository("list")
public class CustomerListDataAccess implements CustomerDao {
	
	
//	db
	private static List<Customer> customers;
	
	
	static {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "ale","alex@gmail.com",21));
		customers.add(new Customer(2, "jamila","jamila@gmail.com",22));
		
	}
	

	@Override
	public List<Customer> selectAllCustomer() {
		// TODO Auto-generated method stub
		return customers;
	}


	@Override
	public Optional<Customer> selectCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		
		return customers.stream().filter(c -> c.getId().equals(customerId))
				.findFirst();
	}


	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		customers.add(customer);
		
	}


	@Override
	public boolean existsPersonWithEmail(String email) {
		// TODO Auto-generated method stub
		return customers.stream().anyMatch(c -> c.getEmail().equals(email));
	}


	@Override
	public boolean existsPersonWithId(Integer customerId) {
		// TODO Auto-generated method stub
		return customers.stream().anyMatch(c -> c.getId().equals(customerId));
	}


	@Override
	public void deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		
		customers.stream().filter(c -> c.getId().equals(id)).findFirst().ifPresent(customers::remove);
		
	}


	@Override
	public void updateCustomer(Customer update) {
		// TODO Auto-generated method stub
		
		customers.add(update);
		
	}
	
	
	
	
	
	
	

}
