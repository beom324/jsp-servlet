package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {
	
	public static BookDAO dao = null;
	
	private BookDAO() {//new BookDAO를 통해 생성하지 못하도록 private로 막아둠, 아무곳에서나 생성하는걸 방지
		
	}
	
	public static BookDAO getInstance() {
		if(dao==null) {//생성되어 있는 dao가 없다면
		dao = new BookDAO();//getInstance메소드를 통해 dao생성
		}
		return dao; //else 기존 dao 리턴
	}
	
	public ArrayList<BookVO> findAll(String search, String option, String oper,String sort){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql ="select * from book ";
		String asc = " ";
		if(search !=null) {
			if(option .equals("price")) {
				sql+="where price "+oper+" " + search;
			}else { 
					sql+="where "+option+" like '%"+search+"%'";
			}
			
		}
		if(sort!=null) {
			
			sql += " order by " +sort+asc;
			
		}			
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println("findAll 오류발생 : " + e.getMessage());
		}				
		
		return list;
	}
		
	public ArrayList<String> listPublisher(){
		String sql ="select distinct publisher from book";
		ArrayList<String> list = new ArrayList<String>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, pstmt, rs);												
		}catch(Exception e) {
			System.out.println("dao 오류 : " +e.getMessage());
		}				
		return list;		
	}			
}