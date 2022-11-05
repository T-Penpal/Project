package com.penpal.project.profile;

import javax.validation.constraints.NotEmpty;

import com.penpal.project.list.CountryList;
import com.penpal.project.list.LocationList;
import com.penpal.project.member.Member;
import com.penpal.project.member.list.MemberFavorite;
import com.penpal.project.member.list.MemberLanguage;
import com.penpal.project.member.list.MemberSns;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class ProfileForm {
	
	private Integer id;
	
	@NotEmpty(message="닉네임을 적어주세요")
	private String nickname;
	
	//@NotEmpty(message="성별을 정해주세요")
	private String gender;
	
	//@NotEmpty(message="나이를 입력해주세요")	//숫자로 변경
	private Integer age;
	
	//@NotEmpty(message="사는 지역을 입력해주세요")
//	private String location;
//	
//	//@NotEmpty(message="나라를 입력해주세요")
//	private String country;
//	
//	
//	//@NotEmpty(message="사용하는 sns를 입력해주세요")
//	private String sns;
//	
//	//@NotEmpty(message="취미를 입력해주세요")
//	private String favorite;
//	
//	//@NotEmpty(message="사용하는 언어를 입력해주세요")
//	private String language;
	
	private String comment;
	
//	private Member member;
//
//	private String img;
}
