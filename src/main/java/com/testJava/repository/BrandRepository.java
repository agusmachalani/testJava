package com.testJava.repository;

import com.testJava.model.persistence.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends CrudRepository<Brand,Long> {
}
