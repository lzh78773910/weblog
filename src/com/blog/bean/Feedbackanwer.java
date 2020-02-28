package com.blog.bean;

import java.sql.Timestamp;

public class Feedbackanwer {
	private int fa_id;
	private int fa_leixin;
	private int fa_admin;
	private int fa_user;
	private int fa_feedback;
	private String fa_content;
	private Timestamp createtime;
	private boolean is_used ;
	private Adminuser adminuser;
	private User user;
	
	public Adminuser getAdminuser() {
		return adminuser;
	}
	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFa_id() {
		return fa_id;
	}
	public void setFa_id(int fa_id) {
		this.fa_id = fa_id;
	}
	public int getFa_leixin() {
		return fa_leixin;
	}
	public void setFa_leixin(int fa_leixin) {
		this.fa_leixin = fa_leixin;
	}
	public int getFa_admin() {
		return fa_admin;
	}
	public void setFa_admin(int fa_admin) {
		this.fa_admin = fa_admin;
	}
	public int getFa_user() {
		return fa_user;
	}
	public void setFa_user(int fa_user) {
		this.fa_user = fa_user;
	}
	public int getFa_feedback() {
		return fa_feedback;
	}
	public void setFa_feedback(int fa_feedback) {
		this.fa_feedback = fa_feedback;
	}
	public String getFa_content() {
		return fa_content;
	}
	public void setFa_content(String fa_content) {
		this.fa_content = fa_content;
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


}
