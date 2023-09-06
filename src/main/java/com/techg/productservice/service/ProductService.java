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
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build(); //creates an object of type product
        //save your product to the repository
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
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
