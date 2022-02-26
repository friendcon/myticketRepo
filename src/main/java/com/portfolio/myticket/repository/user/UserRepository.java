package com.portfolio.myticket.repository.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRepository {
    public int checkId(String id);
}
