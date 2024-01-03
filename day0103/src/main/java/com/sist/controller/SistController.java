package com.sist.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
import com.sist.action.SistAction;
import com.sist.action.UpdateBoardAction;

import com.sist.action.UpdateBoardOKAction;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class SistController
 */
//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	HashMap<String, SistAction> map;
	
	//서블릿이 맨 처음 시작이 한번만 동작되는 init에 map의 값을 넣어준다. = 한번만 실행시켜 메모리 절약
    @Override
	public void init(ServletConfig config) throws ServletException {   	  	
    	
    	map = new HashMap<String, SistAction>();
    	try {
    		//init 메소드에는 request가 없음. ServletConfig를 통해 파일의 실경로를 알 수 있음
    		String path = config.getServletContext().getRealPath("WEB-INF");
    		FileReader fr = new FileReader(path+"/sist.properties");
    		Properties prop = new Properties();//properties파일을 읽어들여 key는key대로 value는value대로 읽음
    		prop.load(fr); //sist.properties를 key는key대로 value는value대로 분류
    		Iterator iter = prop.keySet().iterator(); //set에는 크기만큼 반복문을 실행할 수 없어 Iterator를 통해 반복실행하여
    												 //key를 가져옴
    		while(iter.hasNext()) {//iter에 값이 있는만큼 반복 실행해라
    			String key = (String)iter.next(); //object를 반환하기 때문에 형변환해준다
    			String clsName = (String)prop.get(key); // key의 value값을 get메소드를 통해 가져와서 변수에 담는다.
//    			Class.forName(clsName).newInstance();//문자열로된 클래스이름에 해당하는 객체를 생성해줌
    			
    			map.put(key,(SistAction)Class.forName(clsName).newInstance());//map을 선언할 때 value값을 자료형을 
    																		//SistAction으로 선언했기 때문에 형변환해줌   			
    		}
    		fr.close();
    		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
	}

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
		//사용자의 uri 를 가져온다
		String uri = request.getRequestURI();
		
		
		
		//맨 끝의 서비스명만 추출하여 cmd에 넣는다.
		String cmd = uri.substring(uri.indexOf("/", 1)+1);
		
		//해당 서비스명에 대한 객체를 불러와 pro 메소드를 실행하고
		//viewPage에 다음으로 이동할 페이지의 이름을 저장한다.
		String viewPage = map.get(cmd).pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
