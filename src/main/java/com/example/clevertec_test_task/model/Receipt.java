package com.example.clevertec_test_task.model;

import com.example.clevertec_test_task.dto.DiscountCardDto;
import com.example.clevertec_test_task.dto.ProductDto;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Data
@NoArgsConstructor
public class Receipt {

    private Map<ProductDto, Integer> productsInReceipt;
    private DiscountCardDto discountCard;
}
