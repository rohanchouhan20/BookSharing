package com.booksharing.dto;

import java.util.List;

import com.booksharing.entity.Requests;
import com.booksharing.entity.User;

public class ListDto {

	public List<Requests> getRequests;
	
	public List<User> user;

	public List<Requests> getGetRequests() {
		return getRequests;
	}

	public void setGetRequests(List<Requests> getRequests) {
		this.getRequests = getRequests;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
}
