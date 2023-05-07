package com.mission.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mission.employee.customer.Customer;
import com.mission.employee.customer.CustomerRepository;

@SpringBootApplication
//@ComponentScan
//@EnableAutoConfiguration
//@Configuration
//@RestController
public class AmigosLearnFirstApplication {
	


	public static void main(String[] args) {
		
		SpringApplication.run(AmigosLearnFirstApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
	
		return args ->{
			
			 Customer ale = new Customer("ale","alex@gmail.com",21);
			  Customer jamila =	new Customer("jamila","jamila@gmail.com",22);
			  
			  
			List<Customer> customers = List.of(ale,jamila);
			
			customerRepository.saveAll(customers);
              			
		};
	}
	
	
	
}
