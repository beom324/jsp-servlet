package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;

public class ListJoinEmpAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="listJoinEmp.jsp";
		EmpDAO dao = EmpDAO.getInstance();
		
		request.setAttribute("list", dao.empList());
		
		return viewPage;
	}

}
