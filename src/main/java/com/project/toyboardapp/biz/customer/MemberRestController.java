package com.project.toyboardapp.biz.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/customer")
public class MemberRestController {
    @Autowired
    MemberRepository repository;

    @GetMapping("/")
    public List<MemberDTO> list() {
        return repository.findAll().stream()
                .map(c -> {
                    MemberDTO memberDTO = new MemberDTO();
                    memberDTO.setId(c.getId());
                    memberDTO.setUserId(c.getUserId());
                    memberDTO.setUserPass(c.getUserPass());
                    memberDTO.setUserNm(c.getUserNm());
                    memberDTO.setUserLevel(c.getUserLevel());
                    return memberDTO;
                }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MemberDTO one(@PathVariable Long id) {
        MemberEntity memberEntity = repository.findById(id).get();
        return MemberDTO.builder()
                .id(memberEntity.getId())
                .userId(memberEntity.getUserId())
                .userNm(memberEntity.getUserNm())
                .userPass(memberEntity.getUserPass())
                .userLevel(memberEntity.getUserLevel())
                .build();
    }
}
