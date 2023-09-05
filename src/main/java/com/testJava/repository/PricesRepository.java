package com.testJava.repository;

import com.testJava.model.persistence.Prices;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends CrudRepository<Prices, Long>{
    @Query(nativeQuery = true,
            value = "SELECT * FROM prices WHERE"
            + " product_id = :productId AND"
            + " brand_id = :brandId AND"
            + " :date BETWEEN start_date and end_date")
    List<Prices> getPrices(Long productId,
                           Integer brandId,
                           LocalDateTime date);
}
