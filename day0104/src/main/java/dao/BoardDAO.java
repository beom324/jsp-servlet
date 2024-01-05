package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;

import db.ConnectionProvider;
import vo.BoardVO;

public class BoardDAO {
	
	public static int pageSIZE = 10; //한 화면에 보여줄 레코드 수
	public static int totalRecord = 0;// 전체 레코드의 수
	public static int totalPage = 0;//전체 페이지 수

	public int getTotalRecord() {
		String sql = "select count(*) from board";
		int re =0;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re = rs.getInt(1);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return re;

	}


	//이미달려있는 답글들의 step을 1씩 증가하는 메소드	
	public void updateStep(int b_ref, int b_step) {
		String sql = "update board set b_step = b_step + 1 where b_ref =? and b_step>?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);						
			
			pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
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


	
	
	public ArrayList<BoardVO> findAll(int pageNUM){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		totalRecord = getTotalRecord();
		totalPage = (int)Math.ceil(totalRecord*1.0/pageSIZE);
		
		//페이지번호에 따른 start와 end를 계산하여 출력
		int start = (pageNUM-1)*pageSIZE+1;
		int end = start+pageSIZE -1;
		
		if(end>totalRecord) {
			end=totalRecord;
		}
		System.out.println(start);
		System.out.println(end);
		
		
		
		String sql = "select no,title,writer,pwd,content,regdate,hit,fname,ip,b_ref,b_level,b_step from (select rownum n,no,title,writer,pwd,content,regdate,hit,fname,ip,b_ref,b_level,b_step from(select * from board order by b_ref desc, b_step))a where a.n  between ? and ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getString(8),rs.getString(9),rs.getInt(10),rs.getInt(11),rs.getInt(12)));
			}
			
			ConnectionProvider.close(conn, pstmt,rs);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	
	public int insertBoard(BoardVO b) {
		int re = -1;
		String sql = "insert into board values(?,?,?,?,?,sysdate,1,?,?,?,?,?)";
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
			pstmt.setInt(8, b.getB_ref());
			pstmt.setInt(9, b.getB_level());
			pstmt.setInt(10, b.getB_step());
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
				vo.setIp(rs.getString(9));
				vo.setB_ref(rs.getInt(10));
				vo.setB_level(rs.getInt(11));
				vo.setB_step(rs.getInt(12));
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
