package com.booksharing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentid")
	private int id;

	@OneToOne
	@JoinColumn(name = "user")
	private User user;

	@ManyToOne
	private PostEntity postcomments;

	private int loginuserid;

	private String usercomments;

	/*
	 * @Override public String toString() { return "Comment [id=" + id + ", user=" +
	 * user + ", postcomments=" + postcomments + ", loginuserid=" + loginuserid +
	 * ", usercomments=" + usercomments + "]"; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PostEntity getPostcomments() {
		return postcomments;
	}

	public void setPostcomments(PostEntity postcomments) {
		this.postcomments = postcomments;
	}

	public int getLoginuserid() {
		return loginuserid;
	}

	public void setLoginuserid(int loginuserid) {
		this.loginuserid = loginuserid;
	}

	public String getUsercomments() {
		return usercomments;
	}

	public void setUsercomments(String usercomments) {
		this.usercomments = usercomments;
	}

}
