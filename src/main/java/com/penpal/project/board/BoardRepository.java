package com.penpal.project.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Integer>{

	// by 장유란, 검색기능 추가
	Page<Board> findAll(Pageable pageable);
	Page<Board> findAll(Specification<Board> spec, Pageable pageable);
	
	// nonCategory
	// All/search
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where"
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%"
			)
	Page<Board> findAllByKeyword(@Param("kw") String kw, Pageable pageable);
	
	// All/search/select location+country 
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where("
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%) and "
			+ "	   q.location.name like %:location% and "
			+ "	   q.country.name like %:country% "
			)
	Page<Board> findAllByKeyword(
			@Param("kw") String kw, 
			Pageable pageable, 
			@Param("location") String location, 
			@Param("country") String country);
	
	// All/search/select country 
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where("
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%) and "
			+ "	   q.country.name like %:country% "
			)
	Page<Board> findAllByKeyword(
			@Param("kw") String kw, 
			Pageable pageable, 
			@Param("country") String country);
	
	// All/search/select location 
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where("
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%) and "
			+ "	   q.location.name like %:location%"
			)
	Page<Board> findAllByKeywordLocatuin(
			@Param("kw") String kw, 
			Pageable pageable, 
			@Param("location") String location);
	
	// inCategory
	// category only(측면 메뉴 클릭시 작동시킬 쿼리)
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where("
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%) and "
			+ "	   q.category.name like %:category%"
			)
	Page<Board> findAllByKeywordCategory(
			@Param("kw") String kw, 
			Pageable pageable, 
			@Param("category") String category);
	
	// {category}/search/select country 
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where("
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%) and "
			+ "	   q.country.name like %:country% and "
			+ "	   q.category.name like %:category%"
			)
	Page<Board> findAllByKeywordCategory(
			@Param("kw") String kw, 
			Pageable pageable, 
			@Param("country") String country, 
			@Param("category") String category);

	// {category}/search/select location 
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where("
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%) and "
				+ "	   q.location.name like %:location% and "
				+ "	   q.category.name like %:category%"
				)
		Page<Board> findAllByKeywordCategoryLocation(
				@Param("kw") String kw, 
				Pageable pageable, 
				@Param("location") String location, 
				@Param("category") String category);

		// {category}/search/select location 
	@Query(   "select distinct q "
			+ "from Board q "
			+ "    left outer join Member u1 "
			+ "	       on q.writer = u1 "
			+ "where("
			+ "	   q.title like %:kw% or "
			+ "	   q.content like %:kw%) and "
			+ "	   q.location.name like %:location% and "
			+ "	   q.country.name like %:country% and "
			+ "	   q.category.name like %:category%"
			)
			Page<Board> findAllByKeywordCategory(
				@Param("kw") String kw, 
				Pageable pageable, 
				@Param("country") String country, 
				@Param("location") String location, 
				@Param("category") String category);
}

