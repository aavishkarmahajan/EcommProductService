package com.scaler.EcommProductService.client;

import com.scaler.EcommProductService.dto.FakeStoreProductRequestDTO;
import com.scaler.EcommProductService.dto.FakeStoreProductResponseDTO;
import com.scaler.EcommProductService.dto.ProductRequestDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreAPIClient {

    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.url}")
    private String fakeStoreAPIUrl;
    @Value("${fakestore.api.path.products}")
    private String fakeStoreAPIProductPath;

    public FakeStoreAPIClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductResponseDTO createProduct(FakeStoreProductRequestDTO fakeStoreProductRequestDTO){
        //String createProductURL = "https://fakestoreapi.com/products";
        String createProductURL = fakeStoreAPIUrl + fakeStoreAPIProductPath;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> fakeStoreProductDTOResponseEntity = restTemplate.postForEntity(createProductURL, fakeStoreProductRequestDTO, FakeStoreProductResponseDTO.class);
        return fakeStoreProductDTOResponseEntity.getBody();
    }

    public FakeStoreProductResponseDTO getProductById(int id){
        //String getProductsURL = "https://fakestoreapi.com/products/" + id;
        String getProductsURL = fakeStoreAPIUrl + fakeStoreAPIProductPath + "/" + id;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO> fakeStoreResponse = restTemplate.getForEntity(getProductsURL, FakeStoreProductResponseDTO.class);
        return fakeStoreResponse.getBody();
    }

    public List<FakeStoreProductResponseDTO> getAllProducts(){
        //String getProductsURL = "https://fakestoreapi.com/products/";
        String getProductsURL = fakeStoreAPIUrl + fakeStoreAPIProductPath;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDTO[]> fakeStoreResponse = restTemplate.getForEntity(getProductsURL, FakeStoreProductResponseDTO[].class);
        return List.of(fakeStoreResponse.getBody());
    }

    public boolean deleteProduct(int id){
        //String deleteProductURL = "https://fakestoreapi.com/products/" + id;
        String deleteProductURL = fakeStoreAPIUrl + fakeStoreAPIProductPath + "/" + id;
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        restTemplate.delete(deleteProductURL);
        return true;

    }
}
