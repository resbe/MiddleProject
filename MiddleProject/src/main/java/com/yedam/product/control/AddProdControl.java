package com.yedam.product.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.product.domain.ProdVO;
import com.yedam.product.service.ProdService;
import com.yedam.product.service.ProdServiceImpl;

public class AddProdControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String saveDir = req.getServletContext().getRealPath("images");
		int maxSize = 5 * 1024 * 1024;
		String encoding = "UTF-8";
		DefaultFileRenamePolicy rn = new DefaultFileRenamePolicy();
		MultipartRequest multi 
				= new MultipartRequest(req, saveDir, maxSize, encoding, rn);
		
		int cat = Integer.parseInt(multi.getParameter("cat"));
		int subcat = Integer.parseInt(multi.getParameter("subcat"));
		String pdtName = multi.getParameter("pdtName");
		int price = Integer.parseInt(multi.getParameter("price"));
		String img = multi.getParameter("img");
		
		ProdVO vo = new ProdVO();
		vo.setCatId(cat);
		vo.setSubcatId(subcat);
		vo.setPdtNm(pdtName);
		vo.setPdtPrice(price);
		vo.setPdtImg(img);
		
		ProdService service = new ProdServiceImpl();
		if (service.addProd(vo)) {
			return "prodList.do";
		} else {
			return "main.do";
		}
	}

}
