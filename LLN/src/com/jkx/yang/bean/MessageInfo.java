package com.jkx.yang.bean;

import java.sql.Timestamp;


public class MessageInfo {
	private int id;//信息的id
	private String username;//信息是谁发的
	private String contents;//信息内容
	private Timestamp times;//发信息的时间
	private String commentName;//被评论的用户
	private String titles;//信息标题
	private int messageNum;//帖子数目
	public int getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}
	public String getTitles() {
		return titles;
	}
	public void setTitles(String titles) {
		this.titles = titles;
	}
	public String getCommentName() {
		return commentName;
	}
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getTimes() {
		return times;
	}
	public void setTimes(Timestamp times) {
		this.times = times;
	}
}
