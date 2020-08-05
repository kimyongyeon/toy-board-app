package com.project.toyboardapp.biz.customer;

import com.project.toyboardapp.biz.post.PostDTO;
import com.project.toyboardapp.biz.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
@RequestMapping("user")
public class MemberController {

    private MemberService memberService;

    // 회원가입 페이지
    @GetMapping("/signup")
    public String dispSignup() {
        return "/signup";
    }

    /* 회원가입 처리
    @PostMapping("/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    } */

    // 로그인 페이지
    @GetMapping("/login")
    public String dispLogin() {
        return "/member/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/result")
    public String dispLoginResult() {
        return "/member/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    /* 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    } */

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/member/admin";
    }

    @GetMapping("/customer")
    public String list(Model model) throws UnsupportedEncodingException {
        model.addAttribute("name", "더 좋은 보드");
        String passwords[] = {"1234", "abcd", "12345678", "1111", "adfg"};
        List list = new ArrayList();
        for(int i=0; i<10; i++) {
            Map map = new HashMap<>();
            map.put("no", i);
            map.put("userId", "userId:"+i);
            map.put("userName", "userName:"+i);
            String target = "password"+i;
            if (i < 5) {
                target = passwords[i];
            }
            byte[] targetBytes = target.getBytes("UTF-8");
            // Base64 인코딩 ///////////////////////////////////////////////////
            Base64.Encoder encoder = Base64.getEncoder();
            // Encoder#encode(byte[] src) :: 바이트배열로 반환
            byte[] encodedBytes = encoder.encode(targetBytes);
            map.put("password", new String(encodedBytes));
            map.put("level", "level"+i);
            list.add(map);
        }
        model.addAttribute("list", list);
        return "CustomerView";
    }

    @GetMapping("/detail")
    public String detail() {
        return "CustomerDetail";
    }

}
