package com.scaler.EcommProductService.service;

import com.scaler.EcommProductService.model.Category;
import com.scaler.EcommProductService.model.EcomOrder;
import com.scaler.EcommProductService.model.Price;
import com.scaler.EcommProductService.model.Product;
import com.scaler.EcommProductService.repository.CategoryRepository;
import com.scaler.EcommProductService.repository.OrderRepository;
import com.scaler.EcommProductService.repository.PriceRepository;
import com.scaler.EcommProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InitDataServiceImpl implements InitDataService{

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private PriceRepository priceRepository;
    private OrderRepository orderRepository;

    public InitDataServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, PriceRepository priceRepository, OrderRepository orderRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void initData() {
        Category electronics = new Category();
        electronics.setCategoryName("Electronics");
        categoryRepository.save(electronics);

        Category clothing = new Category();
        clothing.setCategoryName("Clothing");
        categoryRepository.save(clothing);

        Price iphonePrice = new Price();
        iphonePrice.setAmount(100000);
        iphonePrice.setCurrency("INR");
        iphonePrice.setDiscount(1000);
        priceRepository.save(iphonePrice);

        Price hpLaptopPrice = new Price();
        hpLaptopPrice.setAmount(60000);
        hpLaptopPrice.setCurrency("INR");
        hpLaptopPrice.setDiscount(100);
        priceRepository.save(hpLaptopPrice);

        Price menJeansPrice = new Price();
        menJeansPrice.setAmount(2200);
        menJeansPrice.setCurrency("INR");
        menJeansPrice.setDiscount(100);
        priceRepository.save(menJeansPrice);

        Price menTshirtPrice = new Price();
        menTshirtPrice.setAmount(1500);
        menTshirtPrice.setCurrency("INR");
        menTshirtPrice.setDiscount(200);
        priceRepository.save(menTshirtPrice);

        Product iphone = new Product();
        iphone.setCategory(electronics);
        iphone.setTitle("iPhone 15");
        iphone.setDescription("Latest iPhone 15");
        iphone.setPrice(iphonePrice);
        iphone.setImage("www.google.com/images/iphone15");
        productRepository.save(iphone);

        Product hpLaptop = new Product();
        hpLaptop.setCategory(electronics);
        hpLaptop.setTitle("HP laptop 15 inch");
        hpLaptop.setDescription("HP laptop 15 inch monitor");
        hpLaptop.setPrice(hpLaptopPrice);
        hpLaptop.setImage("www.google.com/images/hp");
        productRepository.save(hpLaptop);

        Product menJeans = new Product();
        menJeans.setCategory(clothing);
        menJeans.setTitle("Levis Mens Slim Fit Jeans");
        menJeans.setDescription("Levis Mens Slim Fit Jeans");
        menJeans.setPrice(menJeansPrice);
        menJeans.setImage("www.google.com/images/levis");
        productRepository.save(menJeans);

        Product menTshirt = new Product();
        menTshirt.setCategory(clothing);
        menTshirt.setTitle("USPA Mens Tshirt");
        menTshirt.setDescription("USPA Mens Tshirt");
        menTshirt.setPrice(menTshirtPrice);
        menTshirt.setImage("www.google.com/images/tshirt");
        productRepository.save(menTshirt);

        EcomOrder order1 = new EcomOrder();
        //order1.setPrice(10000);
        order1.setProducts(List.of(iphone, hpLaptop, menJeans, menTshirt));
        orderRepository.save(order1);
    }
}
