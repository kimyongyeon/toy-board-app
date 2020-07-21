package com.project.toyboardapp.biz.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "TB_POST")
public class PostEntity extends TimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    @Column
    private String postTitle;

    @Column
    private String postContents;

    @Column
    private String postWriter;

    @Builder
    public PostEntity(Long postNo, String postTitle, String postContents, String postWriter){
        this.postNo = postNo;
        this.postTitle = postTitle;
        this.postContents = postContents;
        this.postWriter = postWriter;
    }


}
