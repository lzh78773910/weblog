package com.blog.servlet.user;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.blog.Iservice.IPhotoService;
import com.blog.Iservice.IUserService;
import com.blog.bean.Photos;
import com.blog.bean.User;
import com.blog.service.impl.PhotoService;
import com.blog.service.impl.UserService;

public class UserUpdateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String u_name = (String) session.getAttribute("u_name");
		IUserService iUserService =new UserService();
		
		boolean im = ServletFileUpload.isMultipartContent(request);
		if (im) {// 判断有误mutipart
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				PrintWriter out = response.getWriter();
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
			
				String u_nickname = null;
				int u_id=-1;
				while (iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					// request.getParameter() -- iter.getString()
					if (item.isFormField()) {
						 if (itemName.equals("u_nickname")) {
							u_nickname = item.getString("UTF-8");
							System.out.println("u_nickname=" + u_nickname);
						} else if (itemName.equals("u_id")) {
							u_id = Integer.parseInt(item.getString("UTF-8"));
							System.out.println("u_id=" + u_id);
						}  else {
							System.out.println("其他字段");
						}
					} else {
						User user2 = iUserService.UserByname(u_name);
						String u_touxiang = user2.getU_touxiang();
						
						String name = item.getName();
						String ext = name.substring(name.lastIndexOf(".") + 1);
						// 文件名 //Field普通表单字段 没有Field的是文件字段
						if((u_touxiang==null || "".equals(u_touxiang))){
							name = UUID.randomUUID().toString() + "." + ext;
						}else{
							name = u_touxiang;
						}
						
						System.out.println("ext="+ext);
						
						
						
						if(u_nickname==null || u_nickname.equals("")){
							 out.println("<script>alert('昵称为空，修改失败');location.href='UserObtainUpdateServlet?u_name="+u_name+"'</script>");
							 return;
						}
						
						if(!(item.getName().equals("")||item.getName()==null)){
						if (!  ( (ext.equals("jpg"))||(ext.equals("png")) ) ) {
							System.out.println("格式有误");
							out.println("<script>alert('上传失败,格式有误,只能是jpg或png');location.href='UserObtainUpdateServlet?u_name="+u_name+"'</script>");
						}
						}
						
						String url = request.getSession().getServletContext().getRealPath("css_js/user/touxiang");
						System.out.println(name);
						System.out.println(url);
						
						File file = new File(url, name);
						
					
						User user=new User();
						user.setU_nickname(u_nickname);
						user.setU_touxiang(name);
						user.setU_id(u_id);
						
						 System.out.println(user.getU_touxiang());
						 
						 
						 if( (item.getName().equals("")||item.getName()==null) ){
							 iUserService.useru_nickname(user);
							 out.println("<script>alert('修改成功');location.href='UserObtainUpdateServlet?u_name="+u_name+"'</script>");
						 }else{
						 boolean falg = iUserService.userxinxi(user);
						 
						 if(falg){
							 item.write(file);
							 out.println("<script>alert('修改成功');location.href='UserObtainUpdateServlet?u_name="+u_name+"'</script>");
						 }else{
							 out.println("<script>alert('修改成功');location.href='UserObtainUpdateServlet?u_name="+u_name+"'</script>"); 
						 }
						 }
					}
				}

			} catch (SizeLimitExceededException e) {
				e.printStackTrace();
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
