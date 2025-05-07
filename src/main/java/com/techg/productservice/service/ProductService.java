package com.techg.productservice.service;

import com.techg.productservice.dto.ProductRequest;
import com.techg.productservice.dto.ProductResponse;
import com.techg.productservice.model.Product;
import com.techg.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
@Slf4j  //provides logs
public class ProductService {
    //inject prod repo into this service class
    private final ProductRepository productRepository;

    // will be replaced with @RequiredArgsConstructor lombok library
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest){
        //lets map our product request to the product model
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        //save your product to the repository
        productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
      List<Product> products =   productRepository.findAll();
      //maps Product class into ProductResponse class
        return products.stream().map(this::mapToProductResponse).toList();
    }

    //Creating object of productResponse
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
