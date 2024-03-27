package com.scaler.EcommProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class EcomOrder extends BaseModel{
    //private double price;
    @ManyToMany
    private List<Product> products;
}
