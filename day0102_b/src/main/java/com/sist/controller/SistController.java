package com.sist.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sist.action.BoardDetailAction;
import com.sist.action.DeleteBoardAction;
import com.sist.action.DeleteBoardOKAction;
import com.sist.action.InsertBoardAction;
import com.sist.action.InsertBoardOKAction;
import com.sist.action.ListBoardAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBoardAction;
import com.sist.action.UpdateBoardOKAction;

//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HashMap<String, SistAction> map;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//super.init(config);
		map = new HashMap<String, SistAction>();
		map.put("listBoard.do", new ListBoardAction());
		map.put("insertBoard.do", new InsertBoardAction());
		map.put("inserttBoardOK.do", new InsertBoardOKAction());
		map.put("boardDetail.do", new BoardDetailAction());
		map.put("deleteBoard.do", new DeleteBoardAction());
		map.put("deleteBoardOK.do", new DeleteBoardOKAction());
		map.put("updateBoard.do", new UpdateBoardAction());
		map.put("updateBoardOK.do", new UpdateBoardOKAction());
	}

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
		SistAction action;
		
		action = map.get(cmd);
		viewPage = action.pro(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 get방식으로 요청하건 post방식으로 요청하거나 동일한 처리를 위하여 
		//post방식으로 요청하면 doGet을 호출하고 모든 일처리는 doGet에서 처리한다
		doGet(request, response);
	}

}
