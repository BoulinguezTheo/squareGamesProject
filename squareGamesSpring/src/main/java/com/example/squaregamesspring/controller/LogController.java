package com.example.squaregamesspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);
    @RequestMapping("/")
    public String index(){
        logger.trace("----------Trace message----------");
        logger.debug("----------Debug message----------");
        logger.info("----------info message----------");
        logger.warn("----------Warn message----------");
        logger.error("----------Error message----------");
        return "logger message";
    }
}
