package com.mission.employee.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;


@Repository("jpa")
public class CustomerJpaDataAccessService implements CustomerDao {

	private final CustomerRepository customerRepository;
	
	public CustomerJpaDataAccessService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	
	@Override
	public List<Customer> selectAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Optional<Customer> selectCustomerById(Integer id) {
		// TODO Auto-generated method stub
		
		return customerRepository.findById(id);
	}


	@Override
	public void insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		 customerRepository.save(customer);
		
	}


	@Override
	public boolean existsPersonWithEmail(String email) {
		// TODO Auto-generated method stub
		
		return customerRepository.existsCustomerByEmail(email);
	
	}


	@Override
	public boolean existsPersonWithId(Integer customerId) {
		// TODO Auto-generated method stub
		return customerRepository.existsCustomerById(customerId);
	}


	@Override
	public void deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}


	@Override
	public void updateCustomer(Customer update) {
		// TODO Auto-generated method stub
		
		customerRepository.save(update);
		
	}



}
