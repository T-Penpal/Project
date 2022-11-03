package com.penpal.project.friend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.penpal.project.member.Member;
import com.penpal.project.member.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FriendController {
   private final MemberService memberService;
   private final FriendRepository friendRepository;
   
   @RequestMapping("/getFriend")
   @ResponseBody
   public  List<Friend> getFriend(@RequestParam HashMap<Object, Object> params){
		Member member = this.memberService.getMember(Integer.parseInt((String) params.get("memberId")));
		List<Friend> friendList = new ArrayList<>();
		friendList.addAll(member.getFriendList());
		
		return friendList;
	}
}