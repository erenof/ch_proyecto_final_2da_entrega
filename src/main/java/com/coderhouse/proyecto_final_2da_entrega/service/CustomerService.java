package com.coderhouse.proyecto_final_2da_entrega.service;

import com.coderhouse.proyecto_final_2da_entrega.model.Customer;
import com.coderhouse.proyecto_final_2da_entrega.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save a customer
    public Customer postCustomer(Customer customer) throws Exception {
        return customerRepository.save(customer);
    }

    // Get customer by id
    public Optional<Customer> getCustomer(int id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            return null;
        }else {
            return Optional.of(customer.get());
        }
    }

}
