package com.blog.util;

import java.util.Random;

public class Demo {


	public static void main(String[] args) {
		//charAt();ȡ�ַ�  nextInt()ȡ�����
    String vcStr="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random=new Random();
    for(int i=0;i<4;i++){
    	int randomNum= random.nextInt(vcStr.length());
    	System.out.print(vcStr.charAt(randomNum));
    	
    }
    

	}

}
