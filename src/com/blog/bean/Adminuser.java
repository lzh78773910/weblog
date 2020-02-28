package com.blog.bean;

import java.sql.Timestamp;
public class Adminuser {
	private int a_id;
	private String a_name;
	private byte[] a_pass;
	private String a_nickname;
	private Timestamp createtime;
	private int is_used ;
	public Adminuser() {
	}
	
	public Adminuser(int a_id, String a_name, byte[] a_pass, String a_nickname) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_pass = a_pass;
		this.a_nickname = a_nickname;
	}

	public Adminuser(String a_name, byte[] a_pass) {
		this.a_name = a_name;
		this.a_pass = a_pass;
	}
	
	public Adminuser(String a_name, byte[] a_pass, String a_nickname) {
		super();
		this.a_name = a_name;
		this.a_pass = a_pass;
		this.a_nickname = a_nickname;
	}
	public Adminuser(int a_id, String a_name, byte[] a_pass, String a_nickname,
			Timestamp createtime, int is_used) {
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_pass = a_pass;
		this.a_nickname = a_nickname;
		this.createtime = createtime;
		this.is_used = is_used;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public byte[] getA_pass() {
		return a_pass;
	}
	public void setA_pass(byte[] a_pass) {
		this.a_pass = a_pass;
	}
	public String getA_nickname() {
		return a_nickname;
	}
	public void setA_nickname(String a_nickname) {
		this.a_nickname = a_nickname;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public int getIs_used() {
		return is_used;
	}
	public void setIs_used(int is_used) {
		this.is_used = is_used;
	}
	
}
