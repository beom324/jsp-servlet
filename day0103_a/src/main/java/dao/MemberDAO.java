package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.MemberVO;

import db.ConnectionProvider;

public class MemberDAO {

	public int joinMember(MemberVO vo) {
		int re = -1;
		String sql = "insert into member values(?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return re;
		
	}
	
	public MemberVO findMember(String id, String pwd) {
		String sql = "select id,pwd from member where id=? and pwd=?";
		MemberVO vo = new MemberVO();
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setId(id);
				vo.setPwd(pwd);
			}
			
			ConnectionProvider.close(conn, pstmt, rs);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return vo;
		
		
		
		
		
	}
}
