package com.example.clevertec_test_task.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewProductDto extends AbstractDto {
    private String name;
    private Double price;
}
