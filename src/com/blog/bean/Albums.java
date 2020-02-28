package com.blog.bean;

import java.sql.Timestamp;

public class Albums {
	private int al_id;
	private String al_name;
	private int al_author;
	private Timestamp createtime;
	private boolean is_used ;
	private String  al_url;
	private Adminuser adminuser;
	private int count;
	
	public Albums(int al_id, String al_name, int al_author,
			Timestamp createtime, boolean is_used, Adminuser adminuser) {
		super();
		this.al_id = al_id;
		this.al_name = al_name;
		this.al_author = al_author;
		this.createtime = createtime;
		this.setIs_used(is_used);
		this.adminuser = adminuser;
	}


	public Adminuser getAdminuser() {
		return adminuser;
	}


	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}


	public Albums() {
		super();
	}
	public int getAl_id() {
		return al_id;
	}
	public void setAl_id(int al_id) {
		this.al_id = al_id;
	}
	public String getAl_name() {
		return al_name;
	}
	public void setAl_name(String al_name) {
		this.al_name = al_name;
	}
	public int getAl_author() {
		return al_author;
	}
	public void setAl_author(int al_author) {
		this.al_author = al_author;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getAl_url() {
		return al_url;
	}
	public void setAl_url(String al_url) {
		this.al_url = al_url;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public boolean isIs_used() {
		return is_used;
	}


	public void setIs_used(boolean is_used) {
		this.is_used = is_used;
	}
	
	
	
	
}
