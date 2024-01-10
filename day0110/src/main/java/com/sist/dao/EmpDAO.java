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
	
//	public ArrayList<HashMap<String, Object>> searchByEname(String name){
//		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
//		String sql ="select e.eno,e.ename,e.dno,e.dname,e.salary,e.comm,e.hiredate,trunc(Months_between(sysdate, e.hiredate),m.ename),rpad(substr(e.jumin,1,8),14,'*') as jumin,e.email,(E.SALARY+E.COMM) as total from emp e,emp m,dept d where e.mgr=m.eno and e.dno=d.dno and e.ename=?";
//		try {
//			Connection conn = ConnectionProvider.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			ResultSet rs = pstmt.executeQuery();
//			while(rs.next()) {
//				HashMap<String, Object> map = new HashMap<String, Object>();
//				map.put("eno", rs.getInt(1));
//				map.put("ename", rs.getString(2));
//				map.put("dno", rs.getString(3));
//				map.put("dname", rs.getString(4));
//				map.put("salary", rs.getInt(5));
//				map.put("comm", rs.getInt(6));
//				map.put("hiredate", rs.getDate(7));
//				map.put("workday", rs.getString(8));
//				map.put("mname", rs.getString(9));
//				map.put("jumin", rs.getString(10));
//				map.put("email", rs.getString(11));
//				map.put("total", rs.getInt(12));
//				list.add(map);
//			}
//		}catch(Exception e) {
//			System.out.println("검색된 사원목록 출력오류 : " + e.getMessage());
//		}
//		return list;
//		
//		
//	}
//	
	
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
	
	public ArrayList<String> deptNameList(){
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select dname from dept";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
					
		}catch(Exception e) {
			System.out.println("부서명 리스트 출력 오류 : " + e.getMessage());
		}
		return list;
	}
	public ArrayList<String> mnameList(){
		String sql = "select distinct mname from (select e.eno, e.ename, e.dno, dname, e.salary, e.comm, e.salary +  e.comm, e.hiredate, trunc(months_between(sysdate, e.hiredate)), m.ename as mname, rpad( substr(e.jumin,1,8),14,'*'), e.email, e.job from emp e, emp m, dept d where e.mgr = m.eno and d.dno = e.dno )";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> empList(String keyword, String option){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT e.eno, "
	               + "e.ename, "
	               + "e.dno,"
	               + " d.dname,"
	               + " e.salary,"
	               + " (e.salary/10) sudang,"
	               + " (e.salary+(e.salary/10)) realmoney,"
	               + " to_char( e.hiredate,'YYYY-MM-DD'),"
	               + " TRUNC(MONTHS_BETWEEN(SYSDATE, e.hiredate)), "
	               + "m.ename, "
	               + "rpad(substr(e.jumin,1,8),14,'*') jumin, "
	               + "e.email, "
	               + "e.job "
	               + "from EMP e LEFT outer JOIN emp m on e.mgr=m.eno, DEPT d WHERE e.dno=d.dno";		
		if(keyword != null && !keyword.equals("")) {
			sql += " and "+option+" like  '%"+keyword+"%'";
		}
		
		sql += " order by e.eno";
		System.out.println(sql);
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("eno", rs.getInt(1));
				map.put("ename", rs.getString(2));
				map.put("dno", rs.getInt(3));
				map.put("dname", rs.getString(4));
				map.put("salary", rs.getInt(5));
				map.put("comm", rs.getInt(6));
				map.put("total", rs.getInt(7));
				map.put("hiredate", rs.getString(8));
				map.put("workday", rs.getInt(9));
				map.put("mname", rs.getString(10));
				map.put("jumin", rs.getString(11));
				map.put("email", rs.getString(12));
				map.put("job", rs.getString(13));

				list.add(map);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("사원목록 출력오류 : " + e.getMessage());
			
		}
		return list;
	}
	
}
