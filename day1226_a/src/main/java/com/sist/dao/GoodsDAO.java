package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	
	public GoodsVO findByNo(int no) {
		GoodsVO g = null;
		String sql = "select * from goods where no = ?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				g = new GoodsVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return g;
		
	}
	
	public int insertGoods(GoodsVO g) {
		int re= -1;
		try {
			String sql = "insert into goods values(?,?,?,?,?)";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3,g.getPrice());
			pstmt.setInt(4, g.getQty());
			pstmt.setString(5, g.getFname());
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	
	public ArrayList<GoodsVO> listGoods(){
		String sql = "select * from goods order by no";
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new GoodsVO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
			}
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public int deleteGoods(int no) {
		int re =-1;
		String sql ="delete goods where no=?";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}
	public int updateGoods(GoodsVO g) {
		int re= -1;
		try {
			String sql = "update goods set name=?,price=?,qty=?,fname=? where no=?";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getName());
			pstmt.setInt(2,g.getPrice());
			pstmt.setInt(3, g.getQty());
			pstmt.setString(4, g.getFname());
			pstmt.setInt(5, g.getNo());
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return re;
	}
	

}
