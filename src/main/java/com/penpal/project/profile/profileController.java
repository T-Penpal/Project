package com.penpal.project.profile;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/users")
@RequiredArgsConstructor
@Controller
@Slf4j
public class profileController {

	private final ProfileService profileService;
	
    @RequestMapping("")
    public String users(Model model,
    		@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "kw", defaultValue = "") String kw,
			@RequestParam(value = "location", defaultValue = "") String location, 
			@RequestParam(value = "country", defaultValue = "") String country){
    	
        Page<Profile> paging = this.profileService.getList(page, kw, location, country);
		model.addAttribute("kw", kw);
        model.addAttribute("paging", paging);

        log.info("userSearch = kw: " + kw + " page: " + page + " location: " + location + " country: " + country);
		
		return "profile/users";
    }

    @GetMapping("/profile/create/{id}")
    public String profileCreate(Model model, @PathVariable("id") Integer id) {
    	return "profile/user_profile_form";
    }
    
    // 프로필 생성 일부 반영
    @PostMapping("/profile/create/{id}")
    public String profileCreate(
    		@Valid ProfileForm profileForm, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()){
    		return "profile/user_profile_form";
    	}
    	this.profileService.create(
    			profileForm.getNickname(), profileForm.getGender(), 
    			profileForm.getAge(), profileForm.getComment());
    	return "redirect:/users";
    }
    
    // 프로필 상세 보기
    @RequestMapping(value = "/profile/{id}")
    public String userProfile(Model model, @PathVariable("id") Integer id){
    	Profile profile = this.profileService.getProfile(id);
        model.addAttribute("profile", profile);
        return "profile/user_profile";	//user_profile폼으로 이동
    }
//    
//    @RequestMapping("/profile/modify/{id}")
//    public String userProfileForm(){
//        return "profile/user_profile_form";
//    } // by 조성빈, 템플릿 제작용 임시 mapping
}
