package com.testJava.model.persistence;

import com.testJava.model.dto.Currency;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices", schema = "testJava",
        indexes = {@Index(name = "idx_prices__product_id", columnList = "product_id"),})
public class Prices implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;
    @Column(name = "price_list", nullable = false)
    private Long priceList;
    @Column(name = "product_id", nullable = false, length = 20)
    private Long productId;
    @Column(name = "priority",nullable = false, length = 20)
    private Integer priority;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false, length = 10)
    private Currency currency;

    private Prices(Builder builder) {
        id = builder.id;
        brand = builder.brand;
        startDate = builder.startDate;
        endDate = builder.endDate;
        priceList = builder.priceList;
        productId = builder.productId;
        priority = builder.priority;
        amount = builder.amount;
        currency = builder.currency;
    }

    public Prices() {

    }

    public Long getId() {
        return id;
    }

    public Brand getBrand() {
        return brand;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public static final class Builder {
        private Long id;
        private Brand brand;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Long priceList;
        private Long productId;
        private Integer priority;
        private BigDecimal amount;
        private Currency currency;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder brand(Brand val) {
            brand = val;
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

        public Builder priceList(Long val) {
            priceList = val;
            return this;
        }

        public Builder productId(Long val) {
            productId = val;
            return this;
        }

        public Builder priority(Integer val) {
            priority = val;
            return this;
        }

        public Builder amount(BigDecimal val) {
            amount = val;
            return this;
        }

        public Builder currency(Currency val) {
            currency = val;
            return this;
        }

        public Prices build() {
            return new Prices(this);
        }
    }

    @Override
    public java.lang.String toString() {
        return "Prices{" +
                "id=" + id +
                ", brand=" + brand.toString() +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", priceList=" + priceList +
                ", productId='" + productId + '\'' +
                ", priority=" + priority +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
