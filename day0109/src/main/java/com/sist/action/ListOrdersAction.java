package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.OrdersDAO;

public class ListOrdersAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "listOrders.jsp";
		
		OrdersDAO dao = OrdersDAO.getInstance();
		request.setAttribute("list", dao.listOrders());
		return viewPage;
	}

}
