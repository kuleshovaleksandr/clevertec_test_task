package com.example.clevertec_test_task.service;

import com.example.clevertec_test_task.dto.NewProductDto;
import com.example.clevertec_test_task.dto.ProductDto;
import com.example.clevertec_test_task.entity.Product;
import com.example.clevertec_test_task.exception.DBNotFoundException;
import com.example.clevertec_test_task.mapper.NewProductMapper;
import com.example.clevertec_test_task.mapper.ProductMapper;
import com.example.clevertec_test_task.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;
    private final NewProductMapper newProductMapper;

    private final String PRODUCT_NOT_FOUND_MESSAGE = "There is no such a product in database";

    @Override
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException(PRODUCT_NOT_FOUND_MESSAGE));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDto(products);
    }

    @Override
    public ProductDto saveProduct(NewProductDto newProductDto) {
        Product product = productRepository.save(newProductMapper.toEntity(newProductDto));
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto updateProduct(Long id, NewProductDto newProductDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException(PRODUCT_NOT_FOUND_MESSAGE));

        product.setName(newProductDto.getName());
        product.setPrice(newProductDto.getPrice());

        Product updatedProduct = productRepository.save(product);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }
}
