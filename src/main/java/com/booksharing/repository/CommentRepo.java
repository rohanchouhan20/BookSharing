package com.booksharing.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.booksharing.entity.Comment;
import com.booksharing.entity.User;

public interface CommentRepo extends CrudRepository<Comment, Integer> {

	
	@Transactional
	@Modifying
	@Query(value = "Delete from comment where commentid=:id and user=:userid", nativeQuery = true)
	public void deleteComment(@Param("id") int id,@Param("userid") User userid);
	@Transactional
	@Modifying
	@Query(value = "Delete from comment where commentid=:comment", nativeQuery = true)
	public void deleteUserComment(@Param("comment") Comment comment);
}
