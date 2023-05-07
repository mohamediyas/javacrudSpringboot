package com.mission.employee.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
	List<Customer> selectAllCustomer();
	
    Optional<Customer> selectCustomerById(Integer id);
    
    void insertCustomer(Customer customer);
    
    boolean existsPersonWithEmail(String email);
    
    boolean existsPersonWithId(Integer customerId);
    
    void deleteCustomerById(Integer id);
    
    void updateCustomer(Customer update);
    
    
}
