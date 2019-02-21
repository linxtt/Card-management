package com.company.service.impl;

import com.company.dao.DaoFactory;
import com.company.dao.DateDao;
import com.company.service.DateService;

public class DateServiceImpl implements DateService {
	private DateDao dateDao;
	public DateServiceImpl() {
		dateDao=DaoFactory.getDateDao();
	}
	@Override
	public boolean selectWork() {
		return dateDao.selectWork();
	}

}
