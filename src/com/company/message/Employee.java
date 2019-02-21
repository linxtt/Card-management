package com.company.message;
/*
 * 员工注册
 * 		1、员工id：employee_id
 * 		2、员工编号：employee_no
 * 		3、员工姓名：employee_name
 * 		4、登陆账号：login_name
 * 		5、登陆密码：password
 * 		6、工作岗位：job
 * 		7、入职时间：hiredate
 * 		8、工资：salary
 * 		9、角色：role
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
		return "员工信息 [员工id：" + employee_id + ", 员工编号：" + employee_no + ", 员工姓名："
				+ employee_name + ", 登陆账号：" + login_name + ", 登陆密码：" + password + ", 工作岗位：" + job
				+ ", 入职时间：" + hiredate + ", 工资：" + salary + ", 角色：" + role + "]";
	}
	
}
