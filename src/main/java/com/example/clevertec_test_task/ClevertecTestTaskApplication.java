package com.example.clevertec_test_task;

import com.example.clevertec_test_task.builder.ReceiptBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ClevertecTestTaskApplication {
    
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ClevertecTestTaskApplication.class, args);
        ReceiptBuilder builder = (ReceiptBuilder) context.getBean("receiptBuilder");
        builder.build(args);
    }
}
