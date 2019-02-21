package com.company.service.impl;

import com.company.dao.DaoFactory;
import com.company.dao.PunchDao;
import com.company.message.Punch;
import com.company.service.PunchService;

public class PunchServiceImpl implements PunchService {
	private PunchDao punchDao;
	public PunchServiceImpl() {
		punchDao=DaoFactory.getPunchDao();
	}
	@Override
	public boolean inTimePunch(Punch punch) {
		// TODO Auto-generated method stub
		return punchDao.inTimePunch(punch);
	}

	@Override
	public boolean offTimePunch(Punch punch) {
		// TODO Auto-generated method stub
		return punchDao.offTimePunch(punch);
	}

}
