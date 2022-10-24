package com.penpal.project.member;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.penpal.project.board.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
   
    
    public Member create(String userId, String userPw, String name, String email) {
        Member user = new Member();
        user.setUserId(userId);
        user.setUserPw(passwordEncoder.encode(userPw));
        user.setName(name);
        user.setEmail(email);
        user.setCreateDate(LocalDateTime.now());
        this.memberRepository.save(user);
        
        return user;
    }
    
    public Member getMember(String userId) {
        Optional<Member> member = this.memberRepository.findByUserId(userId);
        if(member.isPresent()) {
            return member.get();
        } else {
            throw new DataNotFoundException("sitemember not found");
        }
    }
    
}
