package com.booksharing.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.booksharing.entity.PostEntity;

@Repository
public interface PostRepo extends CrudRepository<PostEntity, Integer> {
	
	@Query(value = "select * from Post where post_user_id=:id", nativeQuery = true)
	public List<PostEntity> findListOfPost(@Param("id") int id);
	
	@Query(value = "SELECT * FROM post where post_user_id=:id", nativeQuery = true)
	public List<PostEntity> getPostEntity(@Param("id") int id);		
	
	@Query(value = "SELECT * FROM post INNER JOIN like_post where post.post_user_id = like_post.login_user_id;", nativeQuery = true)
	public List<PostEntity> getPostData();		
	

}
