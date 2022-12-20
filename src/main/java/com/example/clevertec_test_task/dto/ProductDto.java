package com.example.clevertec_test_task.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDto extends AbstractDto {
    private Long id;
    private String name;
    private Double price;
}
