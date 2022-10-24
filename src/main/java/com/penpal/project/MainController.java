package com.penpal.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    

    @RequestMapping("/") // 메인 페이지(Home)
    public String index(Model model){
        model.addAttribute("index", "index");
        return "index";
    }


    // 사용자 정보 관련 페이지 시작 //

    @RequestMapping("/login") // 로그인 페이지
    public String login(Model model){
        model.addAttribute("login", "login");
        return "login";
    }
    
    @RequestMapping("/sign_up") // 회원가입 페이지
    public String signup(Model model){
        model.addAttribute("sign_up", "sign_up");
        return "signup";
    }

    // 사용자 정보 관련 페이지 끝 // 


    // 프로필 및 친구 관련 페이지 시작 //

    @RequestMapping("/users") // 친구 찾기 페이지(Users)
    public String users(Model model){
        model.addAttribute("users", "users");
        return "users";
    }

    // 프로필 및 친구 관련 페이지 끝 //


    // 커뮤니티 관련 페이지 시작 //

    @RequestMapping("/community") // 커뮤니티 페이지(Community)
    public String community(Model model){
        model.addAttribute("community", "community");
        return "community";
    }

    // 커뮤니티 관련 페이지 끝 //
}
