package com.booksharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksharing.entity.User;


//@Component
	@Repository
	public interface UserRepo extends CrudRepository<User, Integer>{
		public User findByEmailAndPassword(String email, String password);
		
		public User findByEmail(String email);
		
		public User findByUserName(String username);
		
		@Query(value = "UPDATE user SET value = '1' where full_name = :e;", nativeQuery = true)
		public User setFalse(@Param("e") String email);
		
		
//		  @Query(value="select * from user where full_name like %:name%",nativeQuery =
//		  true) public List<User> findByName(@Param("name") String name);
		 
		
		public List<User> findByUserNameContains(String name);
		
	}

