package com.coderhouse.proyecto_final_2da_entrega.repository;

import com.coderhouse.proyecto_final_2da_entrega.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
