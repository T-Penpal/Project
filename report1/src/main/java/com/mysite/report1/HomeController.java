package com.mysite.report1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
      //log.info("세션 유저상태정보 : " + session.userInfo);   
        
        return "home";
    }
    
}
