package com.coderby.myapp.employees.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.coderby.myapp.employees.service.IempService;
import com.coderby.myapp.employees.valueobject.EmpVO;

public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new GenericXmlApplicationContext("spring/employees-application-config.xml");
		IempService empService = context.getBean("empService", IempService.class);
		
		System.out.println("-- 사원의 수 조회");
		System.out.println(empService.getEmpCount());
		System.out.println(empService.getEmpCount(50));
		
		System.out.println("-- 103번 사원의 정보를 조회합니다.");
		System.out.println(empService.getEmpInfo(103));
		
		System.out.println("-- 사원 전체 정보를 조회합니다.");
		System.out.println(empService.getEmpList());
		
		System.out.println("-- 새로운 사원 정보를 입력합니다.");
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(210);
		emp.setFirstName("JinKyoung");
		emp.setLastName("Heo");
		emp.setEmail("HEOJK");
		emp.setPhoneNumber("222-222");
		emp.setJobId("IT_PROG");
		emp.setSalary(8000);
		emp.setCommissionPct(0.2);
		emp.setManagerId(100);
		emp.setDepartmentId(10);
		try {
			empService.insertEmp(emp);
			System.out.println("Insert ok");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("-- 신규 사원의 정보를 조회/출력합니다.");
		EmpVO emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);
		
		System.out.println("-- 210번 사원의 급여를 10% 인상 시킵니다.");
		emp210.setSalary(emp210.getSalary() * 1.1);
		System.out.println("인상된급여= " + emp210.getSalary());
		empService.updateEmp(emp210);
		
		System.out.println("-- 수정된 사원의 정보를 조회/출력합니다.");
		emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);
		
		System.out.println("-- 210번 사원의 정보를 삭제합니다.");
		empService.deleteEmp(210, "HEOJK");
		
		System.out.println("-- 모든 부서번호와 부서이름 정보를 출력합니다.");
		System.out.println(empService.getAllDeptId());
		
		System.out.println("-- 모든 직무 아이디와 직무 타이틀을 출력합니다.");
		System.out.println(empService.getAllJobId());
		
		System.out.println("-- 모든 매니저번호와 매니저이름을 출력합니다.");
		System.out.println(empService.getAllManagerId());
		
		

	}

}
