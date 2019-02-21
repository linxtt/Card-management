package com.company.service.impl;

import com.company.dao.DaoFactory;
import com.company.dao.EmployeeDao;
import com.company.message.Employee;
import com.company.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;
	public EmployeeServiceImpl() {
		employeeDao=DaoFactory.getEmployeeDao();
	}
	@Override
	public boolean insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.insertEmployee(employee);
	}
	@Override
	public boolean RootCheck(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.RootCheck(employee);
	}
	@Override
	public boolean UserCheck(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.UserCheck(employee);
	}

}
