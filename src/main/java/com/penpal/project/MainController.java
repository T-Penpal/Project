package com.penpal.project;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.penpal.project.board.Board;
import com.penpal.project.profile.Profile;
import com.penpal.project.profile.ProfileRepository;
import com.penpal.project.profile.ProfileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {

	private final ProfileRepository profileRepository;
	private final ProfileService profileService;
	
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/users")
    public String users(Model model,
    		@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "kw", defaultValue = "") String kw,
			@RequestParam(value = "location", defaultValue = "") String location, 
			@RequestParam(value = "country", defaultValue = "") String country){
    	List<Profile> profilList = this.profileRepository.findAll();
    	
    	model.addAttribute("profilList", profilList);
    	Page<Profile> paging = this.profileService.getList(page, kw, location, country); // by 장유란 board_list에서 paging,
		model.addAttribute("paging", paging);
		model.addAttribute("kw", kw);	
		
		log.info("kw: " + kw + " page: " + page + " location: " + location + " country: " + country);
		
        return "member/users";
    }

    @RequestMapping("/users/profile")
    public String userProfile(){
        return "member/user_profile";
    }

}
