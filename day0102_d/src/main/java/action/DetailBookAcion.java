package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

public class DetailBookAcion implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "detailBook.jsp";
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO(); 
		int num = Integer.parseInt(request.getParameter("bookid"));
		
		vo = dao.findByBookId(num);
		
		request.setAttribute("vo", vo);
		return viewPage;
		
	}

}
