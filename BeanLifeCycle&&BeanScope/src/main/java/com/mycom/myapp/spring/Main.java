package com.mycom.myapp.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mycom.myapp.assembler.AppCtx;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 컨테이너 초기화, 소멸시키려면 AbstractApplicationContext 타입으로 선언해야됨.(ApplicationContext는 close메소드없음)
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppCtx.class);
		Client client = (Client)context.getBean("client");
		client.send();
		context.close();
	}

}
