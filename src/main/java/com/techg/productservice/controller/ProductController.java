package com.techg.productservice.controller;

import com.techg.productservice.dto.ProductRequest;
import com.techg.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        //lets create our product
        productService.createProduct(productRequest);

    }
}
