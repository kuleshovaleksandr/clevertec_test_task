package com.example.clevertec_test_task.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class NewDiscountCardDto extends AbstractDto {
    private Integer number;
    private Integer discount;
}
