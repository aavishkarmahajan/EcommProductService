package com.scaler.EcommProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDTO {
    private String title;
    private int pageNumber;
    private int pageSize;
}