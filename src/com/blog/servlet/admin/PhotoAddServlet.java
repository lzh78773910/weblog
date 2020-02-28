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
import com.blog.Iservice.IPhotoService;
import com.blog.bean.Albums;
import com.blog.bean.Photos;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.PhotoService;

public class PhotoAddServlet extends HttpServlet {

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
				String p_title = null;
				int p_albums =-1;
				
				while (iter.hasNext()) {
					FileItem item = iter.next();
					String itemName = item.getFieldName();
					// request.getParameter() -- iter.getString()
					if (item.isFormField()) {
						if (itemName.equals("p_title")) {
							p_title = item.getString("UTF-8");
							System.out.println("al_name=" + p_title);
						}  else if (itemName.equals("p_albums")) {
							p_albums = Integer.parseInt(item.getString("UTF-8"));
							System.out.println("p_albums=" + p_albums);
						}  else {
							System.out.println("其他字段");
						}
					} else {
						// 文件名 //Field普通表单字段 没有Field的是文件字段
						String name = item.getName();
						String ext = name.substring(name.lastIndexOf(".") + 1);
						name = UUID.randomUUID().toString() + "." + ext;
						System.out.println("ext"+ext);
						if(p_title==null||p_title.equals("")){
							 out.println("<script>alert('照片标题为空，上传失败');location.href='AlbumDetailsServlet?al_id="+p_albums+"'</script>");
							 return;
						}
						if (!  ( (ext.equals("jpg"))||(ext.equals("png")) ) ) {
							System.out.println("格式有误");
							out.println("<script>alert('上传失败,没有上传照片或格式有误,只能是jpg或png');location.href='AlbumDetailsServlet?al_id="+p_albums+"'</script>");
							return;
						}
						
						String url = request.getSession().getServletContext().getRealPath("css_js/admin/Albums/photos");
						System.out.println(name);
						System.out.println(url);
						
						File file = new File(url, name);
						
					
						
						 Photos photos =new Photos();
						 photos.setP_title(p_title);
						 photos.setP_url(name);
						 photos.setP_author(a_id);
						 photos.setP_album(p_albums);
						 
						 IPhotoService photoService=new PhotoService();
						 boolean falg = photoService.Photosadd(photos);
						 if(falg){
							 item.write(file);
							 out.println("<script>alert('创建成功');location.href='AlbumDetailsServlet?al_id="+p_albums+"'</script>");
						 }else{
							 out.println("<script>alert('上传失败,相册名已存在');location.href='AlbumDetailsServlet?al_id="+p_albums+"'</script>"); 
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
