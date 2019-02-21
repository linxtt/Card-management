package com.company.dao;

import com.company.message.Punch;

/*
 * 打卡实现	
 * */
public interface PunchDao {
	
	//上班打卡
	public boolean inTimePunch(Punch punch);
	//下班打卡
	public boolean offTimePunch(Punch punch);
	
}
