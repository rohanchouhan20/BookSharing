package com.booksharing.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksharing.entity.LikePost;
import com.booksharing.entity.PostEntity;
import com.booksharing.entity.User;



@Repository
public interface PostLikeRepo extends CrudRepository<LikePost, Integer>{

	public LikePost findByLikePostAndUserAndPostUserId(@Param("postId") PostEntity postId,@Param("likeUser") User likePost,@Param("realUser") int realUser);
}
