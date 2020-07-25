package com.project.toyboardapp.biz.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAPI {

    @GetMapping("/customer/api")
    public ResponseEntity customerApi(CustomerDTO customerDTO) {

        CustomerDTO dto = new CustomerDTO();
        dto.setId(1L);
        dto.setUserNm("blooar");
        dto.setUserId("customer id");
        dto.setUserLevel(Customer_Level_Enum.USER);
        dto.setUserPass("123123");

        ApiResponse<CustomerDTO> apiResponse = new ApiResponse<>();

        // 4XX : 클라이언트 에러 => 브라우저 값을 제대로 입력 안함
        // 404 : 페이지 없음
        // 5XX : 서버에러 => 서버에서 처리하다가 DB 오류 / 통신 장애
        // 2XX : 정상 => ???

        if (customerDTO.equals("")) {
            apiResponse.setCode(400); // 비정상
            apiResponse.setMsg("dto is null");
        } else {
            apiResponse.setCode(200); // 정상
            apiResponse.setMsg("success");
        }
        apiResponse.setBody(dto);

        if (1 == 1) {
            throw new RuntimeException("가짜 에러 입니다.");
        }

        return new ResponseEntity(apiResponse, HttpStatus.OK);
    }
}
