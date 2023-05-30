package com.coderhouse.proyecto_final_2da_entrega.controller;

import com.coderhouse.proyecto_final_2da_entrega.middleware.ResponseHandler;
import com.coderhouse.proyecto_final_2da_entrega.model.Customer;
import com.coderhouse.proyecto_final_2da_entrega.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Create customer
    @PostMapping(path = "/save")
    public ResponseEntity<Object> postClient(@RequestBody Customer customer){
        try{
            Customer customerSaved = customerService.postCustomer(customer);
            return ResponseHandler.generateResponse(
                    "Customer created.",
                    HttpStatus.OK,
                    customerSaved
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // Get customer by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getClient(@PathVariable() int id){
        try{
            Optional<Customer> customerFound = customerService.getCustomer(id);
            return ResponseHandler.generateResponse(
                    "Customer retrieved.",
                    HttpStatus.OK,
                    customerFound
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    "Customer not found.",
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}
