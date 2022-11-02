package com.penpal.project;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.penpal.project.member.Member;
import com.penpal.project.member.MemberRepository;
import com.penpal.project.profile.Profile;
import com.penpal.project.profile.ProfileRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {

	private final MemberRepository memberRepository;
	private final ProfileRepository profileRepository;
	
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/users")
    public String users(Model model){
    	List<Profile> profilList = this.profileRepository.findAll();
    	
    	model.addAttribute("profilList", profilList);
    	
        return "member/users";
    }

    @RequestMapping("/users/profile")
    public String userProfile(){
        return "member/user_profile";
    }

}
