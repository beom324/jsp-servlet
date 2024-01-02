package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class BoardDetailAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		String viewPage="boardDetail.jsp";
		int num = Integer.parseInt(request.getParameter("no"));
		String path = request.getRealPath("data");
		BoardDAO dao = new BoardDAO();
		vo=dao.detailBoard(num);
		request.setAttribute("path", path);
		request.setAttribute("vo", vo);
		return viewPage;
	}

}
