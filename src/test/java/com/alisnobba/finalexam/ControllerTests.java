package com.alisnobba.finalexam;

import com.alisnobba.finalexam.controller.Controller;
import com.alisnobba.finalexam.models.Product;
import com.alisnobba.finalexam.repository.Irepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTests {
    
    @Test
    public void testCreateProduct() {
        Irepo mockRepo = Mockito.mock(Irepo.class);
        Product product = new Product();
        product.setName("Test Product");
        Mockito.when(mockRepo.save(product)).thenReturn(product);

        Controller controller = new Controller();
        controller.repo = mockRepo;

        ResponseEntity<Product> responseEntity = controller.create(product);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    public void testGetAllProducts() {
        Irepo mockRepo = Mockito.mock(Irepo.class);
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        products.add(new Product());
        Mockito.when(mockRepo.findAll()).thenReturn(products);

        Controller controller = new Controller();
        controller.repo = mockRepo;

        List<Product> result = controller.getAllProducts();

        assertEquals(products.size(), result.size());
    }

    @Test
    public void testGetProductById() {
        Irepo mockRepo = Mockito.mock(Irepo.class);
        Product product = new Product();
        product.setId(1L);
        Mockito.when(mockRepo.findById(1L)).thenReturn(Optional.of(product));

        Controller controller = new Controller();
        controller.repo = mockRepo;

        ResponseEntity<Product> responseEntity = controller.getProductBEntity(1L);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(product, responseEntity.getBody());
    }

    @Test
    public void testGetProductByIdNotFound() {
        Irepo mockRepo = Mockito.mock(Irepo.class);
        Mockito.when(mockRepo.findById(1L)).thenReturn(Optional.empty());

        Controller controller = new Controller();
        controller.repo = mockRepo;

        ResponseEntity<Product> responseEntity = controller.getProductBEntity(1L);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}
