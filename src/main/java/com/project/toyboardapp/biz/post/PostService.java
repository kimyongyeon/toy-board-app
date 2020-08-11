package com.project.toyboardapp.biz.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostService {
    @Autowired
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

    @Transactional
    public void deletePost(Long postNo) {
        postRepository.deleteById(postNo);
    }


    //검색
    @Transactional
    public List<PostDTO> searchPosts(String keyword) {
        List<PostEntity> postEntities = postRepository.findByPostTitleContaining(keyword);
        List<PostDTO> postDTOList = new ArrayList<>();

        if (postEntities.isEmpty()) return postDTOList;

        for (PostEntity postEntity : postEntities) {
            postDTOList.add(this.convertEntityToDto(postEntity));
        }
        return postDTOList;
    }

    private PostDTO convertEntityToDto(PostEntity postEntity) {
        return PostDTO.builder()
                .postNo(postEntity.getPostNo())
                .postTitle(postEntity.getPostTitle())
                .postContents(postEntity.getPostContents())
                .postWriter(postEntity.getPostWriter())
                .createdDate(postEntity.getCreatedDate())
                .build();
    }

    //페이지
    private static final int BLOCK_PAGE_NUM_COUNT = 5;  // 블럭에 존재하는 페이지 번호 수
    private static final int PAGE_POST_COUNT = 4;       // 한 페이지에 존재하는 게시글 수

    @Transactional
    public List<PostDTO> getPostList(Integer pageNum) {
        Page<PostEntity> page = postRepository.findAll(PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.ASC, "createdDate")));

        List<PostEntity> postEntities = page.getContent();
        List<PostDTO> postDTOList = new ArrayList<>();

        for (PostEntity postEntity : postEntities) {
            postDTOList.add(this.convertEntityToDto(postEntity));
        }

        return postDTOList;
    }

    @Transactional
    public Long getBoardCount() {
        return postRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        // 총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getBoardCount());

        // 총 게시글 기준으로 계산한 마지막 페이지 번호 계산 (올림으로 계산)
        Integer totalLastPageNum = (int)(Math.ceil((postsTotalCount/PAGE_POST_COUNT)));

        // 현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        // 페이지 시작 번호 조정
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        // 페이지 번호 할당
        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }

}















