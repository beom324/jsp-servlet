package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;

public class DeleteBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="deleteBoardOK.jsp";
		BoardDAO dao = new BoardDAO();
		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		String oldFname = dao.detailBoard(no).getFname();
		int re = dao.delete(no, pwd);
		if(re==1 && oldFname !=null && !oldFname.equals("")) {
			String path = request.getRealPath("data");
			File file = new File(path + "/" + oldFname );
			file.delete();
		}else {
			viewPage="error.jsp";
		}
		return viewPage;
	}

}
