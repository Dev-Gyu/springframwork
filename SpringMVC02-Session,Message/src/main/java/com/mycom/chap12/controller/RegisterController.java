package com.mycom.chap12.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.chap12.spring.DuplicateMemberException;
import com.mycom.chap12.spring.MemberRegisterService;
import com.mycom.chap12.spring.RegisterRequest;

@Controller
public class RegisterController {
	private MemberRegisterService memberRegisterService;
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}

	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agreeVal,Model model) {
		if(!agreeVal) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	// 커맨드객체에 Validator인터페이스를 구현한 검사기능을 하는 클래스로 검사하려면 WebMvcConfigurer구현한 설정파일에 getValidator메소드설정하고
	// 커맨드객체 앞에 @Valid설정하면 된다. -> @Valid에 의해 handleStep3메소드 실행 전에 커맨드객체인 regReq를 검사해서 errors에 검사결과 입력함.
	
	// 하지만, 이 경우 RegisterRequestValidator의 support()메소드에서 정의한 RegisterRequest객체만 검사가능하므로, 글로벌 검사클래스로는 적합하지않음.
	
	// 또 다른 방법으로 javax validator api / hibernate-validator api를 이용하는 방법도있음 => 커맨드객체의 검사할 멤버변수에 애노테이션 달아서 검사하는것
	// 이 방법은 글로벌Validator로 적용되며 개발자가 직접 글로벌Validator를 적용한게 있으면 애노테이션으로 검사 안하고 직접지정한 검사클래스로 검사함
	
	// 컨트롤러별로 Validator설정하는법 = @InitBinder 사용
	@PostMapping("/register/step3")
	public String handleStep3(@Valid RegisterRequest regReq,Errors errors) {
		// new RegisterRequestValidator().validate(regReq, errors); @Valid가 대신해준다.
		if(errors.hasErrors()) {
			return "register/step2";
		}
		try {
			System.out.println(regReq.getName());
			System.out.println(regReq.getPassword());
			System.out.println(regReq.getEmail());
			System.out.println(regReq.getConfirmPassword());
			memberRegisterService.okay();
		memberRegisterService.regist(regReq);
		return "register/step3";
		}catch(DuplicateMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
}
