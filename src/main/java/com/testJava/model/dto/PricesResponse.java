package com.testJava.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.testJava.model.persistence.Brand;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonDeserialize(builder = PricesResponse.Builder.class)
public class PricesResponse {
    private final Brand brand;
    private final Long productId;
    private final BigDecimal amount;
    private final Long priceList;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public Brand getBrand() {
        return brand;
    }

    public Long getProductId() {
        return productId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getPriceList() {
        return priceList;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    private PricesResponse(Builder builder) {
        brand = builder.brand;
        productId = builder.productId;
        amount = builder.amount;
        priceList = builder.priceList;
        startDate = builder.startDate;
        endDate = builder.endDate;
    }

    @JsonPOJOBuilder
    public static final class Builder {
        private Brand brand;
        private Long productId;
        private BigDecimal amount;
        private Long priceList;
        private LocalDateTime startDate;
        private LocalDateTime endDate;

        public Builder() {
        }

        public Builder brand(Brand val) {
            brand = val;
            return this;
        }

        public Builder productId(Long val) {
            productId = val;
            return this;
        }

        public Builder amount(BigDecimal val) {
            amount = val;
            return this;
        }

        public Builder priceList(Long val) {
            priceList = val;
            return this;
        }

        public Builder startDate(LocalDateTime val) {
            startDate = val;
            return this;
        }

        public Builder endDate(LocalDateTime val) {
            endDate = val;
            return this;
        }

        public PricesResponse build() {
            return new PricesResponse(this);
        }
    }

    @Override
    public String toString() {
        return "PricesResponse{" +
                "brand=" + brand +
                ", productId=" + productId +
                ", amount=" + amount +
                ", priceList=" + priceList +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
