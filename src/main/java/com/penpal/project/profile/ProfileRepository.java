package com.penpal.project.profile;

import org.springframework.data.jpa.repository.JpaRepository;

import com.penpal.project.member.Member;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	Profile getByMember(Member member);

	
}
