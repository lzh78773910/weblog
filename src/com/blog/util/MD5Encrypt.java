package com.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class MD5Encrypt {
	public static byte[] encryptByMD5(String password) {
		byte[] randomBytes = new byte[12];
		SecureRandom random =new SecureRandom();
		random.nextBytes(randomBytes);//��ȡ���ֵ
        //System.out.println("���ֵ="+Arrays.toString(randomBytes));
    	MessageDigest md=null;
        try {
         //MessageDigest ������ getInstance ��̬����
		  md=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        md.update(randomBytes); 
        md.update(password.getBytes());//�����ֵ���м���.getBytes()���ַ���ת��byte����
        byte[] passwordBytes = md.digest();
        //System.out.println("����֮���="+Arrays.toString(passwordBytes));
        byte[] rusultpassword=new byte[randomBytes.length+passwordBytes.length];
        //�������鹤����   
        System.arraycopy(randomBytes, 0, rusultpassword, 0, randomBytes.length);
       // System.out.println("�������ݿ�������="+Arrays.toString(rusultpassword));
        System.arraycopy(passwordBytes, 0, rusultpassword,randomBytes.length, passwordBytes.length);
      //  System.out.println("�������ݿ������="+Arrays.toString(rusultpassword));
		return rusultpassword;
	}
	public static boolean validatePassword(String password,byte[] rusultpassword){
		byte[] randomBytes = new byte[12];
		System.arraycopy(rusultpassword, 0, randomBytes, 0, randomBytes.length);
	//	System.out.println("��ȡ�����ֵ="+Arrays.toString(randomBytes));
		//���ܶ���
		MessageDigest md=null;
        try {
         //MessageDigest ������ getInstance ��̬����
		  md=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        md.update(randomBytes); 
        md.update(password.getBytes());//�����ֵ���м���.getBytes()���ַ���ת��byte����
        byte[] passwordBytes = md.digest();
      //  System.out.println("����У�����֮���="+Arrays.toString(passwordBytes));
        byte[] randomBytesInDB = new byte[rusultpassword.length-randomBytes.length];
        System.arraycopy(rusultpassword, randomBytes.length, randomBytesInDB, 0, randomBytesInDB.length);
      //  System.out.println("���ݿ�����У�����֮���="+Arrays.toString(randomBytesInDB));
        if(Arrays.equals(passwordBytes, randomBytesInDB)){
        	return true;
        }else{
		return false;
        }
	}

	public static void main(String[] args) {
		byte[] encryptByMD5 = MD5Encrypt.encryptByMD5("123");
		boolean validatePassword = MD5Encrypt.validatePassword("123", encryptByMD5);
		System.out.println("����Ϊ"+validatePassword);
	}

}
