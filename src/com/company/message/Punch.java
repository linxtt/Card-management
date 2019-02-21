package com.company.message;

import java.util.Date;

/*
 * 打卡信息
 * 		员工id：employee_id
 * 		员工编号：employee_no
 * 		上班时间：inTime
 * 		下班时间：offTime
 * 		上班日期：date
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
		return "打卡信息 [员工Id=" + employee_id + ", 员工编号=" + employee_no + ", 上班打卡=" + inTime
				+ ", 下班打卡=" + offTime + ", 打卡日期=" + date + "]";
	}




}
