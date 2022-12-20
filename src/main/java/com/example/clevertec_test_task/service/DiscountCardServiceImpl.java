package com.example.clevertec_test_task.service;

import com.example.clevertec_test_task.dto.DiscountCardDto;
import com.example.clevertec_test_task.dto.NewDiscountCardDto;
import com.example.clevertec_test_task.entity.DiscountCard;
import com.example.clevertec_test_task.exception.DBNotFoundException;
import com.example.clevertec_test_task.mapper.DiscountCardMapper;
import com.example.clevertec_test_task.mapper.NewDiscountCardMapper;
import com.example.clevertec_test_task.repository.DiscountCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountCardServiceImpl implements DiscountCardService {

    private final DiscountCardRepository discountCardRepository;

    private final DiscountCardMapper discountCardMapper;
    private final NewDiscountCardMapper newDiscountCardMapper;

    private final String DISCOUNT_CARD_NOT_FOUND_MESSAGE = "There is no such a discount card in database";

    @Override
    public DiscountCardDto getDiscountCardByNumber(Integer number) {
        DiscountCard discountCard = discountCardRepository.findDiscountCardByNumber(number)
                .orElseThrow(() -> new DBNotFoundException(DISCOUNT_CARD_NOT_FOUND_MESSAGE));
        return discountCardMapper.toDto(discountCard);
    }

    @Override
    public DiscountCardDto getDiscountCardById(Long id) {
        DiscountCard discountCard = discountCardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException(DISCOUNT_CARD_NOT_FOUND_MESSAGE));
        return discountCardMapper.toDto(discountCard);
    }

    @Override
    public List<DiscountCardDto> getAllDiscountCards() {
        List<DiscountCard> discountCards = discountCardRepository.findAll();
        return discountCardMapper.toDto(discountCards);
    }

    @Override
    public DiscountCardDto saveDiscountCard(NewDiscountCardDto newDiscountCardDto) {
        DiscountCard discountCard = discountCardRepository
                .save(newDiscountCardMapper.toEntity(newDiscountCardDto));
        return discountCardMapper.toDto(discountCard);
    }

    @Override
    public DiscountCardDto updateDiscountCard(Long id, NewDiscountCardDto newDiscountCardDto) {
        DiscountCard discountCard = discountCardRepository.findById(id)
                .orElseThrow(() -> new DBNotFoundException(DISCOUNT_CARD_NOT_FOUND_MESSAGE));

        discountCard.setNumber(newDiscountCardDto.getNumber());
        discountCard.setDiscount(newDiscountCardDto.getDiscount());

        DiscountCard updatedDiscountCard = discountCardRepository.save(discountCard);
        return discountCardMapper.toDto(updatedDiscountCard);
    }

    @Override
    public boolean deleteDiscountCard(Long id) {
        discountCardRepository.deleteById(id);
        return true;
    }
}
