package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductRequestDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.exception.ProductNotFoundException;
import com.scaler.EcommProductService.model.Product;

import java.util.List;

public interface ProductService {
    //ProductListResponseDTO getProductsByTitle(String title, int pageSize, int pageNo);
    ProductListResponseDTO getAllProducts();
    ProductResponseDTO getProductById(int id) throws ProductNotFoundException;
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    boolean deleteProduct(int id);
    boolean updateProduct(int id, ProductRequestDTO productRequestDTO);
}
