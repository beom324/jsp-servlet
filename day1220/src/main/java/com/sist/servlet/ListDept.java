package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

/**
 * Servlet implementation class ListDept
 */
@WebServlet("/listDept")
public class ListDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		DeptDAO dao = new DeptDAO();
		ArrayList<DeptVO> list = dao.deptList();
		String data = "";
		for(DeptVO s : list) {
			data += "<tr>";
			data += "<td>";			
			data += s.getDno();
			data += "</td>";
			data += "<td>";
			data += s.getdName();
			data += "</td>";
			data += "<td>";
			data += s.getdLoc();
			data += "</td>";
			data += "</tr>";			
		}
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("</title>");
		out.println("</head>");	
		out.println("<body>");	
		out.println("<table border=\"1\">");
		out.print(data);
		out.println("</table>");
		out.println("</body>");			
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
