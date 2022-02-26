package com.portfolio.myticket.repository;

import com.portfolio.myticket.repository.user.UserRepository;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RepositoryConnectTests {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void connectTest() {
        try(Connection con = sqlSessionFactory.openSession().getConnection()){
            logger.info("연결 성공");
        } catch (Exception e) {
            logger.error("연결 실패");
        }
    }

    @Test
    public void getId() {
        int n = userRepository.checkId("dsd");
        logger.info("결과 : "+ n);
    }
}
