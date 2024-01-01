package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
	String driver ="oracle.jdbc.driver.OracleDriver";
	String url ="jdbc:oracle:thin:@localhost:1521:xe";	
	String userName ="c##madang";
	String password = "madang";
	
	
	
	
	public int insertBook(BookVO vo) {
		
		int re =-1;
		try {
			String sql ="insert into book values(?,?,?,?)";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBookId());
			pstmt.setString(2,vo.getBookName());
			pstmt.setInt(3,vo.getPrice());
			pstmt.setString(4,vo.getPublisher());
			re = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.getMessage();
		}
		return re;
	}
	
	public int deleteBook(int bookid) {
		int re = -1;
		try {
			String sql = "delete from book where bookid = ?";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,userName,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookid);
			
			re=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	
	public int updateBook(BookVO vo) {
		int re = -1;
		try {
			String sql = "UPDATE book SET bookid = ?, bookname = ?, price = ?, publisher = ? WHERE bookid = ?";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, userName, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBookId());
			pstmt.setString(2, vo.getBookName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getPublisher());
			pstmt.setInt(5, vo.getBookId());
			
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	
	
	
	
	public ArrayList<BookVO> listBook(){
		
		String sql ="select * from book order by bookid";
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,userName,password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String bookName = rs.getString(2);
				int price =rs.getInt(3);
				String publisher = rs.getString(4);
				
				list.add(new BookVO(id, bookName, price, publisher));
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
		
	}
		

}
