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
		BoardDAO dao = new BoardDAO();
		
		String viewPage="insertBoardOK.jsp";
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5, "utf-8", new DefaultFileRenamePolicy());
		int pno = Integer.parseInt(multi.getParameter("no")); //부모글의 번호
		
		int no = dao.getNextNO();
		int b_ref = no;
		int b_level=0;
		int b_step=0;
		
		
		if(pno!=0){
			BoardVO p = dao.detailBoard(pno); //부모글의 정보를 p에 담는다
			b_ref = p.getB_ref(); //b_ref는 관련있는 글임을 나타내는것이기때문에 부모글의 ref를 가져온다
			b_level =p.getB_level(); 
			b_step = p.getB_step();
			
			dao.updateStep(b_ref,b_step); 
			
			
			
			b_level++; //b_level 은 계층을 나타내기 위한것이기 때문에 ++해준다
			b_step++; //
			
		}
		
		BoardVO vo = new BoardVO();
		vo.setNo(dao.getNextNO());
		vo.setTitle(multi.getParameter("title"));
		vo.setWriter(multi.getParameter("writer"));
		vo.setPwd(multi.getParameter("pwd"));
		vo.setContent(multi.getParameter("content"));
		vo.setIp(request.getRemoteAddr());
		vo.setFname(multi.getOriginalFileName("uploadFile"));
		vo.setB_ref(b_ref);
		vo.setB_level(b_level);
		vo.setB_step(b_step);
		int re = dao.insertBoard(vo);
		if(re!=1) {
			viewPage = "error.jsp";
			request.setAttribute("msg", "게시물 등록에 실패하였습니다");
		}
		
		return viewPage;
	}

}
