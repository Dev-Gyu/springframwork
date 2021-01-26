package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.softcampus.beans.UserDataBean;

@Controller
public class TestController {
	// 일반 html form태그 사용하는 페이지
	@GetMapping("/test1")
	public String test1(UserDataBean udb) {
		udb.setUser_name("홍길동");
		udb.setUser_id("abcd");
		udb.setUser_pw("1234");
		udb.setUser_postcode("12345");
		udb.setUser_address1("주소1번입니다.");
		udb.setUser_address2("주소2번입니다.");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(UserDataBean udb) {
		udb.setUser_name("홍길동");
		udb.setUser_id("abcd");
		udb.setUser_pw("1234");
		udb.setUser_postcode("12345");
		udb.setUser_address1("주소1번입니다.");
		udb.setUser_address2("주소2번입니다.");		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("testBean")UserDataBean udb) {
		udb.setUser_name("홍길동");
		udb.setUser_id("abcd");
		udb.setUser_pw("1234");
		udb.setUser_postcode("12345");
		udb.setUser_address1("주소1번입니다.");
		udb.setUser_address2("주소2번입니다.");		
		return "test3";
	}
	
	// 직접 커맨드 객체 생성해서 모델객체에 넣어서 사용하는 방법
	@GetMapping("/test4")
	public String test4(Model model) {
		UserDataBean udb = new UserDataBean();
		udb.setUser_name("홍길동");
		udb.setUser_id("abcd");
		udb.setUser_pw("1234");
		udb.setUser_postcode("12345");
		udb.setUser_address1("주소1번입니다.");
		udb.setUser_address2("주소2번입니다.");	
		
		model.addAttribute("test_user2", udb);
		return "test4";
	}
}