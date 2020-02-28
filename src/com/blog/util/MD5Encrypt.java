package com.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class MD5Encrypt {
	public static byte[] encryptByMD5(String password) {
		byte[] randomBytes = new byte[12];
		SecureRandom random =new SecureRandom();
		random.nextBytes(randomBytes);//获取随机值
        //System.out.println("随机值="+Arrays.toString(randomBytes));
    	MessageDigest md=null;
        try {
         //MessageDigest 抽象类 getInstance 静态方法
		  md=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        md.update(randomBytes); 
        md.update(password.getBytes());//对随机值进行加密.getBytes()将字符串转成byte数组
        byte[] passwordBytes = md.digest();
        //System.out.println("加密之后的="+Arrays.toString(passwordBytes));
        byte[] rusultpassword=new byte[randomBytes.length+passwordBytes.length];
        //拷贝数组工具类   
        System.arraycopy(randomBytes, 0, rusultpassword, 0, randomBytes.length);
       // System.out.println("最终数据库的随机数="+Arrays.toString(rusultpassword));
        System.arraycopy(passwordBytes, 0, rusultpassword,randomBytes.length, passwordBytes.length);
      //  System.out.println("最终数据库的密码="+Arrays.toString(rusultpassword));
		return rusultpassword;
	}
	public static boolean validatePassword(String password,byte[] rusultpassword){
		byte[] randomBytes = new byte[12];
		System.arraycopy(rusultpassword, 0, randomBytes, 0, randomBytes.length);
	//	System.out.println("获取的随机值="+Arrays.toString(randomBytes));
		//加密对象
		MessageDigest md=null;
        try {
         //MessageDigest 抽象类 getInstance 静态方法
		  md=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        md.update(randomBytes); 
        md.update(password.getBytes());//对随机值进行加密.getBytes()将字符串转成byte数组
        byte[] passwordBytes = md.digest();
      //  System.out.println("密码校验加密之后的="+Arrays.toString(passwordBytes));
        byte[] randomBytesInDB = new byte[rusultpassword.length-randomBytes.length];
        System.arraycopy(rusultpassword, randomBytes.length, randomBytesInDB, 0, randomBytesInDB.length);
      //  System.out.println("数据库密码校验加密之后的="+Arrays.toString(randomBytesInDB));
        if(Arrays.equals(passwordBytes, randomBytesInDB)){
        	return true;
        }else{
		return false;
        }
	}

	public static void main(String[] args) {
		byte[] encryptByMD5 = MD5Encrypt.encryptByMD5("123");
		boolean validatePassword = MD5Encrypt.validatePassword("123", encryptByMD5);
		System.out.println("密码为"+validatePassword);
	}

}
