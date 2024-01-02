package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SistController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);

		String viewPage = "";
		BoardDAO dao = new BoardDAO();


		if(cmd.equals("listBoard.do")) {
			viewPage = "listBoard.jsp";
			request.setAttribute("list", dao.findAll());


		}else if(cmd.equals("insertBoard.do")) {
			viewPage = "insertBoard.jsp";

		}else if(cmd.equals("insertBoardOK.do")) {
			viewPage = "insertBoardOK.jsp";
			String path = request.getRealPath("data");
			System.out.println("path : " + path);
			MultipartRequest multi = new MultipartRequest(request, path,1024*1024*5,"utf-8", new DefaultFileRenamePolicy());
			BoardVO vo = new BoardVO();
			vo.setNo(dao.getNextNO());
			vo.setTitle(multi.getParameter("title"));
			vo.setWriter(multi.getParameter("writer"));
			vo.setPwd(multi.getParameter("pwd"));
			vo.setContent(multi.getParameter("content"));
			vo.setFname(multi.getOriginalFileName("uploadFile"));
			vo.setIp(request.getRemoteAddr());

			int re = dao.insertBoard(vo);

			if(re!= 1) {
				viewPage = "error.jsp";
				request.setAttribute("msg", "게시물 등록에 실패하였습니다.");
			}

		}
		else if(cmd.equals("boardDetail.do")) {
			BoardVO vo = new BoardVO();
			viewPage="boardDetail.jsp";
			int num = Integer.parseInt(request.getParameter("no"));
			String path = request.getRealPath("data");
			vo=dao.detailBoard(num);
			request.setAttribute("path", path);
			request.setAttribute("vo", vo);

		}
		else if(cmd.equals("deleteBoard.do")) {
			viewPage="deleteBoard.jsp";
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("no", no);

		}
		else if(cmd.equals("deleteBoardOK.do")) {
			viewPage="deleteBoardOK.jsp";
			int no = Integer.parseInt(request.getParameter("no"));
			String pwd = request.getParameter("pwd");
			String oldFname = dao.detailBoard(no).getFname();
			int re = dao.delete(no, pwd);
			if(re==1 && oldFname !=null && !oldFname.equals("")) {
				String path = request.getRealPath("data");
				File file = new File(path + "/" + oldFname );
				file.delete();
			}

		}
		else if(cmd.equals("updateBoard.do")) {
			int no = Integer.parseInt(request.getParameter("no"));
			request.setAttribute("b", dao.detailBoard(no));
			viewPage = "updateBoard.jsp";
	
		}else if(cmd.equals("updateBoardOK.do")) {
			viewPage = "updateBoardOK.jsp";
			String path = request.getRealPath("data");
			MultipartRequest multi = 
			new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
			String oldFname = multi.getParameter("fname");
			BoardVO b = new BoardVO();
			b.setNo(Integer.parseInt(multi.getParameter("no")));
			b.setTitle(multi.getParameter("title"));
			b.setContent(multi.getParameter("content"));
			b.setPwd(multi.getParameter("pwd"));
			b.setFname(oldFname);
			String fname = multi.getOriginalFileName("uploadFile");
			if(fname != null) {
				b.setFname(fname);
			}
			
			int re = dao.updateBoard(b);
			if(re == 1) {
				if(fname != null && oldFname != null && !oldFname.equals("")) {
					File file = new File(path +"/" + oldFname);
					file.delete();
				}
			}else {
				viewPage = "error.jsp";
				request.setAttribute("msg", "게시물 수정에 실패하였습니다.");
			}


		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
