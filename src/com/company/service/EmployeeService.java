package com.company.service;

import com.company.message.Employee;

public interface EmployeeService {
	//注册员工信息
	public boolean insertEmployee(Employee employee);
	//管理员身份验证
	public boolean RootCheck(Employee employee);
	//普通用户身份验证
	public boolean UserCheck(Employee employee);
}
