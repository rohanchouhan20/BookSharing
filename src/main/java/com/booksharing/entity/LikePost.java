package com.booksharing.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LikePost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "postId")
	private int postId;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToOne
	private User user;

	@Column(name = "isLike")
	private boolean isLike;

//	@Column(name = "postUserId")
	private int postUserId;

//	@Column(name = "loginUserId")
	private int loginUserId;

	@ManyToOne
	private PostEntity likePost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LikePost [id=" + id + ", postId=" + postId + ", isLike=" + isLike + ", postUserId=" + postUserId
				+ ", loginUserId=" + loginUserId + ", likePost=" + likePost + "]";
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

	public int getPostUserId() {
		return postUserId;
	}

	public void setPostUserId(int postUserId) {
		this.postUserId = postUserId;
	}

	public int getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(int loginUserId) {
		this.loginUserId = loginUserId;
	}

	public PostEntity getLikePost() {
		return likePost;
	}

	public void setLikePost(PostEntity likePost) {
		this.likePost = likePost;
	}

	

}
