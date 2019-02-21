package com.company.message;

import java.util.Date;

/*
 * ����Ϣ
 * 		Ա��id��employee_id
 * 		Ա����ţ�employee_no
 * 		�ϰ�ʱ�䣺inTime
 * 		�°�ʱ�䣺offTime
 * 		�ϰ����ڣ�date
 * */
public class Punch {
	private int employee_id;
	private String employee_no;
	private Date inTime; 
	private Date offTime;
	private Date date;
	
	public Punch() {
		
	}
	
	public Punch(String employee_no, Date inTime, Date offTime, Date date) {
		this.employee_no = employee_no;
		this.inTime = inTime;
		this.offTime = offTime;
		this.date = date;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public String getEmployee_no() {
		return employee_no;
	}

	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOffTime() {
		return offTime;
	}

	public void setOffTime(Date offTime) {
		this.offTime = offTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "����Ϣ [Ա��Id=" + employee_id + ", Ա�����=" + employee_no + ", �ϰ��=" + inTime
				+ ", �°��=" + offTime + ", ������=" + date + "]";
	}




}
