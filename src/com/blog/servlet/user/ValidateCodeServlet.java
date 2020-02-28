package com.blog.servlet.user;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCodeServlet extends HttpServlet {

	public String createValidateCode(){
	    String vcStr="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    Random random=new Random();
	    String validateCode="";
	    for(int i=0;i<4;i++){
	    	int randomNum= random.nextInt(vcStr.length());
	    	validateCode+=vcStr.charAt(randomNum);
	    }
		return validateCode;
	}
	public void drawValidateCode(BufferedImage image, String ValidateCode){
		Graphics g =image.getGraphics();
		g.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		for(int i=0;i<ValidateCode.length();i++)
		{
			String vc=String.valueOf((ValidateCode.charAt(i)));
			Random random=new Random();
			int randomNum=random.nextInt(5);
			g.drawString(vc,10*(i+1)+randomNum,20+randomNum);
		}
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         //获取图片
		 response.setContentType("image/jpeg");
         String path=request.getRealPath("/css_js/"+"yanzengma.jpg");
         File vcFile=new File(path);
         BufferedImage image=ImageIO.read(vcFile);
         
         //获取验证码随机数
         String ValidateCode = createValidateCode();
         
         //画出验证码
         drawValidateCode(image,ValidateCode);
         
         //将图片及验证码输出到网页
         OutputStream out=response.getOutputStream();
         ImageIO.write(image, "jpeg", out);
         out.close();
         
     	HttpSession session = request.getSession();
     	session.setAttribute("ValidateCodesession", ValidateCode);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
