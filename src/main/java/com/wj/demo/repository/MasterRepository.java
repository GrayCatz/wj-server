package com.wj.demo.repository;

import com.wj.demo.entity.Master;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MasterRepository extends PagingAndSortingRepository<Master, Long>, JpaSpecificationExecutor<Master> {
}
