package com.booksharing.repository;

import java.util.List;

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
}
