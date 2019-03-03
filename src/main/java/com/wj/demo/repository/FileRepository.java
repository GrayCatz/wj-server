package com.wj.demo.repository;

import com.wj.demo.entity.File;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends PagingAndSortingRepository<File, Long>, JpaSpecificationExecutor<File> {
}
