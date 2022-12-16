package com.mysite.report1;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/auth")
@Slf4j
public class LoginController {

    // 사용자 로그인 요청
    // 1. 로그인폼요청 => GET /로그인요청 주소(=URI)
    @GetMapping("/login")
    public String loginForm(LoginInput loginInput) {
        log.info(">>>GET /auth/login 요청");
        log.info(":) 회원정보 이메일 = " + loginInput.getEmail());
        log.info(":) 회원정보 비밀번호 = " + loginInput.getPassword());
        log.info(":) 회원정보 ip = " + loginInput.getIp());
        log.info(":) 회원정보 homepage = " + loginInput.getHomepage());
        return "auth/loginForm";
    }
    
    // 2. 로그인폼처리 : 로그인폼으로부터 온 폼정보를 활용 =>
    //    폼정보를 먼저 전송받아야 하므로 POST방식 /폼처리주소(=URI)
    @PostMapping("/login")
    public String login(LoginInput loginInput, 
            HttpSession session) {
        log.info(">>>POST /auth/login 요청");
        log.info(":) 회원정보 이메일 = " + loginInput.getEmail());
        log.info(":) 회원정보 비밀번호 = " + loginInput.getPassword());
        log.info(":) 회원정보 ip = " + loginInput.getIp());
        log.info(":) 회원정보 homepage = " + loginInput.getHomepage());
        
        UserInfo userInfo = new UserInfo
                (1, loginInput.getEmail(), 
                        "alex", 
                        loginInput.getIp(), 
                        loginInput.getHomepage());
        
        session.setAttribute("userInfo", userInfo);
        System.out.println("세션추가:" + userInfo);
        
        return "auth/loginSuccess";
    }
}