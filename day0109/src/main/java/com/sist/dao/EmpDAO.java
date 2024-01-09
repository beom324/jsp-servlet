package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

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

	public ArrayList<String> listDno(){
		ArrayList<String> list = new ArrayList<String>();
		String sql ="select distinct dno from emp";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("부서 출력오류 : " + e.getMessage());
		}
		return list;
	}
	
	public ArrayList<EmpVO> findAll(String search, String option){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		String sql ="select eno,ename,job,hiredate,salary,dno,mgr,comm,rpad(substr(jumin,1,8),14,'*') as jumin,email from emp";
		if(search!=null && !search.equals(" ")) {			
			if(option.equals("job")) {
				sql+=" where job = '"+search+"'";
			}else {
				sql+=" where "+option+" like '%"+search+"%' ";
			}			
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
	
	public ArrayList<HashMap<String, Object>> empList(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql ="select e.eno,e.ename,d.dno,dname,e.salary,e.comm, e.hiredate,TRUNC(MONTHS_BETWEEN(SYSDATE, e.hiredate)),m.ename,rpad(substr(e.jumin,1,8),14,'*') as jumin,e.email,(E.SALARY+E.COMM) as total\r\n"
				+ " from emp e, emp m, dept d\r\n"
				+ " where m.eno=e.mgr \r\n"
				+ " and e.dno=d.dno\r\n";
				
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("eno", rs.getInt(1));
				map.put("ename", rs.getString(2));
				map.put("dno", rs.getString(3));
				map.put("dname", rs.getString(4));
				map.put("salary", rs.getInt(5));
				map.put("comm", rs.getInt(6));
				map.put("hiredate", rs.getDate(7));
				map.put("workday", rs.getString(8));
				map.put("mname", rs.getString(9));
				map.put("jumin", rs.getString(10));
				map.put("email", rs.getString(11));
				map.put("total", rs.getInt(12));
				list.add(map);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("사원목록 출력오류 : " + e.getMessage());
			
		}
		return list;
	}
	
}
