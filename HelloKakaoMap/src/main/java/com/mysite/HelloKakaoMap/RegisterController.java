package com.mysite.HelloKakaoMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

	/*
	 * @RequestMapping("/") public String index(Model model) {
	 * 
	 * return "index"; }
	 */
	@GetMapping("/kakaoMap")
    public String map(Model model) {
	    // 4f85ad1c7928c6c94137ae247fe07b3a
        return "kakaoMap4";
    }


}
