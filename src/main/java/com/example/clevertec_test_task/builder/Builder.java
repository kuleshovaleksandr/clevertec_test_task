package com.example.clevertec_test_task.builder;

import com.example.clevertec_test_task.model.Receipt;

public interface Builder {

    void build(String[] args);
    Receipt getReceipt();
}
