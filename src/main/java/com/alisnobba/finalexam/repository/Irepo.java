package com.alisnobba.finalexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alisnobba.finalexam.models.Product;

@Repository
public interface Irepo extends JpaRepository<Product, Long>{
    
}
