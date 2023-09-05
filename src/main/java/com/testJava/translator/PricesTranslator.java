package com.testJava.translator;

import com.testJava.model.dto.PricesResponse;
import com.testJava.model.persistence.Brand;
import com.testJava.model.persistence.Prices;
import org.springframework.stereotype.Service;

@Service
public class PricesTranslator {

    public PricesResponse toResponse(Prices prices) {
        return new PricesResponse.Builder()
                .productId(prices.getProductId())
                .brand(new Brand.Builder().id(prices.getBrand().getId()).name(prices.getBrand().getName()).build())
                .priceList(prices.getPriceList())
                .startDate(prices.getStartDate())
                .endDate(prices.getEndDate())
                .amount(prices.getAmount())
                .build();
    }
}
