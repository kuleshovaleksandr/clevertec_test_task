package com.example.clevertec_test_task.mapper;

import com.example.clevertec_test_task.dto.NewDiscountCardDto;
import com.example.clevertec_test_task.entity.DiscountCard;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class NewDiscountCardMapper extends AbstractMapper<DiscountCard, NewDiscountCardDto> {

    public NewDiscountCardMapper() {
        super(DiscountCard.class, NewDiscountCardDto.class);
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(NewDiscountCardDto.class, DiscountCard.class)
                .addMappings(m -> m.skip(DiscountCard::setId))
                .setPostConverter(toEntityConverter());
    }
}
