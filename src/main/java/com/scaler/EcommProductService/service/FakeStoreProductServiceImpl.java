package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.client.FakeStoreAPIClient;
import com.scaler.EcommProductService.dto.*;
import com.scaler.EcommProductService.exception.ProductNotFoundException;
import com.scaler.EcommProductService.mapper.ProductMapper;
import com.scaler.EcommProductService.model.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.scaler.EcommProductService.mapper.ProductMapper.fakeStoreProductResponseToProductResponse;
import static com.scaler.EcommProductService.mapper.ProductMapper.productRequestToFakeStoreProductRequest;
import static com.scaler.EcommProductService.util.ProductUtils.isNull;

@Service("fakeStoreProductService")
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreAPIClient fakeStoreAPIClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreAPIClient fakeStoreAPIClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreAPIClient = fakeStoreAPIClient;
    }

    @Override
    public ProductListResponseDTO getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreResponse = fakeStoreAPIClient.getAllProducts();
        ProductListResponseDTO productList = new ProductListResponseDTO();
        for(FakeStoreProductResponseDTO response: fakeStoreResponse){
            productList.getProducts().add(fakeStoreProductResponseToProductResponse(response));
        }
        return productList;
    }

    //@Override
    //public ProductListResponseDTO getProductsByTitle(String title, int pageSize, int pageNo) {
    //    return null;
    //}

    @Override
    public ProductResponseDTO getProductById(int id) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.getProductById(id);
        if(isNull(fakeStoreProductResponseDTO)){
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        FakeStoreProductRequestDTO fakeStoreProductRequestDTO = productRequestToFakeStoreProductRequest(productRequestDTO);
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreAPIClient.createProduct(fakeStoreProductRequestDTO);
        return fakeStoreProductResponseToProductResponse(fakeStoreProductResponseDTO);
    }

    @Override
    public boolean deleteProduct(int id) {
        fakeStoreAPIClient.deleteProduct(id);
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
