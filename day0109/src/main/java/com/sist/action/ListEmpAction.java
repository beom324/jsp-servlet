package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;

public class ListEmpAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listEmp.jsp";
		EmpDAO dao = EmpDAO.getInstance();
		String search = null;
		String option = null;
		if(request.getParameter("option") !=null) {
			option = request.getParameter("option");
			search = request.getParameter("search");
			System.out.println(option);
		}
		
		
		request.setAttribute("list",dao.findAll(search,option));
		
		
		
		return viewPage;
	}

}
