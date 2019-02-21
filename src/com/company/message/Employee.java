package com.company.message;
/*
 * Ա��ע��
 * 		1��Ա��id��employee_id
 * 		2��Ա����ţ�employee_no
 * 		3��Ա��������employee_name
 * 		4����½�˺ţ�login_name
 * 		5����½���룺password
 * 		6��������λ��job
 * 		7����ְʱ�䣺hiredate
 * 		8�����ʣ�salary
 * 		9����ɫ��role
 * */

import java.util.Date;

public class Employee{
	private String employee_id;
	private String employee_no;
	private String employee_name;
	private String login_name;
	private String password;
	private String job;
	private Date hiredate;
	private Double salary;
	private int role;
	
	public Employee() {
	}
	
	public Employee( String employee_no, String employee_name, String login_name, String password,
			String job, Date hiredate, Double salary, int role) {
		this.employee_no = employee_no;
		this.employee_name = employee_name;
		this.login_name = login_name;
		this.password = password;
		this.job = job;
		this.hiredate = hiredate;
		this.salary = salary;
		this.role = role;
	}
	
	public String getEmployee_id() {
		return employee_id;
	}
	public String getEmployee_no() {
		return employee_no;
	}
	public void setEmployee_no(String employee_no) {
		this.employee_no = employee_no;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "Ա����Ϣ [Ա��id��" + employee_id + ", Ա����ţ�" + employee_no + ", Ա��������"
				+ employee_name + ", ��½�˺ţ�" + login_name + ", ��½���룺" + password + ", ������λ��" + job
				+ ", ��ְʱ�䣺" + hiredate + ", ���ʣ�" + salary + ", ��ɫ��" + role + "]";
	}
	
}
