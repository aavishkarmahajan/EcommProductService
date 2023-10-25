package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductRequestDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    @Override
    public ProductListResponseDTO getAllProducts() {
        return null;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        return null;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public boolean updateProduct(int id, ProductRequestDTO productRequestDTO) {
        return false;
    }
}
