package com.testJava.controller;

import com.testJava.controller.PricesController;
import com.testJava.model.dto.PricesResponse;
import com.testJava.service.PricesService;
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
public class PricesControllerTest {

    @InjectMocks
    private PricesController controller;
    @Mock
    private PricesService service;
    @Mock
    private PricesResponse response;

    private static final Long PRODUCT_ID= 123L;
    private static final Integer BRAND_ID= 456;
    private static final LocalDateTime DATE= LocalDateTime.of(2023,8,15,10,0,0);

    @Test
    void search() {
        var list = List.of(response);
        when(service.search(DATE, PRODUCT_ID, BRAND_ID)).thenReturn(list);
        var res = controller.search(DATE, PRODUCT_ID, BRAND_ID);

        assertEquals(list, res);
    }
}
