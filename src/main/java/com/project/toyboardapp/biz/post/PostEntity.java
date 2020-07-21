package com.project.toyboardapp.biz.post;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "TB_POST")
public class PostEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;

    @Column
    private String postTitle;

    @Column
    private String postContents;

    @Column
    private String postWriter;

}
