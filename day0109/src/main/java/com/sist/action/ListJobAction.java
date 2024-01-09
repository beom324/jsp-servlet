package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.EmpDAO;

public class ListJobAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listJob.jsp";
		Gson gson = new Gson();
		EmpDAO dao = EmpDAO.getInstance();
		
		
		request.setAttribute("json",gson.toJson(dao.listJob()));
		
		return viewPage;
	}

}
