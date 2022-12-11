package com.ZH.community;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author zh
 * @Email p1007zh@163.com
 * @Data 2022/12/3 12:05
 * @Description
 */
@SpringBootTest
@ContextConfiguration(classes=CommunityApplication.class)
public class LoggerTest {

    private static final Logger logger= LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void loggerTest(){
        System.out.println(logger.getName());
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
