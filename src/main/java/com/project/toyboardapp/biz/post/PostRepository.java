package com.project.toyboardapp.biz.post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    //JpaRepository에서 메서드명의 By 이후는 SQL의 where 조건 절에 대응, Containing을 붙여주면 Like 검색이됨
    List<PostEntity> findByTitleContaining(String keyword);
}

