package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.DeleteBookAction;
import action.DetailBookAcion;
import action.InsertBookAction;
import action.InsertBookOKAction;
import action.ListBookAction;
import action.SistAction;
import action.UpdateBookAction;
import action.UpdateBookOKAction;

/**
 * Servlet implementation class SistController
 */
@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, SistAction> map;
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	map = new HashMap<String, SistAction>();
		map.put("insertBook.do", new InsertBookAction());
		map.put("listBook.do", new ListBookAction());
		map.put("insertBookOK.do", new InsertBookOKAction());
		map.put("detailBook.do", new DetailBookAcion());
		map.put("deleteBook.do", new DeleteBookAction());
		map.put("updateBook.do", new UpdateBookAction());
		map.put("updateBookOK.do", new UpdateBookOKAction());
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
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String viewPage = "";
		SistAction action ;
		action=map.get(cmd);
		viewPage = action.pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
