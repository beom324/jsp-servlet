package controller;

import java.io.FileReader;
import java.io.IOException;
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

import action.SistAction;

/**
 * Servlet implementation class SistController
 */
@WebServlet("*.do")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, SistAction> map;
       
    
    @Override
	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
    	
    	map= new HashMap<String, SistAction>();
    	String path = config.getServletContext().getRealPath("WEB-INF");
    	try {
    		FileReader fr = new FileReader(path+"/sist.properties");
    		Properties prop = new Properties();
    		prop.load(fr);
    		Set keyList = prop.keySet();
    		Iterator iter = keyList.iterator();
    		while(iter.hasNext()) {
    			String key = (String)iter.next();
    			String clsName = prop.getProperty(key);
    			Object obj = Class.forName(clsName).newInstance();
    			map.put(key, (SistAction)obj);
    		}
    		fr.close();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
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
		String cmd = uri.substring(uri.indexOf("/",1)+1);
		SistAction action = map.get(cmd);
		System.out.println(action);
		String viewPage = action.pro(request, response);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/template.jsp");
		//사용자가 요청한 uri에 member글자가 있으면
		//viewPage앞에 member/를 붙입니다
		if(uri.indexOf("member")!=-1) {
			viewPage = "member/"+viewPage;
		}
		request.setAttribute("viewPage", viewPage);
		dispatcher.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
