package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvider;

public class OrdersDAO {

	
	public static OrdersDAO dao = null;
	
	private OrdersDAO() {}
	
	public static OrdersDAO getInstance() {
		if(dao==null) {
			dao = new OrdersDAO();			
		}
		return dao;
	}



	public ArrayList<HashMap<String, Object>> listOrders(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "select c.custid, name, bookname from customer c, orders o, book b where c.custid=o.custid and o.bookid=b.bookid";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("custid", rs.getInt(1));
				map.put("name", rs.getString(2));
				map.put("bookname", rs.getString(3));
				list.add(map);				
			}
			ConnectionProvider.close(conn, pstmt, rs);
			
		}catch(Exception e) {
			System.out.println("주문 내역 출력 오류 : " + e.getMessage());
		}
		return list;
	}
}
