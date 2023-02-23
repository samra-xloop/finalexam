package com.alisnobba.finalexam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alisnobba.finalexam.repository.Irepo;
import com.alisnobba.finalexam.models.Product;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/alisnobba/products")
public class Controller {
    
    @Autowired
    public Irepo repo;

    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody Product product){
        Product productCreated= repo.save(product);
        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }
    @GetMapping("")
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductBEntity(@PathVariable Long id) {
        Product product = repo.findById(id).orElse(null);
        if (product== null) {
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
            
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    
}
