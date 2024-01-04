package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConnectionProvider;
import vo.BoardVO;

public class BoardDAO {
	
	public int updateBoard(BoardVO b) {
		int re = -1;
		String sql = "update board set title=?,content=?,fname=? where no=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getFname());
			pstmt.setInt(4, b.getNo());
			pstmt.setString(5, b.getPwd());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		}catch(Exception e) {
			
		}
		return re;
	}

	public ArrayList<BoardVO> findAll(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "select * from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8),rs.getString(9)));
			}
			
			ConnectionProvider.close(conn, stmt,rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public int insertBoard(BoardVO b) {
		int re = -1;
		String sql = "insert into board values(?,?,?,?,?,sysdate,1,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());
			pstmt.setString(6, b.getFname());
			pstmt.setString(7, b.getIp());
			re= pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
												
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return re;
	}

	public int getNextNO() {
		String sql = "select nvl(max(no),0)+1 from board";
		int no=0;
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				no=rs.getInt(1);
			}
					
			ConnectionProvider.close(conn, stmt, rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return no;
	}
	
	public BoardVO detailBoard(int no) {
		String sql = "select * from board where no=?";
		BoardVO vo = new BoardVO();
		try {
			Connection conn =ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setNo(no);
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPwd(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setRegdate(rs.getDate(6));
				vo.setHit(rs.getInt(7));
				vo.setFname(rs.getString(8));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return vo;
	}
	
	public int delete(int no, String pwd) {
		int re =-1;
		String sql ="delete board where no=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);
			
			re=pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
		
		
		return re;
	}
	
	
	
	
	
	
	
	
	
}
