package com.blog.bean;

import java.sql.Timestamp;

public class User {
private int u_id;
private String u_name;
private byte[] u_pass;
private String u_nickname;
private String u_touxiang;
private String u_problem;
private String u_answer;
private Timestamp createtime;
private boolean is_used ;

public User() {
}

public int getU_id() {
	return u_id;
}

public void setU_id(int u_id) {
	this.u_id = u_id;
}

public String getU_name() {
	return u_name;
}

public void setU_name(String u_name) {
	this.u_name = u_name;
}

public byte[] getU_pass() {
	return u_pass;
}

public void setU_pass(byte[] u_pass) {
	this.u_pass = u_pass;
}

public String getU_nickname() {
	return u_nickname;
}

public void setU_nickname(String u_nickname) {
	this.u_nickname = u_nickname;
}

public String getU_touxiang() {
	return u_touxiang;
}

public void setU_touxiang(String u_touxiang) {
	this.u_touxiang = u_touxiang;
}

public String getU_problem() {
	return u_problem;
}

public void setU_problem(String u_problem) {
	this.u_problem = u_problem;
}

public String getU_answer() {
	return u_answer;
}

public void setU_answer(String u_answer) {
	this.u_answer = u_answer;
}

public Timestamp getCreatetime() {
	return createtime;
}

public void setCreatetime(Timestamp createtime) {
	this.createtime = createtime;
}

public boolean getIs_used() {
	return is_used;
}

public void setIs_used(boolean is_used) {
	this.is_used = is_used;
}






}