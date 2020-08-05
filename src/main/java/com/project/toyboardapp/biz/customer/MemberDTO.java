package com.project.toyboardapp.biz.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long id; // 숫자 기본키 => 성능 좋아진다.
    private String userId; // 아이디: 문자열 유니크
    private String userNm; // 이름
    private String userPass; // 패스워드
    private Member_Level_Enum userLevel;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .userId(userId)
                .userNm(userNm)
                .userPass(userPass)
                .build();
    }
}

