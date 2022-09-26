package com.booksharing.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksharing.entity.Followers;
import com.booksharing.entity.Following;
import com.booksharing.entity.Requests;
import com.booksharing.entity.User;
import com.booksharing.repository.FollowerRepo;
import com.booksharing.repository.FollowingRepo;
import com.booksharing.repository.RequestsRepo;
import com.booksharing.services.FollowerService;

@Service
public class FollowerServiceImpl implements FollowerService {
	@Autowired
	private FollowerRepo followerRepo;
	@Autowired
	private FollowingRepo followingRepo;
	@Autowired
	private RequestsRepo requestsRepo;

	public Followers addFollower(Followers entity) {
		return this.followerRepo.save(entity);
	}

	public List<Followers> followersList(int id){
		return this.followerRepo.findByUser_id(id);
	}
	
	
	public int countFollower(int id) {
		return this.followerRepo.countFollower(id);
	}
	
	
	public void unfollow(int loginid,int id ) {
		System.out.println("ID -- "+id); // --3
		System.out.println("LoginId --"+loginid); ///--1
		this.followerRepo.deleteByUseridAndFollower(id, loginid);
		this.followingRepo.deleteByUseridAndFollowing(id, loginid);
		int acceptUser = id;
		int userId = loginid;
		System.out.println("AcceptUserId----->"+acceptUser);
		System.out.println("UserId----->"+userId);
		Following following = followingRepo.findByUseridAndFollowing(id, loginid);
		System.out.println("Following ------->"+following);
		if(following!=null) {
			Requests requests = new Requests();
			User user = new User();
			user.setId(id);
			requests.setAccepted(true);
			requests.setFollowBack(false);
			requests.setSender(user);
			requests.setReciever(loginid);
			this.requestsRepo.save(requests);
		}else {
		this.requestsRepo.deleteByUserIdAndFollowerId(acceptUser, userId);
		}
			
	}

}
