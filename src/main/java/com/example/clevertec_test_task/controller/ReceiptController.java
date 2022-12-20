package com.example.clevertec_test_task.controller;

import com.example.clevertec_test_task.model.Receipt;
import com.example.clevertec_test_task.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipt")
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @GetMapping("/")
    public Receipt getReceipt() {
        return receiptService.getReceipt();
    }
}
