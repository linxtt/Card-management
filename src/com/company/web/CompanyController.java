package com.company.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.company.dao.impl.DateDaoImpl;
import com.company.message.Employee;
import com.company.message.Punch;
import com.company.service.EmployeeService;
import com.company.service.PunchService;
import com.company.service.impl.EmployeeServiceImpl;
import com.company.service.impl.PunchServiceImpl;

public class CompanyController {
	private static Scanner in=new Scanner(System.in);
	private EmployeeService employeeService ;
	private PunchService punchService;
	private Employee employee;
	public CompanyController() {
		employeeService=new EmployeeServiceImpl();
		punchService=new PunchServiceImpl();
	}
	
	//主页面
	public void mainMenu() throws ParseException {
		System.out.println("欢迎登陆员工考勤系统！\n1、普通员工登陆\n2、管理员登陆");
		int input = in.nextInt();
		switch(input) {
			case 1:
				UserMenu();
				break;
			case 2:
				RootMenu();
				break;
			default:
				System.out.println("无效操作！");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mainMenu();
		}
	}
	//普通员工登陆页面
	public void UserMenu() throws ParseException {
		System.out.println("请输入账号：");
		String user=in.next();
		System.out.println("请输入密码");
		String userpassword=in.next();
		employee=new Employee();
		employee.setLogin_name(user);
		employee.setPassword(userpassword);
		boolean CheckSuccess=employeeService.UserCheck(employee);
		if(CheckSuccess) {
			System.out.println("登陆成功！");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserIndex();
		}else {
			System.out.println("登陆失败");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserMenu() ;
		}
	}
	//管理员登陆页面
	public void RootMenu() throws ParseException {
		System.out.println("请输入账号：");
		String root=in.next();
		System.out.println("请输入密码");
		String rootpassword=in.next();
		Employee employee=new Employee();
		employee.setLogin_name(root);
		employee.setPassword(rootpassword);
		employeeService.RootCheck(employee);
		boolean CheckSuccess=employeeService.RootCheck(employee);
		if(CheckSuccess) {
			System.out.println("登陆成功！");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RootIndex();
		}else {
			System.out.println("登陆失败");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RootMenu();
		}
	}
	//普通员工交互页面
	public void UserIndex() throws ParseException {
		System.out.println("1、上班打卡\n2、下班打卡\n3、查看考勤信息\n4、退出系统");
		int input=in.nextInt();
		switch(input) {
			case 1:
				InTimeMenu();
				break;
			case 2:
				OffTimeMenu();
				break;
			case 3:
				selectWork();
				UserIndex();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("无效操作！");
				UserIndex();
				break;
		}
	}
	//管理员交互界面
	public void RootIndex() throws ParseException {
		System.out.println("1、注册员工信息\n2、查询统计员工考勤信息\n3、退出系统");
		int input=in.nextInt();
		switch(input) {
			case 1:
				addEmployee(); 
				break;
			case 2:
				selectWork();
				RootIndex();
				break;
			case 3:
				System.exit(1);
				break;
			default:
				System.out.println("无效操作！");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RootMenu();
				break;
		}
	}
	//上班打卡界面
	public void  InTimeMenu() throws ParseException {
		String employee_no=employee.getEmployee_no();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
		String dateTime1 = sdf1.format(new Date());
		Date inTime=sdf1.parse(dateTime1);
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		String dateTime2 = sdf2.format(new Date());
		Date date=sdf2.parse(dateTime2);
	    Punch punchInfo=new Punch(employee_no, inTime, null, date);
	    boolean InTimeTest=punchService.inTimePunch(punchInfo);
	    if(InTimeTest) {
	    	System.out.println("打卡成功！");
	    	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	UserIndex();
	    }
	    else {
	    	System.out.println("打卡失败");
	    	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	UserIndex();
	    }
	}
	//下班打卡界面
	public void OffTimeMenu() throws ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
		String dateTime1 = sdf1.format(new Date());
		Date offTime=sdf1.parse(dateTime1);
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
		String dateTime2 = sdf2.format(new Date());
		Date date=sdf2.parse(dateTime2);
		Punch punchInfo=new Punch(null,null,offTime,date);
		boolean OffTimeTest=punchService.offTimePunch(punchInfo);
		 if(OffTimeTest) {
		    	System.out.println("打卡成功！");
		    	try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	UserIndex();
		    }
		    else {
		    	System.out.println("打卡失败");
		    	try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	UserIndex();
		    }
	}
	//查看考勤信息界面
	public void selectWork() {
		new DateDaoImpl().selectWork();
		
	}
	//注册员工信息界面
	public void addEmployee() throws ParseException {
		System.out.println("请输入员工编号：");
		String employee_no=in.next();
		System.out.println("请输入员工姓名：");
		String employee_name=in.next();
		System.out.println("请输入登陆账号：");
		String login_name=in.next();
		System.out.println("请输入登陆密码：");
		String password=in.next();
		System.out.println("请输入工作岗位：");
		String job=in.next();
		System.out.println("请输入入职时间：");
		String hiredate=in.next();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date employeeDate=df.parse(hiredate);
		System.out.println("请输入工资：");
		Double salary=in.nextDouble();
		System.out.println("请输入角色(1、普通员工/2、管理员)：");
		int role=in.nextInt();
		Employee employeeInfo=new Employee(employee_no, employee_name, login_name,  password,
				 job, employeeDate, salary, role);
		boolean isAddEmployee=employeeService.insertEmployee(employeeInfo);
		if(isAddEmployee)
		{
			System.out.println("注册成功");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RootIndex();
		}else
			System.out.println("注册失败");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addEmployee();
	}

}
