package com.scaler.EcommProductService.dto;

import com.scaler.EcommProductService.model.Category;
import com.scaler.EcommProductService.model.Price;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {
    private UUID id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
