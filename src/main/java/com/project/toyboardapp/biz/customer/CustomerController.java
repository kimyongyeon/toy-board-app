package com.project.toyboardapp.biz.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/view/customer")
public class CustomerController {
    @GetMapping("/")
    public String list() {
        return "CustomerView";
    }
    @GetMapping("/detail")
    public String detail() {
        return "CustomerDetail";
    }
}
