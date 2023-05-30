package com.coderhouse.proyecto_final_2da_entrega.repository;

import com.coderhouse.proyecto_final_2da_entrega.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
