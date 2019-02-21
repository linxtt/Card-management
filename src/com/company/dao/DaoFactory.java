package com.company.dao;

import com.company.dao.impl.DateDaoImpl;
import com.company.dao.impl.EmployeeDaoImpl;
import com.company.dao.impl.PunchDaoImpl;

public class DaoFactory {
	public static EmployeeDao getEmployeeDao() {
		return new EmployeeDaoImpl();
	}
	public static PunchDao getPunchDao() {
		return new PunchDaoImpl();
	}
	public static DateDao getDateDao() {
		return new DateDaoImpl();
	}
}
