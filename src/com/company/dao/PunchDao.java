package com.company.dao;

import com.company.message.Punch;

/*
 * ��ʵ��	
 * */
public interface PunchDao {
	
	//�ϰ��
	public boolean inTimePunch(Punch punch);
	//�°��
	public boolean offTimePunch(Punch punch);
	
}
