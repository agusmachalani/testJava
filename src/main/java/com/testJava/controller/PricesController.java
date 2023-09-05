package com.testJava.controller;

import com.testJava.model.dto.PricesResponse;
import com.testJava.service.PricesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/testJava")
public class PricesController {
    private final PricesService service;
    public static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public PricesController(PricesService service) {
        this.service = service;
    }

    @GetMapping("/prices")
    public List<PricesResponse> search(@RequestParam(name = "date") @DateTimeFormat(pattern =LOCAL_DATE_TIME_FORMAT)
                                           LocalDateTime date,
                                       @RequestParam(name= "productId") Long productId,
                                       @RequestParam(name= "brandId") Integer brandId) {

       return service.search(date, productId, brandId);
    }

}
