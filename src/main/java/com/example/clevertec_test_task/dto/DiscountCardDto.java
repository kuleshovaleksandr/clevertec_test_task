package com.example.clevertec_test_task.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DiscountCardDto extends AbstractDto {
    private Long id;
    private Integer number;
    private Integer discount;
}
