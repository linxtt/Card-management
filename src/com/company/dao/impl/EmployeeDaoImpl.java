package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.company.dao.EmployeeDao;
import com.company.db.CompanyDb;
import com.company.message.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	//注册员工信息
	@Override
	public boolean insertEmployee(Employee employee) {
		Connection conn=CompanyDb.getConn();
		String sql="insert into t_employee values(null,?,?,?,?,?,?,?,?)";
		try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, employee.getEmployee_no());
				ps.setString(2, employee.getEmployee_name());
				ps.setString(3, employee.getLogin_name());
				ps.setString(4, employee.getPassword());
				ps.setString(5,employee.getJob());
				ps.setDate(6, new java.sql.Date(employee.getHiredate().getTime()));
				ps.setDouble(7, employee.getSalary());
				ps.setInt(8, employee.getRole());
				if(ps.executeUpdate()>0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				CompanyDb.closeConn();
			}
		return false;
	}
	//管理员身份验证
	@Override
	public boolean RootCheck(Employee employee) {
		Connection conn=CompanyDb.getConn();
		String sql="select * from t_employee where login_name=? and pass_word=? and role =2";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, employee.getLogin_name());
			ps.setString(2, employee.getPassword());
			ResultSet rs = ps.executeQuery() ;
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CompanyDb.closeConn();
		}
		return false;
	}
	//普通用户身份验证
	@Override
	public boolean UserCheck(Employee employee) {
		Connection conn=CompanyDb.getConn();
		String sql="select * from t_employee where login_name=? and pass_word=? and role =1";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, employee.getLogin_name());
			ps.setString(2, employee.getPassword());
			ResultSet rs = ps.executeQuery() ;
			if (rs.next()) {
				employee.setEmployee_no(rs.getString("employee_no"));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			CompanyDb.closeConn();
		}
		return false;
	}
	

}
