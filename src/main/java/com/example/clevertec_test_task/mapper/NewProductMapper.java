package com.example.clevertec_test_task.mapper;

import com.example.clevertec_test_task.dto.NewProductDto;
import com.example.clevertec_test_task.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class NewProductMapper extends AbstractMapper<Product, NewProductDto> {

    public NewProductMapper() {
        super(Product.class, NewProductDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(NewProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setId))
                .setPostConverter(toEntityConverter());
    }
}
