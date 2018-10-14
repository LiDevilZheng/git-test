package com.yimaisc.action;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.GlyphView.GlyphPainter;

public class AuthImg extends HttpServlet {
	private final String FLAG="0123456789";
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
		response.setContentType("image/jpeg");
		int width=100;
		int height=50;
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, width-2, height-2);
		Random r=new Random(System.currentTimeMillis());
		String auth="";
		for(int i=0;i<4;i++){
			int index=r.nextInt(FLAG.length());
			String str=FLAG.charAt(index)+"";
			auth+=str;
		}
		//System.out.println(auth);
		request.getSession().setAttribute("auth", auth);
		g.setColor(Color.RED);
		g.setFont(new Font("黑体",Font.BOLD,30));
		g.drawString(auth, 20, 35);
		g.setColor(Color.BLACK);
		g.drawLine(0, 0, 80, 20);
		g.dispose();	
		ImageIO.write(image, "JPEG", response.getOutputStream());
	
	}
}
