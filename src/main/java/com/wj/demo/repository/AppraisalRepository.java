package com.wj.demo.repository;

import com.wj.demo.entity.Appraisal;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AppraisalRepository extends PagingAndSortingRepository<Appraisal, Long>, JpaSpecificationExecutor<Appraisal> {
    List<Appraisal> findByUserId(Long userId);
}
