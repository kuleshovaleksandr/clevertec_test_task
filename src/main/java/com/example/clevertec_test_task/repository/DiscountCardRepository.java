package com.example.clevertec_test_task.repository;

import com.example.clevertec_test_task.entity.DiscountCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiscountCardRepository extends JpaRepository<DiscountCard, Long> {

    Optional<DiscountCard> findDiscountCardByNumber(Integer number);
}
