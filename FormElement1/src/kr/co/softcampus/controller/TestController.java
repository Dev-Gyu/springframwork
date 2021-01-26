package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String test1(@ModelAttribute DataBean bean) {
		bean.setA1("form:hidden test");
		bean.setA2("텍스트영역");
		return "test1";
	}
}
