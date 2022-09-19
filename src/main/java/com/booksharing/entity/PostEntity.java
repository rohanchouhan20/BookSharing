package com.booksharing.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Post")
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "postId")
	private int postId;

	@OneToOne()
	@JoinColumn(name = "postUserId")
	private User postUserId;

	@Column(name = "postName")
	private String postName;

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy = "likePost", cascade = CascadeType.ALL)
	private List<LikePost> likes;

	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@OneToMany(mappedBy = "postcomments", cascade = CascadeType.ALL)
	private List<Comment> comment;

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

	public List<LikePost> getLikes() {
		return likes;
	}

	public void setLikes(List<LikePost> likes) {
		this.likes = likes;
	}

	public User getPostUserId() {
		return postUserId;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
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
		return "PostEntity [postId=" + postId + ", postUserId=" + postUserId + ", postName=" + postName + ", likes="
				+ likes + ", comment=" + comment + "]";
	}

}
