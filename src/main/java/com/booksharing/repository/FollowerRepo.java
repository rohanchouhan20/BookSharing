package com.booksharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksharing.entity.Followers;

//@Component
@Repository
public interface FollowerRepo extends CrudRepository<Followers, Integer> {
	@Query(value = "select count(*) from followers where user_id=:id", nativeQuery = true)
	public int countFollower(@Param("id") int id);
	
	@Query(value = "select * from followers where user_id=:id", nativeQuery = true)
	public List<Followers> findByUser_id(@Param("id") int id);

}
