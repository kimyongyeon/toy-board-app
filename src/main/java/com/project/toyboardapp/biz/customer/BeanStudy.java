package com.project.toyboardapp.biz.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

// AOP : Annotation을 가지고 공통처리
@Service // Biz Bean
//@Component // System Bean
public class BeanStudy {
    // 빈(스프링) = 인스턴스(자바)
    private String name;

    @Configuration
    static class BeanStudyConfig {
        @Bean(name = "beanStudy2")
        public BeanStudy beanStudy() {
            return new BeanStudy();
        }
    }

    @Autowired
    BeanStudy beanStudy;
}
