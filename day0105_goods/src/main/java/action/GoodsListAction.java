package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodsDAO;
import vo.GoodsVO;

public class GoodsListAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDAO dao = new GoodsDAO();
		int pageNum = 1;
		if (request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		String search = null;
		if (request.getParameter("search") != null) {
			search = request.getParameter("search");
		}
		
		ArrayList<GoodsVO> list = dao.listGoods(pageNum, search);
		
		request.setAttribute("list", list);
		request.setAttribute("totalPage", dao.totalPage);
		request.setAttribute("search", search);
		
		return "listGoods.jsp";
	}

}

