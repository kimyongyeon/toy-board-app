package com.project.toyboardapp.biz.customer;

import com.project.toyboardapp.biz.post.PostDTO;
import com.project.toyboardapp.biz.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/view")
public class CustomerController {
    @GetMapping("/customer")
    public String list() {
        return "CustomerView";
    }
    @GetMapping("/detail")
    public String detail() {
        return "CustomerDetail";
    }


    //일단 여기에 postController 적어둠.
    private PostService postService;
    @GetMapping("/board")
    public String boardList() {
        return "board/list.html";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(PostDTO postDTO) {
        postService.savePost(postDTO);

        return "redirect:/";
    }
}
