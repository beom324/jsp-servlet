package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import vo.BookVO;

public class UpdateBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "updateBook.jsp";
		BookDAO dao =new BookDAO();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookVO vo = dao.findByBookId(bookid);
		
		request.setAttribute("vo", vo);
		return viewPage;
	}

}
