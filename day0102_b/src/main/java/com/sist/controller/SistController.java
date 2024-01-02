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
import com.sist.action.BoardDetailAction;
import com.sist.action.DeleteBoardAction;
import com.sist.action.DeleteBoardOKAction;
import com.sist.action.InsertBoardAction;
import com.sist.action.InsertBoardOKAction;
import com.sist.action.ListBoardAction;
import com.sist.action.UpdateBoardAction;
import com.sist.action.UpdateBoardOKAction;
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
			ListBoardAction action = new ListBoardAction();
			viewPage = action.pro(request, response);

		}else if(cmd.equals("insertBoard.do")) {
			InsertBoardAction action = new InsertBoardAction();
			viewPage = action.pro(request, response);

		}else if(cmd.equals("insertBoardOK.do")) {
			InsertBoardOKAction action = new InsertBoardOKAction();
			viewPage = action.pro(request, response);

		}
		else if(cmd.equals("boardDetail.do")) {
			BoardDetailAction action = new BoardDetailAction();
			viewPage = action.pro(request, response);

		}
		else if(cmd.equals("deleteBoard.do")) {
			DeleteBoardAction action = new DeleteBoardAction();
			viewPage = action.pro(request, response);

		}
		else if(cmd.equals("deleteBoardOK.do")) {
			DeleteBoardOKAction action = new DeleteBoardOKAction();
			viewPage = action.pro(request, response);

		}
		else if(cmd.equals("updateBoard.do")) {
			UpdateBoardAction action = new UpdateBoardAction();
			viewPage = action.pro(request, response);			
	
		}else if(cmd.equals("updateBoardOK.do")) {
			UpdateBoardOKAction action = new UpdateBoardOKAction();
			viewPage = action.pro(request, response);
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
