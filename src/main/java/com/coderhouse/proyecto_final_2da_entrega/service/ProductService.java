package com.coderhouse.proyecto_final_2da_entrega.service;

import com.coderhouse.proyecto_final_2da_entrega.model.Product;
import com.coderhouse.proyecto_final_2da_entrega.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Save a product
    public Product postProduct(Product product) throws Exception{
        return productRepository.save(product);
    }

    // Get product by id
    public Optional<Product> getProduct(int id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            return null;
        }else{
            return Optional.of(product.get());
        }
    }
}
