package com.wj.demo.repository;

import com.wj.demo.entity.Token;
import com.wj.demo.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokenRepository extends PagingAndSortingRepository<Token, Long>, JpaSpecificationExecutor<Token> {
    Token findByTicket(String ticket);
}
