package com.project.toyboardapp.biz.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    //게시판 조회
    @GetMapping("/list")
    public String list(Model model) {
        List<PostDTO> postList = postService.getPostList();
        model.addAttribute("postList", postList);
        return "/board/list";
    }

    @GetMapping("/list/{postNo}")
    public String detail(@PathVariable("postNo") Long postNo, Model model) {
        PostDTO postDTO = postService.getPost(postNo);

        model.addAttribute("postDTO", postDTO);
        return "board/detail.html";
    }

    //게시판 글쓰기
    @GetMapping("/write")
    public String write() {
        return "/board/write";
    }

    @PostMapping("/write")
    public String write(PostDTO postDTO) {
        postService.savePost(postDTO);
        return "redirect:/post/list";
    }



}
