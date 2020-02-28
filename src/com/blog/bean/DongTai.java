package com.blog.bean;

import java.sql.Timestamp;

public class DongTai {
  private int d_id;
  private String d_title;
  private String d_content;
  private int d_author;
  private Timestamp createtime;
  private boolean  is_used;
  private int d_liulang;
  private Adminuser adminuser;


public DongTai(String d_title, String d_content, int d_author) {
	super();
	this.d_title = d_title;
	this.d_content = d_content;
	this.d_author = d_author;
}

public DongTai() {
}

public DongTai(int d_id, String d_title, String d_content) {
	super();
	this.d_id = d_id;
	this.d_title = d_title;
	this.d_content = d_content;
}

public DongTai(int d_id, String d_title, String d_content, int author,
		Timestamp createtime, boolean is_used) {
	this.d_id = d_id;
	this.d_title = d_title;
	this.d_content = d_content;
	this.d_author = author;
	this.createtime = createtime;
	this.is_used = is_used;
}

public int getD_id() {
	return d_id;
}
public void setD_id(int d_id) {
	this.d_id = d_id;
}
public String getD_title() {
	return d_title;
}
public void setD_title(String d_title) {
	this.d_title = d_title;
}
public String getD_content() {
	return d_content;
}
public void setD_content(String d_content) {
	this.d_content = d_content;
}



public int getD_author() {
	return d_author;
}
public void setD_author(int d_author) {
	this.d_author = d_author;
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

public Adminuser getAdminuser() {
	return adminuser;
}

public void setAdminuser(Adminuser adminuser) {
	this.adminuser = adminuser;
}

public int getD_liulang() {
	return d_liulang;
}

public void setD_liulang(int d_liulang) {
	this.d_liulang = d_liulang;
}

  
}
