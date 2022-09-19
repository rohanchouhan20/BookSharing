package com.booksharing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booksharing.entity.User;


	@Repository
	public interface UserRepo extends CrudRepository<User, Integer>{
		public User findByEmailAndPassword(String email, String password);
		
		public User findByEmail(String email);
		
		public User findByUserName(String username);
		
		@Query(value = "UPDATE user SET value = '1' where full_name = :e;", nativeQuery = true)
		public User setFalse(@Param("e") String email);
		 
		
		public List<User> findByUserNameContains(String name);
		
	}

