package com.project.toyboardapp;

import com.project.toyboardapp.biz.customer.CustomerEntity;
import com.project.toyboardapp.biz.customer.CustomerRepository;
import com.project.toyboardapp.biz.customer.Customer_Level_Enum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class ToyBoardAppApplication implements ApplicationRunner {

    @Autowired
    CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ToyBoardAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello Toy Project");
        defaultCustomers();
    }

    private void defaultCustomers() {
        System.out.println("customer data insert start");
        for(int i=0; i<10; i++) {
            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setId(Long.parseLong(i+""));
            customerEntity.setUserId("userId" + i +"@gmail.com");
            customerEntity.setUserPass("userPass::" + i);
            customerEntity.setUserNm("userName::"+i);
            customerEntity.setUserLevel(Customer_Level_Enum.getCustomer_Level_Enum()); // 랜덤으로 게스트, 사용자, 관리자
            repository.save(customerEntity);
        }

        System.out.println("customer data insert end");
    }
}
