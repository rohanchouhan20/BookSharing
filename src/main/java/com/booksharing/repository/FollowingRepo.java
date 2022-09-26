package com.booksharing.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksharing.entity.Following;

//@Component
@Repository
public interface FollowingRepo extends CrudRepository<Following, Integer> {

	@Query(value = "select count(*) from following where user_id=:id", nativeQuery = true)
	public int countFollowing(@Param("id") int id);

	@Query(value = "SELECT following FROM following where user_id =:id", nativeQuery = true)
	public List<Integer> getFollowingCount(@Param("id") int id);

	@Query(value = "select * from following where user_id=:id", nativeQuery = true)
	public List<Following> findByUser_id(@Param("id") int id);
	
	@Query(value = "Select * from following where user_id=:id && following=:loginid", nativeQuery = true)
	public Following findByUseridAndFollowing(@Param("id") int id,@Param("loginid") int loginid);

	@Modifying
	@Transactional
	@Query(value = "Delete from following where following=:id && user_id=:loginid", nativeQuery = true)
	public void deleteByUseridAndFollowing(@Param("id") int id,@Param("loginid") int loginid);
}
