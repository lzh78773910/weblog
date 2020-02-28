package com.blog.bean;

import java.sql.Timestamp;

public class Feedback {
	private int f_id;
	private int f_user;
	private int f_adminuser;
	private String f_content;
	private Timestamp createtime;
	private boolean is_used ;
	private int is_used0 ;//0Î´¶Á1ÒÑ¶Á
	private User user;
	private Adminuser adminuser;
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public int getF_user() {
		return f_user;
	}
	public void setF_user(int f_user) {
		this.f_user = f_user;
	}
	public int getF_adminuser() {
		return f_adminuser;
	}
	public void setF_adminuser(int f_adminuser) {
		this.f_adminuser = f_adminuser;
	}
	public String getF_content() {
		return f_content;
	}
	public void setF_content(String f_content) {
		this.f_content = f_content;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public boolean isIs_used() {
		return is_used;
	}
	public void setIs_used(boolean is_used) {
		this.is_used = is_used;
	}
	public int getIs_used0() {
		return is_used0;
	}
	public void setIs_used0(int is_used0) {
		this.is_used0 = is_used0;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Adminuser getAdminuser() {
		return adminuser;
	}
	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}
}
