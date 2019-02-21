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
	
	//��ҳ��
	public void mainMenu() throws ParseException {
		System.out.println("��ӭ��½Ա������ϵͳ��\n1����ͨԱ����½\n2������Ա��½");
		int input = in.nextInt();
		switch(input) {
			case 1:
				UserMenu();
				break;
			case 2:
				RootMenu();
				break;
			default:
				System.out.println("��Ч������");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mainMenu();
		}
	}
	//��ͨԱ����½ҳ��
	public void UserMenu() throws ParseException {
		System.out.println("�������˺ţ�");
		String user=in.next();
		System.out.println("����������");
		String userpassword=in.next();
		employee=new Employee();
		employee.setLogin_name(user);
		employee.setPassword(userpassword);
		boolean CheckSuccess=employeeService.UserCheck(employee);
		if(CheckSuccess) {
			System.out.println("��½�ɹ���");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserIndex();
		}else {
			System.out.println("��½ʧ��");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UserMenu() ;
		}
	}
	//����Ա��½ҳ��
	public void RootMenu() throws ParseException {
		System.out.println("�������˺ţ�");
		String root=in.next();
		System.out.println("����������");
		String rootpassword=in.next();
		Employee employee=new Employee();
		employee.setLogin_name(root);
		employee.setPassword(rootpassword);
		employeeService.RootCheck(employee);
		boolean CheckSuccess=employeeService.RootCheck(employee);
		if(CheckSuccess) {
			System.out.println("��½�ɹ���");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RootIndex();
		}else {
			System.out.println("��½ʧ��");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RootMenu();
		}
	}
	//��ͨԱ������ҳ��
	public void UserIndex() throws ParseException {
		System.out.println("1���ϰ��\n2���°��\n3���鿴������Ϣ\n4���˳�ϵͳ");
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
				System.out.println("��Ч������");
				UserIndex();
				break;
		}
	}
	//����Ա��������
	public void RootIndex() throws ParseException {
		System.out.println("1��ע��Ա����Ϣ\n2����ѯͳ��Ա��������Ϣ\n3���˳�ϵͳ");
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
				System.out.println("��Ч������");
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
	//�ϰ�򿨽���
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
	    	System.out.println("�򿨳ɹ���");
	    	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	UserIndex();
	    }
	    else {
	    	System.out.println("��ʧ��");
	    	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	UserIndex();
	    }
	}
	//�°�򿨽���
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
		    	System.out.println("�򿨳ɹ���");
		    	try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	UserIndex();
		    }
		    else {
		    	System.out.println("��ʧ��");
		    	try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	UserIndex();
		    }
	}
	//�鿴������Ϣ����
	public void selectWork() {
		new DateDaoImpl().selectWork();
		
	}
	//ע��Ա����Ϣ����
	public void addEmployee() throws ParseException {
		System.out.println("������Ա����ţ�");
		String employee_no=in.next();
		System.out.println("������Ա��������");
		String employee_name=in.next();
		System.out.println("�������½�˺ţ�");
		String login_name=in.next();
		System.out.println("�������½���룺");
		String password=in.next();
		System.out.println("�����빤����λ��");
		String job=in.next();
		System.out.println("��������ְʱ�䣺");
		String hiredate=in.next();
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Date employeeDate=df.parse(hiredate);
		System.out.println("�����빤�ʣ�");
		Double salary=in.nextDouble();
		System.out.println("�������ɫ(1����ͨԱ��/2������Ա)��");
		int role=in.nextInt();
		Employee employeeInfo=new Employee(employee_no, employee_name, login_name,  password,
				 job, employeeDate, salary, role);
		boolean isAddEmployee=employeeService.insertEmployee(employeeInfo);
		if(isAddEmployee)
		{
			System.out.println("ע��ɹ�");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RootIndex();
		}else
			System.out.println("ע��ʧ��");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			addEmployee();
	}

}
