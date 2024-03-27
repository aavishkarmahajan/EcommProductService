package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.dto.ProductListResponseDTO;
import com.scaler.EcommProductService.dto.ProductResponseDTO;
import com.scaler.EcommProductService.mapper.ProductMapper;
import com.scaler.EcommProductService.model.Category;
import com.scaler.EcommProductService.model.Price;
import com.scaler.EcommProductService.model.Product;
import com.scaler.EcommProductService.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import static org.mockito.Mockito.when;

public class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProductsSuccess(){
        //Arrange/Create
        Category mockCategory = new Category();
        mockCategory.setCategoryName("testCategory");

        Price mockPrice = new Price();
        mockPrice.setAmount(10000);

        Product mockProduct1 = new Product();
        mockProduct1.setTitle("testTitle1");
        mockProduct1.setCategory(mockCategory);
        mockProduct1.setDescription("testDescription1");
        mockProduct1.setId(UUID.randomUUID());
        mockProduct1.setPrice(mockPrice);
        mockProduct1.setImage("google.com/image1");

        Product mockProduct2 = new Product();
        mockProduct2.setTitle("testTitle2");
        mockProduct2.setCategory(mockCategory);
        mockProduct2.setDescription("testDescription2");
        mockProduct2.setId(UUID.randomUUID());
        mockProduct2.setPrice(mockPrice);
        mockProduct2.setImage("google.com/image2");

        List<Product> mockProductList = new ArrayList<Product>();
        mockProductList.add(mockProduct1);
        mockProductList.add(mockProduct2);

        ProductListResponseDTO mockProductListResponseDTO = ProductMapper.productListToProductListResponseDTO(mockProductList);

        when(productRepository.findAll()).thenReturn(mockProductList);


        //Act/Call
        ProductListResponseDTO actualResponse = productService.getAllProducts();

        //Assert/Check
        Assertions.assertEquals(actualResponse.getProducts(), mockProductListResponseDTO);
    }
}
