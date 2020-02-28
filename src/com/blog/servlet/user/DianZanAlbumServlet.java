package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.blog.Iservice.IAlbumsService;
import com.blog.Iservice.IDianZanService;
import com.blog.bean.DianZan;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.DianZanService;

public class DianZanAlbumServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject jsonObject =null;
		PrintWriter out = response.getWriter();
		int u_id =  Integer.parseInt(request.getParameter("u_id"));
		int dz_album = Integer.parseInt(request.getParameter("al_id"));
		
		DianZan dianzan =new DianZan();
		dianzan.setDz_album(dz_album);
		dianzan.setDz_user(u_id);
		

		IDianZanService iDianZanService=new DianZanService();
		boolean falg = iDianZanService.isdianzan(dianzan);
		
		
		DianZan dianzan2 = iDianZanService.dianzan(u_id, dz_album);
	    boolean is_used = dianzan2.isIs_used();
		IAlbumsService albumsService=new AlbumsService();
		int dianzancount = albumsService.getTotalCountBydianzan(dz_album);
		if(falg){
			jsonObject = new JSONObject("{flag:true,count:"+dianzancount+",is_used:"+is_used+"}");
		}else{
			jsonObject = new JSONObject("{flag:false,count:"+dianzancount+",is_used:"+is_used+"}");
		}
		out.print(jsonObject);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
