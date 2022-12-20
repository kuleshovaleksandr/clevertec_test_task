package com.example.clevertec_test_task.controller;

import com.example.clevertec_test_task.dto.NewProductDto;
import com.example.clevertec_test_task.dto.ProductDto;
import com.example.clevertec_test_task.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody NewProductDto newProductDto) {
        return new ResponseEntity<>(productService.saveProduct(newProductDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> editProduct(@PathVariable("id") Long id,
                                            @RequestBody NewProductDto newProductDto) {
        return new ResponseEntity<>(productService.updateProduct(id, newProductDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
}
