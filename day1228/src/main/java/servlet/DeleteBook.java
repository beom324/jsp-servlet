package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/deleteBook.do")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		RequestDispatcher dispatcher
		= request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
