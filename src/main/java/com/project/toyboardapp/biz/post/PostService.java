package com.project.toyboardapp.biz.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class PostService {
    private PostRepository postRepository;

    @Transactional
    public Long savePost(PostDTO postDTO){
        return postRepository.save(postDTO.toEntity()).getPostNo();
    }
}
