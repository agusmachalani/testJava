package com.testJava.service;

import com.testJava.model.dto.PricesResponse;
import com.testJava.model.persistence.Prices;
import com.testJava.repository.PricesRepository;
import com.testJava.service.PricesService;
import com.testJava.translator.PricesTranslator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricesServiceTest {

    @InjectMocks
    private PricesService service;
    @Mock
    private PricesRepository repository;
    @Mock
    private PricesTranslator translator;
    @Mock
    private Prices prices;
    @Mock
    private PricesResponse response;

    private static final Long PRODUCT_ID= 35455L;
    private static final Integer BRAND_ID= 1;
    private static final LocalDateTime DATE= LocalDateTime.of(2020,6,14,11,0,0);


    @Test
    void getPrices(){
        when(repository.getPrices(PRODUCT_ID,BRAND_ID,DATE)).thenReturn(List.of(prices));
        when(translator.toResponse(prices)).thenReturn(response);
        var res = service.search(DATE, PRODUCT_ID, BRAND_ID);

        assertEquals(List.of(response), res);
    }
}
