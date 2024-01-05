package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import db.ConnectionProvider;
import vo.GoodsVO;

public class GoodsDAO {
	public static int totalRecord=0;
	public static int totalPage=0;
	public static int pageSize = 3; //페이지수당 출력할 결과물 수
	
	public int getTotalRecord(String search) {
		
		int cnt=0;
		try {
			String sql = "select count(*) from goods"; 
			if (search != null) {
				sql += " where name like '%"+search+"%'";
			}
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt =conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cnt;
	}
	
	public int insertGoods(GoodsVO g) {
		int re= -1;
		try {
			String sql = "insert into goods values(?,?,?,?,?)";
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/sist");
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
	
	
	public ArrayList<GoodsVO> listGoods(int pageNum,String name){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();

		totalRecord = getTotalRecord(name);
		totalPage = (int)Math.ceil(totalRecord*1.0/pageSize);
		
		int start = (pageNum-1)*pageSize+1;
		int end = start+pageSize-1;
		
		if(end>totalRecord) {
			totalRecord=end;
		}
		String sql = "select g.* "
				+ "from "
				+ "(select a.*, rownum rm "
				+ "from "
				+ "(select * from goods ";
		
		if (name != null) {
			sql += " where name like '%"+name+"%'";
		}
		
		sql += "order by no desc) a) g "
				+ "where g.rm between "+start+" and "+end+"";
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/sist");
			Connection conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			
			while (res.next()) {
				list.add(new GoodsVO(
						res.getInt(1),
						res.getString(2),
						res.getInt(3),
						res.getInt(4),
						res.getString(5)
						));
			}
			
			res.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("goods 목록 에러 : " + e.getMessage());
		}
		
		return list;
	}
	
	

}
