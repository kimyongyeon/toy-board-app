package com.project.toyboardapp.biz.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class CommonExceptionController {

//    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeException(RuntimeException e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(500);
        apiResponse.setMsg(e.getMessage());
        apiResponse.setBody(null);
        return new ResponseEntity(apiResponse, HttpStatus.BAD_GATEWAY);
        /**
         * {
         *  code: 500,
         *  msg: e.getMessage()
         *  body: null
         * }
         */

    }
}
