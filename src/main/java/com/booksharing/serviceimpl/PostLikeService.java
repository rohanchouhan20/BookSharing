package com.booksharing.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksharing.entity.LikePost;
import com.booksharing.entity.PostEntity;
import com.booksharing.entity.User;
import com.booksharing.repository.PostLikeRepo;

@Service
public class PostLikeService {

	@Autowired
	private PostLikeRepo postLikeRepo;
	
	public LikePost checkAlreadyLike(PostEntity postId,User user,int id) {
		return this.postLikeRepo.findByLikePostAndUserAndPostUserId(postId,user,id);
	}
	public boolean addPostLike(int postid, int userid, int id){
		PostEntity post=new PostEntity();
		post.setPostId(postid);
		
		User user=new User();
		user.setId(userid);
		
		LikePost like=this.checkAlreadyLike(post,user,id);
		
		if(like==null) {
			like =new LikePost();
			like.setUser(user);
			like.setLikePost(post);	
			like.setLike(true);
			like.setLoginUserId(id);
			if(this.postLikeRepo.save(like)!=null)
				return true;
		}
		return false;
	}
}
