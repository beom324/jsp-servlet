package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BookDAO;

public class ListBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="listBook.jsp";
		String search = null;
		String option = null;
		String oper = null;
		String sort = null;
		HttpSession session = request.getSession();
		
		
		
		if(request.getParameter("sort")!=null) {
			sort = request.getParameter("sort");				
		}
		
		if(session.getAttribute("search")!= null) { //세션에 저장된게 있으면 갖고온다.
													
			search = (String)session.getAttribute("search");
			option = (String)session.getAttribute("option");
			oper = (String)session.getAttribute("oper");
		}
		
		
			if(request.getParameter("search") !=null) {//늦게 검색된 애가 우선순위가 높아야해서 session보다 아래둔다.
				search = request.getParameter("search");
				option = request.getParameter("option");
				
				
				if(option.equals("price")) {
					oper = request.getParameter("oper");
				}
				
				session.setAttribute("search",search );
				session.setAttribute("option",option );
				session.setAttribute("oper",oper );
			}
			
			
				
		BookDAO dao = BookDAO.getInstance();
		request.setAttribute("list", dao.findAll(search,option,oper,sort));
		
		return viewPage;
	}

}
