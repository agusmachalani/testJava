package com.testJava.service;

import com.testJava.model.dto.PricesResponse;
import com.testJava.repository.PricesRepository;
import com.testJava.translator.PricesTranslator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricesService {
    private final PricesRepository repository;
    private final PricesTranslator translator;

    public PricesService(PricesRepository repository, PricesTranslator translator) {
        this.repository = repository;
        this.translator = translator;
    }

    public List<PricesResponse> search(LocalDateTime date, Long productId, Integer brandId) {
        return repository.getPrices(productId, brandId, date)
                .stream()
                .map(translator::toResponse)
                .collect(Collectors.toList());
    }
}
