package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import vo.BoardVO;

public class InsertBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage="insertBoardOK.jsp";
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		
		BoardDAO dao = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setNo(dao.getNextNO());
		vo.setTitle(multi.getParameter("title"));
		vo.setWriter(multi.getParameter("writer"));
		vo.setPwd(multi.getParameter("pwd"));
		vo.setContent(multi.getParameter("content"));
		vo.setIp(request.getRemoteAddr());
		vo.setFname(multi.getOriginalFileName("uploadFile"));
		
		int re = dao.insertBoard(vo);
		if(re!=1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물 등록에 실패하였습니다");
		}
		
		return viewPage;
	}

}
