package com.alisnobba.finalexam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.alisnobba.finalexam.models.Product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FinalexamApplicationTests {

	@Test
    public void testGettersAndSetters() throws Exception {
        Product product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setShortD("Short description.");
        product.setLongD("Long description.");
        product.setImgLink("https://example.com/image.png");
        product.setPrice(19.99);

        assertEquals(1L, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals("Short description.", product.getShortD());
        assertEquals("Long description.", product.getLongD());
        assertEquals("https://example.com/image.png", product.getImgLink());
        assertEquals(19.99, product.getPrice());
    }

    @Test
    public void testConstructor() {
        Product product = new Product(1L, "Test Product", "Short description.", "Long description.", "https://example.com/image.png", 19.99);

        assertEquals(1L, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals("Short description.", product.getShortD());
        assertEquals("Long description.", product.getLongD());
        assertEquals("https://example.com/image.png", product.getImgLink());
        assertEquals(19.99, product.getPrice());
    }
    
    
    
}


