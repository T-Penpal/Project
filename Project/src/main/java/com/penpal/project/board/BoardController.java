package com.penpal.project.board;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.penpal.project.answer.AnswerForm;
import com.penpal.project.list.CategoryList;
import com.penpal.project.list.CategoryListRepository;
import com.penpal.project.list.CountryList;
import com.penpal.project.list.CountryListRepository;
import com.penpal.project.list.LocationList;
import com.penpal.project.list.LocationListRepository;
import com.penpal.project.member.Member;
import com.penpal.project.member.MemberService;

import lombok.RequiredArgsConstructor;

// 장유란 2022-10-24 Board기능
@RequestMapping("/board")
@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;
    private final MemberService memberService;
    private final CategoryListRepository categoryListRepository;
    private final LocationListRepository locationListRepository;
    private final CountryListRepository countryListRepository;

    
    @RequestMapping("/list")
    public String boardList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Board> paging = this.boardService.getList(page);
        model.addAttribute("paging", paging);

        return "board/board_list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model,
            @PathVariable("id") Integer id,
            AnswerForm answerForm) {
        Board board = this.boardService.getBoard(id);
        model.addAttribute("board", board);

        return "board/board_detail";
    }

    @PreAuthorize("isAuthenticated()") // 로그인 제약
    @GetMapping("/create")
    public String boardCreate(BoardForm boardForm) {
        return "board/board_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String boardCreate(@Valid BoardForm boardForm,
            BindingResult bindingResult,
            Principal principal) {

        if (bindingResult.hasErrors()) {
            return "board/board_form";
        }
        Member member = this.memberService.getMember(principal.getName());
        this.boardService.create(
                boardForm.getTitle(),
                boardForm.getContent(),
                boardForm.getCategory(),
                boardForm.getLocation(),
                boardForm.getCountry(),
                member);

        return "redirect:/board/list";
    }

    // 장유란 2022-10-24
    // CategoryList에 저장된 데이터를 List로 html에 보내주는 기능입니다
    @ModelAttribute("category")
    public List<CategoryList> categoryList() {
        List<CategoryList> categoryLists = categoryListRepository.findAll();
        System.out.println(categoryLists);

        return categoryLists;
    }

    @ModelAttribute("location")
    public List<LocationList> locationList() {
        List<LocationList> locationLists = locationListRepository.findAll();
        System.out.println(locationLists);

        return locationLists;

    }

    @ModelAttribute("country")
    public List<CountryList> countryList() {
        List<CountryList> countryLists = countryListRepository.findAll();
        System.out.println(countryLists);

        return countryLists;
    }

// h2 카테고리 추가(@ModelAttribute 주석처리 후 1회 사용)
//    @ModelAttribute("category")
//    public CategoryList categoryList2(){
//        CategoryList categoryList = new CategoryList();
//        categoryList.setName("FREE");
//        categoryListRepository.save(categoryList);
//        categoryList = new CategoryList();
//        categoryList.setName("GAME");
//        categoryListRepository.save(categoryList);
//        categoryList = new CategoryList();
//        categoryList.setName("TRAVEL");
//        categoryListRepository.save(categoryList);
//        
//        return categoryList;
//    }
//    
//    @ModelAttribute("location")
//    public LocationList locationList2(){
//        LocationList locationList = new LocationList();
//        locationList.setName("Asia");
//        locationListRepository.save(locationList);
//        locationList = new LocationList();
//        locationList.setName("America");
//        locationListRepository.save(locationList);
//        locationList = new LocationList();
//        locationList.setName("Europe");
//        locationListRepository.save(locationList);
//        
//        return locationList;
//    }
//    
//    @ModelAttribute("country")
//    public CountryList countryList2(){
//        CountryList countryList = new CountryList();
//        countryList.setName("Korea");
//        countryListRepository.save(countryList);
//        countryList = new CountryList();
//        countryList.setName("USA");
//        countryListRepository.save(countryList);
//        countryList = new CountryList();
//        countryList.setName("Japan");
//        countryListRepository.save(countryList);
//        countryList = new CountryList();
//        countryList.setName("China");
//        countryListRepository.save(countryList);
//        
//        return countryList;
//    }

}
