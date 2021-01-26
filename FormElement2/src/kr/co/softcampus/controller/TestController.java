package kr.co.softcampus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean;
import kr.co.softcampus.beans.KeyValueBean;

@Controller
public class TestController {
	@GetMapping("test1")
	public String test1(DataBean dataBean, Model model) {
		dataBean.setA1("data2");
		dataBean.setA2("data2");
		dataBean.setA3("data2");
		dataBean.setA4("data2");
		
		String[] check_list = {"data1","data3"};
		dataBean.setA5(check_list);
		dataBean.setA6(check_list);
		dataBean.setA7(check_list);
		dataBean.setA8(check_list);
		
		dataBean.setA9("data2");
		dataBean.setA10("data2");
		dataBean.setA11("data2");
		dataBean.setA12("data2");
		
		String [] data_list1 = {"data1", "data2", "data3"};
		model.addAttribute("data_list1", data_list1); // form:options 아이템용
		
		List<String> data_list2 = new ArrayList<>();
		data_list2.add("data1");
		data_list2.add("data2");
		data_list2.add("data3");
		model.addAttribute("data_list2", data_list2);
		
		KeyValueBean key_bean1 = new KeyValueBean(); // Select 태그의 값과 바디내용을 다르게 하기 위한 객체
		KeyValueBean key_bean2 = new KeyValueBean();
		KeyValueBean key_bean3 = new KeyValueBean();
		
		key_bean1.setKey("항목1");
		key_bean1.setValue("data1");
		
		key_bean2.setKey("항목2");
		key_bean2.setValue("data2");
		
		key_bean3.setKey("항목3");
		key_bean3.setValue("data3");
		
		List<KeyValueBean> data_list3 = new ArrayList<>();
		data_list3.add(key_bean1);
		data_list3.add(key_bean2);
		data_list3.add(key_bean3);
		model.addAttribute("data_list3", data_list3);
		return "test1";
	}
}
