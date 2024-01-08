package com.sist.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.SistAction;

@WebServlet("*.do") //web.xml에서도 설정할 수 있고, Annotation으로 설정할 수 있다. 모든 .do패턴으로 설정
public class SistController extends HttpServlet {
	HashMap<String, SistAction> map ;//사용자의 요청명과 일처리하는 객체 생성하는 맵
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {//properties파일의 실제경로를 알기위해
																	//config를 매개변수로 갖는 init사용
		map = new HashMap<String, SistAction>();
		String path = config.getServletContext().getRealPath("WEB-INF");//프로젝트 환경설정을 감추기위해 보통 web-inf에 둠
		try {
			FileReader fr = new FileReader(path + "/sist.properties");
			Properties prop = new Properties();//파일의 내용을 읽어들여서 key는key대로 value는value대로 
			prop.load(fr);// fr에 담긴 sist.properties 파일을 key는key대로 value는value대로 분류하여 담김
			Iterator iter =  prop.keySet().iterator();//모든 key들을 가져와서 반복
			while(iter.hasNext()) {//다음데이터가 있는만큼 반복문을 돎
				String key = (String) iter.next();
				String clsName = (String)prop.get(key);//key값에 해당하는 value값을 가져옴
				Object obj = Class.forName(clsName).newInstance();//clsName에 해당하는 객체를 생성해줌
				map.put(key,(SistAction)obj);												
			}					
		}catch(Exception e) {
			System.out.println("init 오류 : " + e.getMessage());
		}
	}
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String cmd = uri.substring(uri.indexOf("/",1)+1);// 슬러쉬는 빼고 갖고오기 위해 +1
		SistAction action = map.get(cmd);
		String viewPage = action.pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
