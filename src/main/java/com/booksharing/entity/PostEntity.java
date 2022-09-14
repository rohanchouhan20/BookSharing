package com.booksharing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Post")
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postId")
	private int postId;
	
	@OneToOne
	@JoinColumn(name = "postUserId")
	private User postUserId;
	
	
	@Column(name = "postName")
	private String postName;


	public int getPostId() {
		return postId;
	}


	public PostEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public User getPostUserId() {
		return postUserId;
	}


	public void setPostUserId(User postUserId) {
		this.postUserId = postUserId;
	}


	public String getPostName() {
		return postName;
	}


	public void setPostName(String postName) {
		this.postName = postName;
	}


	public PostEntity(int postId, User postUserId, String postName) {
		super();
		this.postId = postId;
		this.postUserId = postUserId;
		this.postName = postName;
	}


	@Override
	public String toString() {
		return "PostEntity [postId=" + postId + ", postUserId=" + postUserId + ", postName=" + postName + "]";
	}
	
	
}
