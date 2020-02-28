package com.blog.servlet.admin;

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

import com.blog.Iservice.IAlbumsService;
import com.blog.bean.Albums;
import com.blog.service.impl.AlbumsService;


public class AlbumsAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int  a_id = (Integer) session.getAttribute("a_id");
		
		boolean im = ServletFileUpload.isMultipartContent(request);
		if (im) {// 判断有误mutipart
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				PrintWriter out = response.getWriter();
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				String al_name = null;
				String al_url = null;
				while (iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					// request.getParameter() -- iter.getString()
					if (item.isFormField()) {
						if (itemName.equals("al_name")) {
							al_name = item.getString("UTF-8");
							System.out.println("al_name=" + al_name);
						} else if (itemName.equals("al_url")) {
							al_url = item.getString("UTF-8");
							System.out.println("al_url=" + al_url);
						}  else {
							System.out.println("其他字段");
						}
					} else {
						// 文件名 //Field普通表单字段 没有Field的是文件字段
						String name = item.getName();
						String ext = name.substring(name.indexOf(".") + 1);
						name = UUID.randomUUID().toString() + "." + ext;
						System.out.println("ext"+ext);
						if(al_name==null||al_name.equals("")){
							 out.println("<script>alert('相册名为空，创建失败');location.href='/weblog/admin/a_Albumsadd.jsp'</script>");
							 return;
						}
						if (!  ( (ext.equals("jpg"))||(ext.equals("png")) ) ) {
							System.out.println("格式有误");
							out.println("<script>alert('创建失败,没有上传照片或格式有误,只能是jpg或png');location.href='/weblog/admin/a_Albumsadd.jsp'</script>");
							return;
						}
						
						String url = request.getSession().getServletContext().getRealPath("css_js/admin/Albums");
						System.out.println(name);
						System.out.println(url);
						
						File file = new File(url, name);
						
					
						
						 Albums albums=new Albums();
						 albums.setAl_name(al_name);
						 albums.setAl_url(name);
						 albums.setAl_author(a_id);
						 IAlbumsService albumsService=new AlbumsService();
						 boolean albumsAdd = albumsService.albumsAdd(albums);
						 if(albumsAdd){
							 item.write(file);
							 out.println("<script>alert('创建成功');location.href='AlbumServlet'</script>");
						 }else{
							 out.println("<script>alert('上传失败,相册名已存在');location.href='/weblog/admin/a_Albumsadd.jsp'</script>"); 
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
