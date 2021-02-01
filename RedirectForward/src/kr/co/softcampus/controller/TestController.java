package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String redirect() {
		// redirect: 붙여서 ViewResolver로 반환하면 해당 페이지로 리다이렉트됨
		// redirect: 다음에오는 url을 새로 요청하라는 의미가됨 -> Request객체 새로생성됨
		return "redirect:/sub1";
	}
	@GetMapping("/sub1")
	public String sub1() {
		return "sub1";
	}
	@GetMapping("/test2")
	public String test2() {
		// forward: 붙여서 ViewResolver로 반환하면 해당 페이지로 포워딩함
		// forward: 다음에 오는 url로 포워딩함 -> url변경없이 /sub2를 대응하는 컨트롤러 메소드(바로아래 메소드)호출
		return "forward:/sub2";	
	}
	@GetMapping("/sub2")
	public String sub2() {
		return "sub2";
	}
}
