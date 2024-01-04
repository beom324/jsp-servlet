package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class LoginOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "loginOK.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo=dao.findMember(id, pwd);
		
		if(vo.getId()!=null && vo.getPwd()!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userID", id);
		}else {
			viewPage="error.jsp";
			request.setAttribute("msg", "로그인에 실패하였습니다");
		}
		return viewPage;
	}

}
