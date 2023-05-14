package com.yedam.qna.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.qna.domain.QnaVO;
import com.yedam.qna.service.QnaService;
import com.yedam.qna.service.QnaServiceImpl;
import com.yedam.user.domain.UserVO;

public class QnaListControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageStr = req.getParameter("page");	
		pageStr = pageStr ==null ? "1" : pageStr;
		int page = Integer.parseInt(pageStr);
		
		QnaService service = new QnaServiceImpl();
		int total = service.totalQnaCount();
		List<QnaVO> list = service.qnaList(page);
		
		
		PageDTO dto = new PageDTO(page,total);
		req.setAttribute("list", list);

		req.setAttribute("pageInfo", dto);
	
		return "qna/qnalist.tiles";
		

		
		
	}

}
