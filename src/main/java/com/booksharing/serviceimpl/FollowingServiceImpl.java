package com.booksharing.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booksharing.entity.Followers;
import com.booksharing.entity.Following;
import com.booksharing.entity.Requests;
import com.booksharing.entity.User;
import com.booksharing.repository.FollowerRepo;
import com.booksharing.repository.FollowingRepo;
import com.booksharing.repository.RequestsRepo;
import com.booksharing.services.FollowingService;

@Service
public class FollowingServiceImpl implements FollowingService {
	@Autowired
	private FollowingRepo followingRepo;
	
	@Autowired
	private FollowerRepo followerRepo;
	
	@Autowired
	private RequestsRepo requestsRepo;

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
	
	public void unfollow(int id,int loginid) {
		
		
		System.out.println("ID -- "+id); // --3
		System.out.println("LoginId --"+loginid); // --1
		this.followingRepo.deleteByUseridAndFollowing(id, loginid);
		this.followerRepo.deleteByUseridAndFollower(id, loginid);
		Followers follower = this.followerRepo.findByUseridAndFollower(id, loginid);
		System.out.println("Follower ------->"+follower);
		if(follower!=null) {
		Requests requests = new Requests();
		User user = new User();
		user.setId(id);
		requests.setAccepted(true);
		requests.setFollowBack(false);
		requests.setSender(user);
		requests.setReciever(loginid);
		this.requestsRepo.save(requests);
	}else {
		int acceptUser = id;
		int userId = loginid;
		this.requestsRepo.deleteByUserIdAndFollowerId(acceptUser, userId);
		}
	
}
	}
