package com.project.toyboardapp.biz.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_MEMBER")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "ID")
    private Long id; // 숫자 기본키 => 성능 좋아진다. 결과 => ID varchar(255) not null

    @Column(nullable = false, name = "USER_ID", length = 20, updatable = false, unique = true)
    @Pattern(regexp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$",
            message="아이디(이메일) 형식에 맞지 않습니다.")
    private String userId; // 아이디: 문자열 유니크 , 결과 => alter table TB_CUSTOMER add constraint UK_Xxx unique (USER_ID)

    @Column(nullable = false, name = "USER_NM", length = 50, updatable = true, columnDefinition = "varchar(100) default 'EMPTY'")
    private String userNm; // 이름

    @Column(nullable = false, name = "USER_PASS", length = 100, updatable = true)
    private String userPass; // 패스워드 , 결과 => USER_PASS varchar(100)

    @Column(nullable = false, name = "USER_LEVEL")
    @Enumerated(EnumType.STRING) // ORDINAL: 순서를 데이터베이스에 저장, STRING: 이름을 데이터베이스에 저장
    private Member_Level_Enum userLevel;

    @Lob
    private String lobString; // 오라클: lobString clob, lobString longtext

    @Lob
    private byte[] lobByte; // 오라클: lobByte blob

    @Transient
    private Integer temp; // 데이터베이스에 저장하지 않고 조회하지도 않는다. 객체에 임시로 어떤 값을 보관하고 싶을때 사용한다.

    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;
}
