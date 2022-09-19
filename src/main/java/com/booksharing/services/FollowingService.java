package com.booksharing.services;

import org.springframework.stereotype.Component;

import com.booksharing.entity.Following;

@Component
public interface FollowingService {
	public Following addfollowing(Following entity);

	public int countFollowing(int id);
	
	

}
