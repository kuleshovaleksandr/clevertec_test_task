package com.example.clevertec_test_task.controller;

import com.example.clevertec_test_task.dto.DiscountCardDto;
import com.example.clevertec_test_task.dto.NewDiscountCardDto;
import com.example.clevertec_test_task.service.DiscountCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discount_cards")
@RequiredArgsConstructor
public class DiscountCardController {

    private final DiscountCardService discountCardService;

    @GetMapping("/{id}")
    public ResponseEntity<DiscountCardDto> getDiscountCard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(discountCardService.getDiscountCardById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DiscountCardDto>> getAllDiscountCards() {
        return new ResponseEntity<>(discountCardService.getAllDiscountCards(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<DiscountCardDto> createDiscountCard
            (@RequestBody NewDiscountCardDto newDiscountCardDto) {
        return new ResponseEntity<>(discountCardService.saveDiscountCard(newDiscountCardDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountCardDto> editDiscountCard
            (@PathVariable("id") Long id, @RequestBody NewDiscountCardDto newDiscountCardDto) {
        return new ResponseEntity<>(discountCardService.updateDiscountCard(id, newDiscountCardDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiscountCard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(discountCardService.deleteDiscountCard(id), HttpStatus.OK);
    }
}
