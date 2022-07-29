package com.example.FullstackProject.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private int rating;
    private int price;
    private int count_in_stock;
}
