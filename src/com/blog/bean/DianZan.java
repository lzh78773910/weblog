package com.blog.bean;

import java.sql.Timestamp;

public class DianZan {
	public int getDz_id() {
		return dz_id;
	}
	public void setDz_id(int dz_id) {
		this.dz_id = dz_id;
	}
	public int getDz_user() {
		return dz_user;
	}
	public void setDz_user(int dz_user) {
		this.dz_user = dz_user;
	}
	public int getDz_album() {
		return dz_album;
	}
	public void setDz_album(int dz_album) {
		this.dz_album = dz_album;
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
	public Albums getAlbums() {
		return albums;
	}
	public void setAlbums(Albums albums) {
		this.albums = albums;
	}
	private int dz_id;
	private int dz_user;
	private int dz_album;
	private Timestamp createtime;
	private boolean is_used;
	private Albums albums;
}
