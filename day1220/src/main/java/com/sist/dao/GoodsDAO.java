
package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##madang";
	String password = "madang";	
	
	int pageSIZE = 3;   //한 화면에 보여줄 레코드의 수     
	int totalRecord;	//전체 레코드의 수              19
	int totalPage;		//전체 페이지의 수				4
	
	//전체 페이지수를 반환하는 메소드 정의
	public int getTotalPage() {
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSIZE);		
		return totalPage;
	}
		
	//전체 레코드수를 반환하는 메소드를 완성 해 봅니다.
	public int getTotalRecord() {
		int cnt = 0;
		String sql = "select count(*) from goods";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
		return cnt;
	}
			
	public ArrayList<GoodsVO> listGoods(int pageNUM){
		
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord / (double)pageSIZE);
		
		int start;	//현재페이지에 따른 시작레코드의 위치
		int end;	//현재페이지에 따른 마지막레코드의 위치
		
		start = (pageNUM-1)*pageSIZE + 1;
		end = pageNUM*pageSIZE;
		
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			Class.forName(driver);
			Connection conn 
			= DriverManager.getConnection(url, username, password);
			String sql = "select no,name,price,qty,fname from "
					+ "(select rownum n, no, name, price, qty, fname "
					+ "from goods) a "
					+ "where a.n between ? and ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO g = new GoodsVO();
				g.setNo(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setPrice(rs.getInt(3));
				g.setQty(rs.getInt(4));
				g.setFname(rs.getString(5));
				list.add(g);
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}
