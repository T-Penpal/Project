package green.spring.member_register;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 역활 : 웹브라우저에서 요청하면 요청한 HTML코드 만들어 보내주는 것
@Controller
public class MainController {
	
	// /register라는 uri(부분주소)로 요청하면 showForm()메소드로 처리하겠다.
	// @GetMapping("요청주소")
	// = @RequestMapping(value = "요청주소", method = RequestMethod.GET)
	// = @RequestMapping("요청주소")
	@RequestMapping("/register")
	public String showForm(Model model ) {
		// 데이터베이스에서 실제 데이터를 가져온다.
		// 지금은 가져왔다고 가정하고
		// 임의의 유저 한명 생성
		User user = new User();
		// 클라이언트에 보여질 화면내용을 담고 있는 html화면코드
		// tmeplate폴더에 있는 파일이름
		model.addAttribute("user", user);
		
		// 등록 화면에 출력할 직업 카테고리 내용생성
		List<String> listProfession
		 = Arrays.asList("Developer", "Tester", "Architect");
		model.addAttribute("listProfession", listProfession);
		
		return "register_form";
	}
	
	// post 방식으로 요청
	// RequestBody라는 영역에 데이터를 저장해서 
	// 서버로 데이터를 전송
	// 데이터가 get방식에 비해 안전하다.
	//@PostMapping = @RequestMapping의 RequestMethod.POST와 같은기능
	@RequestMapping(
		value = "/register", 
		method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("user") User user) {
		return "register_success";
	}
	
	
	// 시작페이지 메인페이지 index.html default.html start.html
	// 어떤 웹사이트의 제일 첫페이지
	@RequestMapping("/")
	public String index() {
		return ("index");
	}

}
