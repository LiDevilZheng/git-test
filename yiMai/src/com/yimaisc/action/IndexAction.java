package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimaisc.comment.PageBean;
import com.yimaisc.entity.Category;
import com.yimaisc.entity.CategoryDTO;
import com.yimaisc.entity.News;
import com.yimaisc.entity.Product;
import com.yimaisc.entity.SaleLine;
import com.yimaisc.entity.ShopCart;
import com.yimaisc.entity.User;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.NewsService;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.NewsServiceImpl;
import com.yimaisc.service.impl.ProductServiceImpl;

public class IndexAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//1.显示商品分类信息
		CategoryService cs=new CategoryServiceImpl();
		PageBean<CategoryDTO> pb=new PageBean<CategoryDTO>(1, 6);
		cs.findParentByPage(pb);
		request.setAttribute("pb", pb);
		//2.显示新闻信息
		NewsService ns=new NewsServiceImpl();
		PageBean<News> pbNews=new PageBean<News>(1, 12);
		ns.findByPage(pbNews);
		request.setAttribute("pbNews", pbNews);
		//3.显示商品信息
		ProductService ps=new ProductServiceImpl();
		PageBean<Product> pbProduct=new PageBean<Product>(1, 12);
		ps.findByPage(pbProduct);
		request.setAttribute("pbProduct", pbProduct);
		//4.接受用户登录信息
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		ShopCart sc=(ShopCart) session.getAttribute("cart");
		if(sc==null){
			session.setAttribute("sum", 0);
		}else{
			List<SaleLine> li=sc.getLines();
			int temp=0;
			for(SaleLine s:li){
				temp+=s.getNum();
			}
			session.setAttribute("sum", temp);
		}
		
		//5.显示最近浏览
		String str="";
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie c:cookies){
				if(c.getName().equals("productId")){
					str=c.getValue();
					break;
				}
			}
			if(str!=null&&!str.equals("")){
				List<Product> lp=ps.findByStr(str);
				request.setAttribute("lp", lp);
			}	
		}		
		//6.显示二级分类
		String cpid=request.getParameter("cpid");
		if(cpid!=null&&!cpid.equals("")){
			int parentId=Integer.parseInt(cpid);
			List<Category> cli=cs.findByParentId(parentId);
			request.setAttribute("cli", cli);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
