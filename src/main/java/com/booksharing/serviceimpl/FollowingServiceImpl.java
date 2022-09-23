package com.booksharing.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booksharing.entity.Following;
import com.booksharing.repository.FollowingRepo;
import com.booksharing.services.FollowingService;

@Service
public class FollowingServiceImpl implements FollowingService {
	@Autowired
	private FollowingRepo followingRepo;

	@Transactional
	public Following addfollowing(Following entity) {
		return this.followingRepo.save(entity);
	}

	public int countFollowing(int id) {
		return this.followingRepo.countFollowing(id);
	}
	
	public List<Following> followingList(int id){
		return this.followingRepo.findByUser_id(id);
	}
	public void unfollow(int id) {
		followingRepo.deleteById(id);
	}
}
