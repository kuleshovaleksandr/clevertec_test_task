package com.example.clevertec_test_task.mapper;

import com.example.clevertec_test_task.dto.ProductDto;
import com.example.clevertec_test_task.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends AbstractMapper<Product, ProductDto> {

    public ProductMapper() {
        super(Product.class, ProductDto.class);
    }
}
