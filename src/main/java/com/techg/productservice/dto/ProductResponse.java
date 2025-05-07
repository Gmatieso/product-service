package com.techg.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data  //creates getter and setters
@Getter
@Builder  //creates builder methods
public class ProductResponse {

    public ProductResponse(String id, String name, String description, BigDecimal price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }


    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    private String getId(){
        return id;
    }
}
