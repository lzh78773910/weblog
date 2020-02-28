package com.blog.bean;

import java.sql.Timestamp;

public class Photos {
	private int p_id;
	private String p_title;
	private String p_url;
	private int p_album;
	private int p_author;
	private Timestamp createtime;
	private boolean is_used;
	private Adminuser adminuser;
	private Albums albums;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_url() {
		return p_url;
	}
	public void setP_url(String p_url) {
		this.p_url = p_url;
	}
	public int getP_album() {
		return p_album;
	}
	public void setP_album(int p_album) {
		this.p_album = p_album;
	}
	public int getP_author() {
		return p_author;
	}
	public void setP_author(int p_author) {
		this.p_author = p_author;
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
	public Photos(int p_id, String p_title, String p_url, int p_album,
			int p_author, Timestamp createtime, boolean is_used) {
		this.p_id = p_id;
		this.p_title = p_title;
		this.p_url = p_url;
		this.p_album = p_album;
		this.p_author = p_author;
		this.createtime = createtime;
		this.is_used = is_used;
	}
	public Photos() {
	}
	public Adminuser getAdminuser() {
		return adminuser;
	}
	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}
	public Albums getAlbums() {
		return albums;
	}
	public void setAlbums(Albums albums) {
		this.albums = albums;
	}
}
