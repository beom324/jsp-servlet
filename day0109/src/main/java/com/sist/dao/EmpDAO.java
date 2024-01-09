package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.EmpVO;

public class EmpDAO {
	public static EmpDAO dao=null;
	private EmpDAO(){
		
	}
	
	public static EmpDAO getInstance() {		
		if(dao==null) {
			dao = new EmpDAO();
		}
			return dao;		
	}
	
	public ArrayList<String> listJob(){
		ArrayList<String> list = new ArrayList<String>();
		String sql ="select distinct job from emp";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("직책 출력오류 : " + e.getMessage());
		}
		return list;
	}
	
	public ArrayList<EmpVO> findAll(String search, String option){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		String sql ="select eno,ename,job,hiredate,salary,dno,mgr,comm,rpad(substr(jumin,1,8),14,'*') as jumin,email from emp";
		if(search!=null && !search.equals(" ")) {
			sql+=" where "+option+" like '%"+search+"%' ";
		}
		System.out.println(sql);
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO e = new EmpVO();
				e.setEno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setHiredate(rs.getDate(4));
				e.setSalary(rs.getInt(5));
				e.setDno(rs.getInt(6));
				e.setMgr(rs.getInt(7));
				e.setComm(rs.getInt(8));
				e.setJumin(rs.getString(9));
				e.setEmail(rs.getString(10));
				list.add(e);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("사원목록출력오류 : " + e.getMessage());
		}
		return list;
	}
	
}
