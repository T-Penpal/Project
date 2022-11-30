package com.mysite.report1;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/auth")
@Slf4j
public class LogoutController {

    @GetMapping("/logout")
    // HttpSession : 로그온등 서버쪽에 저장되는 클라이언트 상태정보 관리객체
    // 클라이언트 상태정보 : 로그온 또는 장바구니
    // HTTP 프로토콜은 connectionless 또는 stateless
    // 접속상태 또는 상태유지가 불가능한 통신프로토콜이다.
    // 그래서 서버와 클라이언트에 동시 정보를 유지하는 것이 불가능하다.
    // 이것을 극복하기 위해 나온 기술이 세션과 쿠키라는 기술이다.
    // 서버쪽 상태 정보와 클라이언트쪽 상태정보를 동일하게 유지하므로서
    // 서로 연결된 것으로 약속하는 기술이다.
    public String logout(HttpSession session) {
        
        log.info(">>> GET /auth/logout 요청");
        log.info(">>> 서버에 로그아웃 요청");
        log.info(">>> 그떄 같이 넘어오는 요청변수가 session정보입니다.");
        log.info("session 정보 :=" + session.toString());
        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        
        System.out.println("userInfo : " + userInfo);
        
        session.invalidate();
        return "redirect:/";
    }
}
