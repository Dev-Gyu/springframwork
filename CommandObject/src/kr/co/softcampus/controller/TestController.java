package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {
	@PostMapping("/test1")
	// @ModelAttribute를 선언하면 해당 객체를 HttpServletRequest에 주입해서
	// ViewResolver로 넘기겠다는 의미이다.
	//public String test1(@ModelAttribute DataBean dataBean) <- form에서 modelattribute를 따로 지정하지않으면 생략가능하다
	
	public String test1(DataBean dataBean) {
		// @ModelAttribute를 선언하면 해당 객체를 HttpServletRequest에 주입해서
		// ViewResolver로 넘기겠다는 의미이다.
		
		//System.out.printf("data1 : %s \n", dataBean.getData1());
		//System.out.printf("data2 : %s \n", dataBean.getData2());
		return "test1";
	}
	
	@PostMapping("/test2")
	// ModelAttribute("request에 저장될 이름")으로 커맨드 객체에 선언하면
	// 해당 이름으로 request에 저장되고, 이를 맵핑된 jsp에서 참조할때 애노테이션 선언할때 지정한 이름으로 참조가능하다.
	public String test2(@ModelAttribute("testData") DataBean dataBean) {
		return "test2";
	}
}
