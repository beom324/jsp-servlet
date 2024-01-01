package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

@WebServlet("/listDeptJson")
public class ListDeptJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDeptJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		Gson gson = new Gson();
		DeptDAO dao = new DeptDAO();
		String data = gson.toJson(dao.deptList());
		
		out.print(data);		
		out.close();
		
		
		
		
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>");
//		out.println("</title>");
//		out.println("</head>");	
//		out.println("<body>");	
//		out.println("<table border=\"1\">");
//		out.print(data);
//		out.println("</table>");
//		out.println("</body>");			
//		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
