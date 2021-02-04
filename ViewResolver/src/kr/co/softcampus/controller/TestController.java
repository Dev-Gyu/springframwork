package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	
	// ModelAndView객체에 담길 파라미터들을 정의하는방법은 아래 세가지 방법 중 어떤걸 써도 가능하나
	// 개인적으론 2번을 좀 자주 씀.
	@GetMapping(value="/test2")
	public String test2(HttpServletRequest request) {
		// request객체에 담긴 모든 파라미터들은 ModelAndView의 Model객체에 세팅되어 ViewResolver로 전달됨
		request.setAttribute("data1", 100);
		request.setAttribute("data2", 200);
		return "test2";
	}
	
	@GetMapping(value="/test3")
	public String test3(Model model) {
		// Model객체에 추가된 파라미터들은 HttpServletRequest객체에 추가되어 해당 jsp파일에서 접근가능함
		// (requestScope.파라미터명 <- requestScope는 생략가능)
		model.addAttribute("data1",100);
		model.addAttribute("data2",200);
		return "test3";
	}
	
	@GetMapping("/test4")
	public ModelAndView test4(ModelAndView mv) {
		mv.addObject("data1", 500);
		mv.addObject("data2", 200);
		mv.setViewName("test4");
		return mv;
	}
}
