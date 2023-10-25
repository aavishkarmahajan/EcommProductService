package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductRequestDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        String getAllProductsURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO[]> productResponseArray = restTemplate.getForEntity(getAllProductsURL,ProductResponseDTO[].class);
        ProductListResponseDTO productListResponseDTO = new ProductListResponseDTO();
        for(ProductResponseDTO productResponseDTO : productResponseArray.getBody()){
            productListResponseDTO.getProducts().add(productResponseDTO);
        }
        return productListResponseDTO;
    }

    @Override
    public ProductResponseDTO getProductById(int id) {
        String getAllProductsURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.getForEntity(getAllProductsURL, ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        String createProductURL = "https://fakestoreapi.com/products";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductResponseDTO> productResponse = restTemplate.postForEntity(createProductURL,productRequestDTO,ProductResponseDTO.class);
        return productResponse.getBody();
    }

    @Override
    public boolean deleteProduct(int id) {
        String deleteProductURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
        return true;
    }

    @Override
    public boolean updateProduct(int id, ProductRequestDTO productRequestDTO) {
        String updateProductURL = "https://fakestoreapi.com/products/" + id;
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.put(updateProductURL, productRequestDTO ,ProductResponseDTO.class);
        return true;
    }
}
