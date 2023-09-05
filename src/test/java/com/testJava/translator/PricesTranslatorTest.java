package com.testJava.translator;

import com.testJava.model.persistence.Brand;
import com.testJava.model.persistence.Prices;
import com.testJava.translator.PricesTranslator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesTranslatorTest {

    @InjectMocks
    private PricesTranslator translator;
    @Mock
    private Prices prices;

    private static final Long PRODUCT_ID= 123L;
    private static final Long BRAND_ID= 456L;
    private static final LocalDateTime START_DATE= LocalDateTime.of(2023,8,15,10,0,0);
    private static final LocalDateTime END_DATE= LocalDateTime.of(2023,8,16,10,0,0);


    @Test
    void toResponse() {
        var brand= new Brand.Builder().id(BRAND_ID).name("ZARA").build();
        when(prices.getBrand()).thenReturn(brand);
        when(prices.getProductId()).thenReturn(PRODUCT_ID);
        when(prices.getStartDate()).thenReturn(START_DATE);
        when(prices.getEndDate()).thenReturn(END_DATE);
        when(prices.getAmount()).thenReturn(BigDecimal.ONE);

        var res = translator.toResponse(prices);

        assertEquals(PRODUCT_ID, res.getProductId());
        assertEquals(START_DATE, res.getStartDate());
        assertEquals(END_DATE, res.getEndDate());
        assertNotNull(res.getBrand());
        assertEquals(brand.getId(), res.getBrand().getId());
        assertEquals(brand.getName(), res.getBrand().getName());
    }
}
