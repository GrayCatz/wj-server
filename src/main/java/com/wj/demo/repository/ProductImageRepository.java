package com.wj.demo.repository;

import com.wj.demo.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductImageRepository extends PagingAndSortingRepository<ProductImage, Long>, JpaSpecificationExecutor<ProductImage> {
}
