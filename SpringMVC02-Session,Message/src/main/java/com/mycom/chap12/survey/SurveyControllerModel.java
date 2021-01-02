package com.mycom.chap12.survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyControllerModel {
	
	// Controller에서 ModelAndView객체의 속성을 세터메소드를이용해 직접 설정해주고 객체자체를 반환시키는방법
	// 컨트롤러에서 Model객체에만 속성지정하고 String값 반환하면 HandlerAdapter가 String값을 setViewName으로 자동지정해줌
	@GetMapping
	public ModelAndView form() {
		List<Question> questions = createQuestions();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions);
		mav.setViewName("survey/surveyForm");
		return mav;
	}
	private List<Question> createQuestions(){
		Question q1 = new Question("당신의 역할은 무엇입니까?", Arrays.asList("서버","프론트","풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", Arrays.asList("이클립스","인텔리J","서브라임"));
		Question q3 = new Question("하고싶은말을 적어주세요");
		return Arrays.asList(q1,q2,q3);
	}
	@PostMapping
	public String submit(@ModelAttribute("ansData") AnsweredData answeredData) {
		return "survey/submitted";
	}
}
