package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookDAO;
import vo.BookVO;

public class InsertBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("bookImage");
		
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5,"utf-8", new DefaultFileRenamePolicy());
		BookDAO dao = new BookDAO();
		
		int num = dao.getNextNO();
		
		
		String title = multi.getParameter("title");
		int price = Integer.parseInt(multi.getParameter("price"));
		String publisher = multi.getParameter("publisher"); 
		String fname = multi.getOriginalFileName("uploadFile");
		int re = dao.insertBook(new BookVO(num, title, price, publisher,fname));
		String viewPage = "insertBookOK.jsp";
		if(re==1) {
			System.out.println("책이 등록되었습니다");
		}else {
			System.out.println("책 등록에 실패하였습니다.");
			viewPage="error.jsp";
		}
		
		return viewPage;
	}

}
