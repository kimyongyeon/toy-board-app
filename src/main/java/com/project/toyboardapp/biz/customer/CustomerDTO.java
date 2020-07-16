package com.project.toyboardapp.biz.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Long id; // 숫자 기본키 => 성능 좋아진다.
    private String userId; // 아이디: 문자열 유니크
    private String userNm; // 이름
    private String userPass; // 패스워드
    private Customer_Level_Enum userLevel;
}
