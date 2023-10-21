package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.model.Product;

import java.util.List;

public interface ProductService {
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id);
    Product createProduct(Product product);
    Product deleteProduct(int id);
    Product updateProduct(int id, Product updatedProduct);
}
