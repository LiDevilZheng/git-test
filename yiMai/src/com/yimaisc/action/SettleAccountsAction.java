package com.yimaisc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimaisc.entity.Detail;
import com.yimaisc.entity.Order;
import com.yimaisc.entity.Product;
import com.yimaisc.entity.SaleLine;
import com.yimaisc.entity.ShopCart;
import com.yimaisc.entity.User;
import com.yimaisc.service.DetailService;
import com.yimaisc.service.OrderService;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.DetailServiceImpl;
import com.yimaisc.service.impl.OrderServiceImpl;
import com.yimaisc.service.impl.ProductServiceImpl;

/**
 *
 *@author 栗子
 *@description 
 */
public class SettleAccountsAction extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String address=request.getParameter("address");
		OrderService os=new OrderServiceImpl();
		ProductService ps=new ProductServiceImpl();
		DetailService ds=new DetailServiceImpl();
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		String str=request.getParameter("pid");
		Timestamp createTime=new Timestamp(System.currentTimeMillis());
		if(str!=null&&str!=""){//直接购买
			int id=Integer.parseInt(str);			
			Product p=ps.findById(id);
			String orderId=UUID.randomUUID().toString().replace("-", "");
			Order o=new Order(orderId, u.getId(), u.getName(), address, createTime, p.getPrice(), 0, 1);
			os.addOrder(o);
			int stock=p.getStock()-1;
			ps.updateStock(p.getId(), stock);
			Detail d=new Detail(orderId, p.getId(), 1, p.getPrice());
			ds.addDetail(d);
			request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
		}else{//加入购物车后再购买
			ShopCart sc=(ShopCart)session.getAttribute("cart");
			boolean isEnough=true;
			//1.验证库存
			List<SaleLine> line=sc.getLines();
				for(SaleLine p:line){				
					if(p.getNum()>p.getProduct().getStock()){
						isEnough=false;
						break;
					}
				}
				if(isEnough){
					//2.生成订单单号
					String orderId=UUID.randomUUID().toString().replace("-", "");
					//生成订单					
					double cost=sc.getTotal();
					Order o=new Order(orderId, u.getId(), u.getName(), address, createTime, cost, 0, 1);
					os.addOrder(o);
					//3.减少库存，添加明细
					for(SaleLine p:line){
						int stock=p.getProduct().getStock()-p.getNum();
						int id=p.getProduct().getId();
						ps.updateStock(id, stock);
						Detail d=new Detail(orderId, p.getProduct().getId(), p.getNum(), p.getProduct().getPrice());
						ds.addDetail(d);
					}
					//4.清空购物车
					sc.clear();
					session.setAttribute("cart", null);
					request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
				}else{
					request.setAttribute("meg", "库存不足！");
					request.getRequestDispatcher("shopping.jsp").forward(request, response);
				}
		}	
	}
}
