package com.project.toyboardapp.biz.customer;

import lombok.Data;

@Data
public class ApiResponse<T> {
    int code;
    String msg;
    T body;
}
