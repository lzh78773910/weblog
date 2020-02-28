package com.blog.bean;

import java.sql.Timestamp;
import java.util.List;

public class PingLun {
  private int pl_id;
  private String pl_content;
  private int pl_author;
  private int pl_dongtai;
  private Timestamp createtime;
  private boolean  is_used;
  private User user;
  private DongTai dongtai;
  
public PingLun() {
	super();
}
public int getPl_id() {
	return pl_id;
}
public void setPl_id(int pl_id) {
	this.pl_id = pl_id;
}
public String getPl_content() {
	return pl_content;
}
public void setPl_content(String pl_content) {
	this.pl_content = pl_content;
}
public int getPl_author() {
	return pl_author;
}
public void setPl_author(int pl_author) {
	this.pl_author = pl_author;
}
public int getPl_dongtai() {
	return pl_dongtai;
}
public void setPl_dongtai(int pl_dongtai) {
	this.pl_dongtai = pl_dongtai;
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
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public DongTai getDongtai() {
	return dongtai;
}
public void setDongtai(DongTai dongtai) {
	this.dongtai = dongtai;
}


}
