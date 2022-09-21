package com.booksharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksharing.entity.LikePost;
import com.booksharing.entity.PostEntity;
import com.booksharing.entity.User;

@Repository
public interface PostLikeRepo extends CrudRepository<LikePost, Integer> {

	public LikePost findByLikePostAndUserAndPostUserId(@Param("postId") PostEntity postId,
			@Param("likeUser") User likePost, @Param("realUser") int realUser);

	@Modifying
	@Query(value = "delete from like_post where user_id=:user and like_post_post_id=:post and login_user_id=:loginuserid", nativeQuery = true)
	public int deleteLike(@Param("user") User user, @Param("post") PostEntity post,
			@Param("loginuserid") int loginuserid);
	
	
	@Query(value = "select * from like_post where like_post_post_id=:postid ", nativeQuery = true)
	public List<LikePost> findByPostUserId(@Param("postid") int postid);
}
