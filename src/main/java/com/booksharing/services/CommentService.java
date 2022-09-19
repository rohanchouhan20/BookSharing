package com.booksharing.services;

public interface CommentService {

	public boolean addComment(int userId, int commentUser, int postId, String userComment);
}
