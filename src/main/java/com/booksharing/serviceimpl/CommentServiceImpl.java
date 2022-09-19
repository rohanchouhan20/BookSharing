package com.booksharing.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksharing.entity.Comment;
import com.booksharing.entity.PostEntity;
import com.booksharing.entity.User;
import com.booksharing.repository.CommentRepo;
import com.booksharing.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepo commentRepo;

	public boolean addComment(int userId, int commentUser, int postId, String userComment) {
		System.out.println("INSIDE");
		if (userComment.trim().length() == 0)
			return false;
		User user = new User();
		user.setId(userId);

		System.out.println("INSIDE USERID");
		PostEntity post = new PostEntity();
		post.setPostId(postId);
		Comment comment = new Comment();
		comment.setPostcomments(post);
		comment.setUser(user);
		comment.setLoginuserid(commentUser);
		comment.setUsercomments(userComment);
		System.out.println("INSIDE PostID" + comment);
		if (this.commentRepo.save(comment) != null) {
			System.out.println("SUCCESS");
			return true;
		}
		System.out.println("FAIL");
		return false;
	}
}
