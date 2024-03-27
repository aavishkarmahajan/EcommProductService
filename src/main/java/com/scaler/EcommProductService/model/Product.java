package com.scaler.EcommProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    @ManyToOne
    private Category category;
    private String description;
    private String image;
    @OneToOne
    private Price price;
}
