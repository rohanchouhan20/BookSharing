package com.booksharing.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.booksharing.entity.Requests;

@Component
public interface RequestsService {
	public String addRequest(int userId, int sesssionUserId);

	public List<Requests> getRequest(int id);

	public int accept(int acceptUser, int userId);

	public boolean saveFollower(int acceptUser, int userId);

}
