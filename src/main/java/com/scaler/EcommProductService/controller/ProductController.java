package com.scaler.EcommProductService.controller;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.image.RescaleOp;
import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    ProductService productService;

    @GetMapping("/product")
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

    @GetMapping("/product/1")
    public ResponseEntity getProductById(){
        ProductResponseDTO response = productService.getProductById(1);
        return ResponseEntity.ok(response);
    }
}
