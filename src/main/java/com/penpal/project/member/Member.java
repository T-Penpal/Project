package com.penpal.project.member;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.penpal.project.chat.Room;
import com.penpal.project.friend.Friend;
import com.penpal.project.friend.FriendRequest;
import com.penpal.project.profile.Profile;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Member {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// by 장유란, user* -> member 변수명 변경 
	@Column(unique = true, length = 30)
	private String memberId;

	@Column
	private String memberPw;

	@Column(unique = true, length = 60)
	private String name;

	@Column(unique = true, length = 150)
	private String email;

	private LocalDateTime createDate;

	// by 장유란, author -> writer 변수명 변경 
	@ManyToOne
	private Member writer;

	// by 구양근, db에서 처리하지말고 세션을 통해서 구분하는게 좋을것 같습니다
	// private boolean conn;

	// by 구양근, 내가 만든 대화방 리스트
	@OneToMany(mappedBy = "maker", cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<Room> makerList;

	// by 구양근, 내가 초대된 대화방 리스트
	@OneToMany(mappedBy = "guest", cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<Room> guestList;

	// by 구양근, 프로필
	@OneToOne(mappedBy = "member")
	@JsonBackReference
	private Profile profile;
	
	// by 안준언, 친구 목록 리스트
	@OneToMany(mappedBy = "mine", cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<Friend> friendList;
	
	// by 안준언, 친구 요청 목록 리스트
	@OneToMany(mappedBy = "receive", cascade = CascadeType.REMOVE)
	@JsonBackReference
	private List<FriendRequest> friendRequestList;


}
