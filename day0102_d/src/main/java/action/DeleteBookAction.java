package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;

public class DeleteBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookDAO dao = new BookDAO();
		
		String fname = dao.findByBookId(bookid).getFname();
		
		
		int re = dao.deleteBook(bookid);
		String viewPage = "deleteBookOK.jsp";
		if(re != 1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "도서 삭제에 실패하였습니다.");			
		}else {
			if(fname != null && !fname.equals("")) {
				String path = request.getRealPath("bookImages");
				File file = new File(path + "/" + fname);
				file.delete();
			}
		}
		return viewPage;	
		
	}

}
