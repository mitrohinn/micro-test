package com.example.productservice.service;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;
import com.example.productservice.repository.ProductRepo;
import com.example.productservice.service.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImp implements ProductService{
    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public ProductServiceImp(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }


    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = productMapper.mapToProduct(productRequest);
        productRepo.insert(product);
        log.info("Продукт с именем: {} сохранен", product.getName());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        Collection<Product> products = productRepo.findAll();
        return products.stream().map(productMapper::mapFromProduct).collect(Collectors.toList());
    }
}
