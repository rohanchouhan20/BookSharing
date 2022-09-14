package com.booksharing.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booksharing.entity.Following;
import com.booksharing.repository.FollowingRepo;
import com.booksharing.services.FollowingService;

@Service
public class FollowingServiceImpl implements FollowingService {
	@Autowired
	private FollowingRepo followingRepo;

	@Autowired
	@Lazy
	private RequestsServiceImpl requestsServiceImpl;

	@Transactional
	public Following addfollowing(@Lazy Following entity) {
		return this.followingRepo.save(entity);
	}

	public int countFollowing(int id) {
		return this.followingRepo.countFollowing(id);
	}

}
