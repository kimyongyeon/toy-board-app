package com.project.toyboardapp.biz.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "board/detail";
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

    //게시글 수정하기
    @GetMapping("/edit/{postNo}")
    public String edit(@PathVariable("postNo") Long postNo, Model model) {
        PostDTO postDTO = postService.getPost(postNo);

        model.addAttribute("postDTO", postDTO);
        return "board/update";
    }

    @PostMapping("/edit/{postNo}")
    public String update(PostDTO postDTO) {
        postService.savePost(postDTO);

        return "redirect:/post/list/{postNo}";
    }

    //게시글 삭제하기
    @PostMapping("/list/{postNo}")
    public String delete(@PathVariable("postNo") Long postNo) {
        postService.deletePost(postNo);

        return "redirect:/post/list";
    }

    //검색
    @GetMapping("/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model) {
        List<PostDTO> postDTOList = postService.searchPosts(keyword);

        model.addAttribute("postList", postDTOList);

        return "board/list";
    }

    //페이징
    @GetMapping("/")
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        List<PostDTO> postList = postService.getPostList(pageNum);
        Integer[] pageList = postService.getPageList(pageNum);

        model.addAttribute("postList", postList);
        model.addAttribute("pageList", pageList);

        return "board/list";
    }
}
