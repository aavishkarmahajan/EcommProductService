package com.scaler.EcommProductService.controller;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductRequestDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.exception.ProductNotFoundException;
import com.scaler.EcommProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.image.RescaleOp;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        /*ProductResponseDTO prod1 = new ProductResponseDTO();
        prod1.setId(1);
        prod1.setTitle("HP laptop");
        prod1.setCategory("Electronics");
        prod1.setDescription("This isa 15.6 inch HP laptop");
        prod1.setPrice(60000);
        prod1.setImage("www.google.com/images/HP");

        ProductResponseDTO prod2 = new ProductResponseDTO();
        prod2.setId(1);
        prod2.setTitle("Acer laptop");
        prod2.setCategory("Electronics");
        prod2.setDescription("This isa 14 inch Acer laptop");
        prod2.setPrice(55000);
        prod2.setImage("www.google.com/images/Acer");

        List<ProductResponseDTO> products = Arrays.asList(prod1, prod2);
        return ResponseEntity.ok(products);*/

        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) throws ProductNotFoundException {
        ProductResponseDTO response = productService.getProductById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/products")
    public ResponseEntity createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO response = new ProductResponseDTO();
        response = productService.createProduct(productRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProductById(@PathVariable("id") int id){
        boolean response = productService.deleteProduct(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity updateProductById(@PathVariable("id") int id, @RequestBody ProductRequestDTO productRequestDTO){
        boolean response = productService.updateProduct(id, productRequestDTO);
        return ResponseEntity.ok(response);
    }
}
