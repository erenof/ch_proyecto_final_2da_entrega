package com.coderhouse.proyecto_final_2da_entrega.controller;

import com.coderhouse.proyecto_final_2da_entrega.middleware.ResponseHandler;
import com.coderhouse.proyecto_final_2da_entrega.model.Product;
import com.coderhouse.proyecto_final_2da_entrega.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create Product
    @PostMapping(path = "/save")
    public ResponseEntity<Object> postProduct(@RequestBody Product product){
        try{
            Product productSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Product created.",
                    HttpStatus.OK,
                    productSaved
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    // List a product by id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable() int id){
        try{
            Optional<Product> productFound = productService.getProduct(id);
            return ResponseHandler.generateResponse(
                    "Product retrieved.",
                    HttpStatus.OK,
                    productFound
            );
        }catch (Exception e){
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}
