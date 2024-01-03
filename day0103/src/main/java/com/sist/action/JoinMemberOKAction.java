package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class JoinMemberOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String viewPage = "joinMemberOK.jsp";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		MemberDAO dao = new MemberDAO();
		int re = dao.joinMember(new MemberVO(id, pwd, name, email, phone));
		
		if(re!=1) {
			viewPage="error.jsp";
			request.setAttribute("msg", "회원가입중 오류가 생겼습니다");
		}
		
		return viewPage;
		
	}

}
