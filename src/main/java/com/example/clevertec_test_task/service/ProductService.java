package com.example.clevertec_test_task.service;

import com.example.clevertec_test_task.dto.NewProductDto;
import com.example.clevertec_test_task.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long id);

    List<ProductDto> getAllProducts();

    ProductDto saveProduct(NewProductDto newProductDto);

    ProductDto updateProduct(Long id, NewProductDto newProductDto);

    boolean deleteProduct(Long id);
}
