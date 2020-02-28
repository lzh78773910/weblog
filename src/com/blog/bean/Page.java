package com.blog.bean;

import java.util.List;

//分页帮助�?
public class Page {
	// 当前�? currentPage
	private int currentPage;
	// 页面大小 pageSize
	private int pageSize;

	// 总数�?totalCount
	private int totalCount;
	// 总页�? totalPage
	private int totalPage;

	// 当前页的数据集合 students
	private List<DongTai> dongtai;

	private List<PingLun> pinglun;
	private List<Feedbackanwer> feedbackanwer;
	private List<Albums> albums;
	private List<User> user;
	private List<Feedback> feedback;
	private List<Photos> photos;

	public List<Feedbackanwer> getFeedbackanwer() {
		return feedbackanwer;
	}

	public void setFeedbackanwer(List<Feedbackanwer> feedbackanwer) {
		this.feedbackanwer = feedbackanwer;
	}

	public List<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

	public Page() {
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public List<DongTai> getDongtai() {
		return dongtai;
	}

	public void setDongtai(List<DongTai> dongtai) {
		this.dongtai = dongtai;
	}

	public List<PingLun> getPinglun() {
		return pinglun;
	}

	public void setPinglun(List<PingLun> pinglun) {
		this.pinglun = pinglun;
	}

	public List<Albums> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Albums> albums) {
		this.albums = albums;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public List<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}

}
