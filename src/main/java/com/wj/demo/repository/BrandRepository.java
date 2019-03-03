package com.wj.demo.repository;

import com.wj.demo.entity.Brand;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BrandRepository extends PagingAndSortingRepository<Brand, Long>, JpaSpecificationExecutor<Brand> {
    Brand findByChName(String brand);
}
