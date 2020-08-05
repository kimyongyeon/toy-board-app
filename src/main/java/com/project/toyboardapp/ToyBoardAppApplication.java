package com.project.toyboardapp;

import com.project.toyboardapp.biz.customer.MemberEntity;
import com.project.toyboardapp.biz.customer.MemberRepository;
import com.project.toyboardapp.biz.customer.Member_Level_Enum;
import com.project.toyboardapp.biz.post.PostEntity;
import com.project.toyboardapp.biz.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class ToyBoardAppApplication implements ApplicationRunner {

    @Autowired
    MemberRepository repository;

    @Autowired
    PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(ToyBoardAppApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello Toy Project");
//        defaultCustomers();
        defaultPost();
    }

    private void defaultPost() {
        PostEntity postEntity = new PostEntity();
        for (int i=0; i<10; i++) {
            postEntity = PostEntity.builder()
                    .postNo(Long.parseLong(i+""))
                    .postContents("content test " + i)
                    .postTitle("title test " + i)
                    .postWriter("writer test " + i).build();

            postRepository.save(postEntity);
        }

        // 폴리글랏 언어 프로그래밍 = 여러가지 언어사용해서 개발하는 패러다임
    }

    private void defaultCustomers() {
        System.out.println("customer data insert start");
        for(int i=0; i<10; i++) {
            MemberEntity memberEntity = new MemberEntity();
            memberEntity.setId(Long.parseLong(i+""));
            memberEntity.setUserId("userId" + i +"@gmail.com");
            memberEntity.setUserPass("userPass::" + i);
            memberEntity.setUserNm("userName::"+i);
            memberEntity.setUserLevel(Member_Level_Enum.getCustomer_Level_Enum()); // 랜덤으로 게스트, 사용자, 관리자
            repository.save(memberEntity);
        }

        System.out.println("customer data insert end");
    }
}
