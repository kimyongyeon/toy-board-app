package com.project.toyboardapp.biz.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/customer")
public class CustomerRestController {
    @Autowired
    CustomerRepository repository;

    @GetMapping("/")
    public List<CustomerDTO> list() {
        return repository.findAll().stream()
                .map(c -> {
                    CustomerDTO customerDTO = new CustomerDTO();
                    customerDTO.setId(c.getId());
                    customerDTO.setUserId(c.getUserId());
                    customerDTO.setUserPass(c.getUserPass());
                    customerDTO.setUserNm(c.getUserNm());
                    customerDTO.setUserLevel(c.getUserLevel());
                    return customerDTO;
                }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CustomerDTO one(@PathVariable Long id) {
        CustomerEntity customerEntity = repository.findById(id).get();
        return CustomerDTO.builder()
                .id(customerEntity.getId())
                .userId(customerEntity.getUserId())
                .userNm(customerEntity.getUserNm())
                .userPass(customerEntity.getUserPass())
                .userLevel(customerEntity.getUserLevel())
                .build();
    }
}
