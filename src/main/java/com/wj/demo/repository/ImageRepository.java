package com.wj.demo.repository;

import com.wj.demo.entity.Image;
import com.wj.demo.entity.OrderImage;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends PagingAndSortingRepository<Image, Long>, JpaSpecificationExecutor<Image> {
}
