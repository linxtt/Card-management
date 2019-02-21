package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.company.dao.DateDao;
import com.company.db.CompanyDb;

public class DateDaoImpl implements DateDao {

	@Override
	public boolean selectWork() {
		Connection conn=CompanyDb.getConn();
		String sql="select t.work_date,t.employee_no,clock_in_time,clock_off_time, case when diff_in_time<-120 then '旷工' when diff_in_time<0 then '迟到' when diff_in_time>0 then '正常' else '忘记打卡' end as diff_in_status,case when diff_off_time>120 then '旷工' when diff_off_time>0 then '早退'when diff_off_time<0 then '正常' else '忘记打卡' end as diff_off_time from ( select work_date,employee_no,clock_in_time,clock_off_time,TIMESTAMPDIFF(MINUTE, clock_in_time, concat(clock_date,' 09:00:00')) as diff_in_time,TIMESTAMPDIFF(MINUTE, clock_off_time, concat(clock_date,' 18:00:00')) as diff_off_time from t_work_date w left join t_clock_info t on t.clock_date = w.work_date) t;";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("┌------------------------------------------------------------------------------------------------------------------------------┐");
		    System.out.println(" \t工作日期\t|\t员工编号\t|\t上班打卡时间\t\t\t|\t下班打卡时间\t\t\t|\t上班状态\t|\t下班状态 |");
		    while(rs.next()) {
		        Date workDate = rs.getDate(1);
		        String employeeNo = rs.getString(2);
		        Date clockInTime = rs.getTimestamp(3);
		        Date offTime = rs.getTimestamp(4);
		        String inStatus = rs.getString(5);
		        String offStatus = rs.getString(6);
		        System.out.println("  ------------------------------------------------------------------------------------------------------------------------------");

		        if (clockInTime == null && offTime==null) {
		            System.out.println("  "+workDate + "\t|\t" + employeeNo + "\t\t|\t" + clockInTime + "\t\t\t\t\t|\t" + offTime + "\t\t\t\t\t|\t" +inStatus + "\t|\t" + offStatus+" |");
		        }else if (clockInTime != null && offTime!=null) {
		            System.out.println("  "+workDate + "\t|\t" + employeeNo + "\t\t|\t" + clockInTime + "\t|\t" + offTime + "\t|\t" + inStatus + "\t\t|\t" + offStatus+"\t |");
		        }else{
		            System.out.println("  "+workDate + "\t|\t" + employeeNo + "\t\t|\t" + clockInTime + "\t|\t" + offTime + "\t|\t" + inStatus + "\t|\t" + offStatus+" |");
		        }

		    }
		    System.out.println("└------------------------------------------------------------------------------------------------------------------------------┘");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			CompanyDb.closeConn();
		}
		return false;
	}
	

}
