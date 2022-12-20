package com.example.clevertec_test_task.service;

import com.example.clevertec_test_task.builder.ReceiptBuilder;
import com.example.clevertec_test_task.dto.ProductDto;
import com.example.clevertec_test_task.model.Receipt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptBuilder receiptBuilder;

    private final String SHOP_NAME = "SUPERMARKET 123";
    private final String SHOP_ADDRESS = "12, MILKYWAY Galaxy/Earth";
    private final String SHOP_PHONE_NUMBER = "123-456-7890";

    private final Integer PRODUCTS_QUANTITY_FOR_DISCOUNT = 5;
    private final Double DISCOUNT_RATE = 10.0;

    @Override
    public Receipt getReceipt() {
        Receipt receipt = receiptBuilder.getReceipt();
        String formedReceipt = formWholeReceipt(receipt).toString();

        printReceiptInConsole(formedReceipt);
        printReceiptInFile(formedReceipt);

        return receiptBuilder.getReceipt();
    }

    private StringBuilder formWholeReceipt(Receipt receipt) {

        StringBuilder printedReceipt = new StringBuilder();

        Double total = 0.0, totalWithDiscount;

        printedReceipt.append("                   RECEIPT\n")
                .append(String.format("               %8S\n", SHOP_NAME))
                .append(String.format("          %4s\n", SHOP_ADDRESS))
                .append(String.format("              Tel: %4s\n\n", SHOP_PHONE_NUMBER))
                .append(String.format("CASHIER: #1520                    DATE:%s\n", getCurrentDate()))
                .append(String.format("                                  TIME:%s\n", getCurrentTime()))
                .append("-------------------------------------------------\n")
                .append(" QTY   DESCRIPTION                PRICE    TOTAL \n");

        for(Map.Entry<ProductDto, Integer> entry: receipt.getProductsInReceipt().entrySet()) {
            Integer quantity = entry.getValue();
            String name = entry.getKey().getName();
            Double price = entry.getKey().getPrice();

            printedReceipt.append(String.format("  %-4d %-26s $%-7.2f $%-7.2f\n",
                            quantity, name, price, price * quantity));

            if(quantity >= PRODUCTS_QUANTITY_FOR_DISCOUNT) {
                price *= (1 - (DISCOUNT_RATE / 100.0));
                printedReceipt.append(String.format("\t\t\t\t\twith %.0f%% discount \t   $%-7.2f\n",
                                DISCOUNT_RATE, price * quantity));
            }
            total += price * quantity;
        }

        printedReceipt.append("-------------------------------------------------\n")
                .append(String.format("TOTAL%43s\n", ("$" + String.format("%.2f", total))));

        if(receipt.getDiscountCard() != null) {
            Integer cardNumber = receipt.getDiscountCard().getNumber();
            totalWithDiscount = total * (1 - (receipt.getDiscountCard().getDiscount() / 100.0));
            Double discount = total - totalWithDiscount;

            printedReceipt.append(String.format("Discount card %s applied\n", cardNumber))
                    .append(String.format("Your discount %34s\n", ("$" + String.format("%.2f", discount))))
                    .append(String.format("TOTAL%43s\n", ("$" + String.format("%.2f", totalWithDiscount))));
        }

        return printedReceipt;
    }

    private String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime date = LocalDateTime.now();
        return dtf.format(date);
    }

    private String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        return dtf.format(time);
    }

    private void printReceiptInConsole(String receipt) {
        System.out.println(receipt);
    }

    private void printReceiptInFile(String receipt) {
        try(FileWriter writer = new FileWriter("receipt.txt")) {
            writer.write(receipt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
