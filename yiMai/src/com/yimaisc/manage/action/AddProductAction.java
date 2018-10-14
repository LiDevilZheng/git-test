package com.yimaisc.manage.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.yimaisc.entity.Category;
import com.yimaisc.entity.Product;
import com.yimaisc.service.CategoryService;
import com.yimaisc.service.ProductService;
import com.yimaisc.service.impl.CategoryServiceImpl;
import com.yimaisc.service.impl.ProductServiceImpl;

public class AddProductAction extends HttpServlet {

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
		String name="";
		int tid=0;
		String productDetail="";
		String parentId="";
		int productNumber=0;
		double productPrice=0;
		String pic="default.jpg";
		String path=request.getSession().getServletContext().getRealPath("/pic");
    	File file=new File(path);
    	if(!file.exists()){
    		file.mkdir();
    	}
    	boolean isRight=false;
    	List<String> imageType=Arrays.asList("jpg","png","gif","jpeg");    	
    	try{
    		FileItemFactory factory=new DiskFileItemFactory();
	    	ServletFileUpload upload=new ServletFileUpload(factory);
	    	upload.setSizeMax(1024*1024*2);
	    	List<FileItem> li=upload.parseRequest(request);//解析请求
	    	for(FileItem item:li){
	    		if(item.isFormField()){//判断是否为普通字段
	    			if(item.getFieldName().equals("productName")){
	    				name=item.getString("utf-8");//获取值装换成utf-8格式
	    			}else if(item.getFieldName().equals("productDetail")){
	    				productDetail=item.getString("utf-8");
	    			}else if(item.getFieldName().equals("parentId")){
	    				parentId=item.getString("utf-8");
	    			}else if(item.getFieldName().equals("productPrice")){
	    				productPrice=Double.parseDouble(item.getString("utf-8"));
	    			}else if(item.getFieldName().equals("productNumber")){
	    				productNumber=Integer.parseInt(item.getString("utf-8"));
	    			}else if(item.getFieldName().equals("tid")){
	    				tid=Integer.parseInt(item.getString("utf-8"));
	    			}
	    		}else{//上传文件
	    			String fileName=item.getName();//1.获取上传的文件名
	    			if(fileName!=null&&!fileName.equals("")){
	    				//解决兼容问题
		    			pic=new File(fileName).getName();
		    			String type=pic.substring(pic.lastIndexOf(".")+1);//文件后缀名
		    			pic=UUID.randomUUID().toString().replace("-", "")+"."+type;
		    			if(imageType.contains(type)){
		    				//2.获取上传路径
		    				String uploadFile=path+"/"+pic;
		    				//3.上传（写入到服务器磁盘）
		    				item.write(new File(uploadFile));
		    			}	
	    			}
		    		isRight=true;
	    		}
	    	}
	    	if(!isRight){
	    		//request.getRequestDispatcher("addDetail.jsp").forward(request, response);
	    		out.print("<h3>添加失败，文件类型必须是图片</h3>");	
	    	}else{
	    		Product p=new Product();
	    		p.setName(name);
	    		p.setPrice(productPrice);
	    		p.setStock(productNumber);
	    		p.setDescription(productDetail);
	    		int pid=Integer.parseInt(parentId);
	    		p.setPid(pid);
	    		p.setFileName(pic);
	    		p.setDelete(0);
	    		CategoryService cs=new CategoryServiceImpl();
	    		Category c=cs.findById(pid);
	    		p.setCid(c.getParentId());
	    		ProductService ps=new ProductServiceImpl();	
	    		if(tid!=0){
	    			p.setId(tid);
	    			int result=ps.updateById(p);
	    			out.print("<script type='text/javascript'>alert('修改成功!');</script>");
	    		}else{
	    			ps.addProduct(p);
	    			out.print("<script type='text/javascript'>alert('添加成功!');</script>");
	    		}
	    		out.print("<script type='text/javascript'>"
	        			+"location.href='manage-result.jsp'"+"</script>");
	    	}
    	}catch(SizeLimitExceededException e){
    		request.getRequestDispatcher("product-add.jsp").forward(request, response);
    		out.print("<h3>注册失败，文件过大！！</h3>");		
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		out.flush();
		out.close();
	}
}
