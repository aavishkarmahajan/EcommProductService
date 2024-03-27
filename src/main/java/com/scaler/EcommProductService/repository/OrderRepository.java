package com.scaler.EcommProductService.repository;

import com.scaler.EcommProductService.model.EcomOrder;
import com.scaler.EcommProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<EcomOrder, UUID> {
}
