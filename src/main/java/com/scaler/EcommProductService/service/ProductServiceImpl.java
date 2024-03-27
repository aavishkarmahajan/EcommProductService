package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductRequestDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.mapper.ProductMapper;
import com.scaler.EcommProductService.model.Product;
import com.scaler.EcommProductService.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

    ProductRepository productRepository;

    //@Override
    //public ProductListResponseDTO getProductsByTitle(String title, int pageSize, int pageNo) {
    //    return null;
    //}

    @Override
    public ProductListResponseDTO getAllProducts() {

        List<Product> products = productRepository.findAll();
        ProductListResponseDTO productListResponseDTO = ProductMapper.productListToProductListResponseDTO(products);
        return productListResponseDTO;
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
