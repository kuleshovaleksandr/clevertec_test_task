package com.example.clevertec_test_task.builder;

import com.example.clevertec_test_task.dto.DiscountCardDto;
import com.example.clevertec_test_task.dto.ProductDto;
import com.example.clevertec_test_task.model.Receipt;
import com.example.clevertec_test_task.service.DiscountCardService;
import com.example.clevertec_test_task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class ReceiptBuilder implements Builder {

    @Autowired
    private Receipt receipt;

    private final ProductService productService;
    private final DiscountCardService discountCardService;

    private final String PRODUCT_AND_QUANTITY_MATCHER = "\\d+-\\d+";
    private final String DISCOUNT_CARD_MATCHER = "card-\\d+";

    private Map<ProductDto, Integer> products = new HashMap<>();

    @Autowired
    public ReceiptBuilder(ProductService productService, DiscountCardService discountCardService) {
        this.productService = productService;
        this.discountCardService = discountCardService;
    }

    public void build(String[] args) {
        if(args.length == 0) {
            return;
        }

        for(int i = 0; i < args.length; i++) {
            if(args[i].matches(PRODUCT_AND_QUANTITY_MATCHER)) {
                addProductInReceiptList(args[i]);
            } else if(args[i].matches(DISCOUNT_CARD_MATCHER)) {
                addDiscountCardInReceipt(args[i]);
            } else if(args.length == 1 && !args[i].matches(PRODUCT_AND_QUANTITY_MATCHER)) {
                readArgsFromFile(args[0]);
            }
        }
    }

    private void readArgsFromFile(String filePath) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] args = reader.readLine().split(" ");
            build(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addDiscountCardInReceipt(String arg) {
        Integer discountCardNumber = Integer.parseInt(arg.split("-")[1]);

        DiscountCardDto discountCard = discountCardService.getDiscountCardByNumber(discountCardNumber);
        receipt.setDiscountCard(discountCard);
    }

    private void addProductInReceiptList(String arg) {
        String[] productIdAndQuantity = arg.split("-");
        Long productId = Long.parseLong(productIdAndQuantity[0]);
        Integer quantity = Integer.parseInt(productIdAndQuantity[1]);

        ProductDto product = productService.getProductById(productId);

        products.put(product, quantity);
    }

    public Receipt getReceipt() {
        receipt.setProductsInReceipt(products);
        return receipt;
    }
}
