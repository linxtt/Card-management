package com.company.service;

import com.company.message.Employee;

public interface EmployeeService {
	//ע��Ա����Ϣ
	public boolean insertEmployee(Employee employee);
	//����Ա�����֤
	public boolean RootCheck(Employee employee);
	//��ͨ�û������֤
	public boolean UserCheck(Employee employee);
}
