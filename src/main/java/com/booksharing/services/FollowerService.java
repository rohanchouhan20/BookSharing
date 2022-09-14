package com.booksharing.services;

import org.springframework.stereotype.Component;

import com.booksharing.entity.Followers;

@Component
public interface FollowerService {

	public Followers addFollower(Followers entity);

	public int countFollower(int id);

}
