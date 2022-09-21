package com.booksharing.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksharing.entity.LikePost;
import com.booksharing.entity.PostEntity;
import com.booksharing.entity.User;
import com.booksharing.repository.PostLikeRepo;

@Service
@Transactional
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
		user.setId(id);
		
		LikePost like=this.checkAlreadyLike(post,user,id);
		System.out.println("Rohan");
		
		if(like==null) {
			like =new LikePost();
			like.setUser(user);
			like.setLikePost(post);	
			like.setLike(true);
			like.setLoginUserId(userid);
			if(this.postLikeRepo.save(like)!=null)
				System.out.println("ADDED");
				return true;
		}
		return false;
	}

	@Transactional()
	public int delete(int userid,int loginuserid,int postid){
		PostEntity post=new PostEntity();
		post.setPostId(postid);
		User user=new User();
		user.setId(loginuserid);
		System.out.println("Post"+post);
		System.out.println("User"+user);
		if(this.postLikeRepo.deleteLike(user,post,userid)>0) {
			return 1;
		}
		return 0;
	}

	public LikePost getAllLikes(int postid) {
			return postLikeRepo.findById(postid).get();
		}
	}
	
