package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookDAO;
import vo.BookVO;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook.do")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDAO dao =new BookDAO();
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookVO vo = dao.findByBookId(bookid);
		
		request.setAttribute("vo", vo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updateBook.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("bookImages");
		BookVO b = new BookVO();
		request.setCharacterEncoding("utf-8");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5,"utf-8", new DefaultFileRenamePolicy());
		String viewPage="updateBookOK.jsp";
		int re = 0;
		int bookid = Integer.parseInt(multi.getParameter("bookid"));
		
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String publisher = multi.getParameter("publisher");
		String oldFname = multi.getParameter("fname");
		String fname = multi.getOriginalFileName("uploadFile");
	
		BookVO vo = new BookVO(bookid, title, price, publisher,fname);
		BookDAO dao = new BookDAO();
		re=dao.updateBook(vo);
		request.setAttribute("vo", vo);
		if(re!=1) {
			viewPage="error.jsp";
			System.out.println("수정 실패");
		}else {
			if(fname!=null && oldFname !=null && !oldFname.equals("")) {
				File file = new File(path + "/" + oldFname);
				file.delete();
			}
		}
		RequestDispatcher dispatcher =request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
