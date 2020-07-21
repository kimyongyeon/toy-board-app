package com.project.toyboardapp.biz.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    @GetMapping("/list")
    public String list() {
        return "/board/list";
    }
    @GetMapping("/write")
    public String write() {
        return "/board/write";
    }





}
