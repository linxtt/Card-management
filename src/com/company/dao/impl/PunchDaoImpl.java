package com.company.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.company.dao.PunchDao;
import com.company.db.CompanyDb;
import com.company.message.Punch;

public class PunchDaoImpl implements PunchDao {
	//上班打卡
	@Override
	public boolean inTimePunch(Punch punch) {
		Connection conn=CompanyDb.getConn();
		String sql="insert into t_clock_info values(null,?,?,null,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, punch.getEmployee_no());
			ps.setTimestamp(2, new Timestamp((new java.util.Date()).getTime()));
			ps.setDate(3, new java.sql.Date(punch.getDate().getTime()));
			if(ps.executeUpdate()>0) {
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
	//下班打卡
	@Override
	public boolean offTimePunch(Punch punch) {
		Connection conn=CompanyDb.getConn();
		String sql="update t_clock_info set clock_off_time=? where clock_date = ?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setTimestamp(1, new Timestamp((new java.util.Date()).getTime()));
			ps.setDate(2, new java.sql.Date(punch.getDate().getTime()));
			if(ps.executeUpdate()>0) {
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
