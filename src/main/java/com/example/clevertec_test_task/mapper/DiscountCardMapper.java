package com.example.clevertec_test_task.mapper;

import com.example.clevertec_test_task.dto.DiscountCardDto;
import com.example.clevertec_test_task.entity.DiscountCard;
import org.springframework.stereotype.Component;

@Component
public class DiscountCardMapper extends AbstractMapper<DiscountCard, DiscountCardDto>{

    public DiscountCardMapper() {
        super(DiscountCard.class, DiscountCardDto.class);
    }
}
