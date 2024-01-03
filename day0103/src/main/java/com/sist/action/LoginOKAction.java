package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class LoginOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="loginOK.jsp";
		String input_id = request.getParameter("id");
		String input_pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		request.setAttribute("id", session.getAttribute("id"));
		
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.findMember(input_id, input_pwd);
		if(vo.getId()==null||vo.getPwd()==null) {
			viewPage="error.jsp";
			request.setAttribute("msg","아이디나 비밀번호가 일치하지 않습니다.");
		}else {
			session.setAttribute("session_id", input_id);			
		}
		return viewPage;
		
		
				
		
	}

}
