package com.project.toyboardapp.biz.post;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostService {
    private PostRepository postRepository;

    @Transactional
    public List<PostDTO> getPostList(){
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();

        for(PostEntity postEntity : postEntities) {
            PostDTO postDTO = PostDTO.builder()
                    .postNo(postEntity.getPostNo())
                    .postTitle(postEntity.getPostTitle())
                    .postContents(postEntity.getPostContents())
                    .postWriter(postEntity.getPostWriter())
                    .createdDate(postEntity.getCreatedDate())
                    .build();
            postDTOList.add(postDTO);
        }
        return postDTOList;

    }

    @Transactional
    public PostDTO getPost(Long postNo){
        Optional<PostEntity> postEntityWrapper = postRepository.findById(postNo);
        PostEntity postEntity = postEntityWrapper.get();

        PostDTO postDTO = PostDTO.builder()
                .postNo(postEntity.getPostNo())
                .postTitle(postEntity.getPostTitle())
                .postContents(postEntity.getPostContents())
                .postWriter(postEntity.getPostWriter())
                .createdDate(postEntity.getCreatedDate())
                .build();
        return postDTO;
    }

    @Transactional
    public Long savePost(PostDTO postDTO){
        return postRepository.save(postDTO.toEntity()).getPostNo();
    }
}
