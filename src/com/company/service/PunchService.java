package com.company.service;

import com.company.message.Punch;

public interface PunchService {
	//�ϰ��
		public boolean inTimePunch(Punch punch);
		//�°��
		public boolean offTimePunch(Punch punch);
}
