package com.example.clevertec_test_task.service;

import com.example.clevertec_test_task.dto.DiscountCardDto;
import com.example.clevertec_test_task.dto.NewDiscountCardDto;

import java.util.List;

public interface DiscountCardService {

    DiscountCardDto getDiscountCardByNumber(Integer number);
    DiscountCardDto getDiscountCardById(Long id);

    List<DiscountCardDto> getAllDiscountCards();

    DiscountCardDto saveDiscountCard(NewDiscountCardDto newDiscountCardDto);

    DiscountCardDto updateDiscountCard(Long id, NewDiscountCardDto newDiscountCardDto);

    boolean deleteDiscountCard(Long id);
}
