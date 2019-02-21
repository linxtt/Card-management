package com.company.service;

import com.company.message.Punch;

public interface PunchService {
	//上班打卡
		public boolean inTimePunch(Punch punch);
		//下班打卡
		public boolean offTimePunch(Punch punch);
}
