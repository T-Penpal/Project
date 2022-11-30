package com.mysite.report1;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

	@RequestMapping("/a")
	public String index(Model model) {

		return "index";
	}
	
	@RequestMapping("/kakao")
    public String map(Model model) {
	    // 4f85ad1c7928c6c94137ae247fe07b3a
        return "kakao_map";
    }

	@RequestMapping("/register")
	public String showForm(Model model ) {

		User user = new User();

		model.addAttribute("user", user);

		List<String> listProfession
		 = Arrays.asList("개발자", "학생", "무직");
		model.addAttribute("listProfession", listProfession);
		
		
		return "register";
	}

	@RequestMapping(value = "/register", 
			method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("user") User user) {
		
		return "register_success";
	}
}
