package com.renjie.sampleuser;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.renjie.sampleuser.model.mapper")
@Slf4j
public class SampleuserApplication {

    private static final Logger logger = LoggerFactory.getLogger(SampleuserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SampleuserApplication.class, args);
        logger.info("接口文档：http://localhost:8999/swagger-ui/index.html#/");
    }

}
