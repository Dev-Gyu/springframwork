package com.coderby.myapp.employees.repository;

import java.util.List;
import java.util.Map;

import com.coderby.myapp.employees.valueobject.EmpVO;

public interface IempRepository {
	int getEmpCount();
	int getEmpCount(int deptid);
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empid);
	void updateEmp(EmpVO emp);
	void insertEmp(EmpVO emp);
	void deleteJobHistory(int empid);
	void deleteEmp(int empid, String eamil);
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();

}
