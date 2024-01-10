package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.EmpDAO;

public class ListDeptNameAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="listDeptName.jsp";
		EmpDAO dao = EmpDAO.getInstance();
		Gson gson = new Gson();
		request.setAttribute("json", gson.toJson(dao.deptNameList()));						
		
		return viewPage;
	}

}
