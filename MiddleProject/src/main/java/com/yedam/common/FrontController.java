package com.yedam.common;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.product.control.ProdListControl;
import com.yedam.qna.control.GetQnaControl;
import com.yedam.qna.control.QnaListControl;
import com.yedam.user.control.SignUpControl;

public class FrontController extends HttpServlet{
	private Map<String, Control> map;
	String encoding;
	public FrontController() {
		map = new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		// 첫페이지
		map.put("/main.do", new MainControl());
		//qna
		map.put("/qnaList.do", new QnaListControl());
		map.put("/getQna.do", new GetQnaControl());
		//product
		map.put("/prodList.do", new ProdListControl());

		

		map.put("/signUp.do", new SignUpControl());
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);
		
		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println(viewPage);
		
		if(viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;		//메소드종료
		} 
		if(viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0, viewPage.length()-5));
			return;
		}
		
		//페이지 재지정
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
}