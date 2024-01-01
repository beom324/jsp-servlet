package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.DeptVO;

public class DeptDAO {

	String driver ="oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "c##madang";
	String password ="madang";
	
	
	
	public DeptVO findByDno(int dno) {
		String sql = "select * from dept where dno = ?";
		DeptVO vo = null;
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,userName,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int no = rs.getInt(1);
				String dname = rs.getString(2);
				String dloc = rs.getString(3);
				
				vo = new DeptVO(no, dname, dloc);
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return vo;
	}
	
	public ArrayList<DeptVO> deptList(){
		String sql ="select * from dept order by dno";
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,userName,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int dno = rs.getInt(1);
				String dName = rs.getString(2);
				String dLoc = rs.getString(3);
				
				list.add(new DeptVO(dno, dName, dLoc));
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
		
}
