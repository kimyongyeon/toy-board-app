package com.project.toyboardapp.biz.post;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostDTO {
    private Long postNo;
    private String postTitle;
    private String postContents;
    private String postWriter;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public PostEntity toEntity(){
        PostEntity postEntity = PostEntity.builder()
                .postNo(postNo)
                .postTitle(postTitle)
                .postContents(postContents)
                .postWriter(postWriter)
                .build();
        return postEntity;
    }

    @Builder
    public PostDTO(Long postNo, String postTitle, String postContents, String postWriter,
                   LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.postNo = postNo;
        this.postTitle = postTitle;
        this.postContents = postContents;
        this.postWriter = postWriter;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }



}
