package com.penpal.project.profile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.penpal.project.member.Member;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	// boardSearch 복사본, sns 등 추가수정 필요
	@Query(   "select distinct p "
			+ "from Profile p  "
			+ "where "
			+ "	   p.member.name like %:kw% and "
			+ "	   p.location.name like %:location% and "
			+ "	   p.country.name like %:country%"
			)
			Page<Profile> findAllByKeywordCategory(
				@Param("kw") String kw, 
				Pageable pageable, 
				@Param("country") String country, 
				@Param("location") String location);


	
}
