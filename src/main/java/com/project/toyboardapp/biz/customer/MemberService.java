package com.project.toyboardapp.biz.customer;
/*
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;

    @Transactional
    public Long joinUser(MemberDTO memberDTO) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        memberDTO.setUserPass(passwordEncoder.encode(memberDTO.getUserPass()));

        return memberRepository.save(memberDTO.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<MemberEntity> userEntityWrapper = memberRepository.findById(userId);
        MemberEntity userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@gmail.com").equals(userId)) {
            authorities.add(new SimpleGrantedAuthority(Member_Level_Enum.ADMIN.getValue()));

        } else {
            authorities.add(new SimpleGrantedAuthority(Member_Level_Enum.USER.getValue()));
        }
        return new User(userEntity.getUserId(), userEntity.getUserPass(), authorities);
    }
}
*/