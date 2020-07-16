package com.project.toyboardapp.biz.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_CUSTOMER")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long id; // 숫자 기본키 => 성능 좋아진다.
    @Column(nullable = false, name = "USER_ID", length = 20, updatable = false)
    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$",
            message="아이디(이메일) 형식에 맞지 않습니다.")
    private String userId; // 아이디: 문자열 유니크
    @Column(nullable = false, name = "USER_NM", length = 50, updatable = true)
    private String userNm; // 이름
    @Column(nullable = false, name = "USER_PASS", length = 100, updatable = true)
    private String userPass; // 패스워드
    @Column(nullable = false, name = "USER_LEVEL")
    private Customer_Level_Enum userLevel;
}
