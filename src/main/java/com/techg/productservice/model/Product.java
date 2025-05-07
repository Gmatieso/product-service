package com.techg.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

//Define This class as mongo db document
@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;


    public void setId(String id) {
        this.id = id;
    }
    
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setDescription(String description){
        this.name = description;
    }
    
    public  void setPrice(BigDecimal price){
        this.price = price;
    }


}
