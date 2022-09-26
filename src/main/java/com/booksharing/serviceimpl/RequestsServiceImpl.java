package com.booksharing.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.booksharing.entity.Followers;
import com.booksharing.entity.Following;
import com.booksharing.entity.Requests;
import com.booksharing.entity.User;
import com.booksharing.repository.RequestsRepo;
import com.booksharing.services.RequestsService;

@Service
public class RequestsServiceImpl implements RequestsService {
	@Autowired
	private RequestsRepo requestsRepo;

	@Autowired
	private FollowingServiceImpl followingServiceImpl;

	@Autowired
	private FollowerServiceImpl followerServiceImpl;

//	public List<Requests> getRequests(int id){
//		return null;
//		
//	}

	public String addRequest(int userId, int loginUserId) {
		Requests requests = new Requests();
		User userObj = new User();
		userObj.setId(loginUserId);
		requests.setSender(userObj);
		requests.setReciever(userId);
		requests.setAccepted(false);
		requests.setFollowBack(false);
		if (this.requestsRepo.save(requests).equals(null))
			return "negative";
		else
			return "positive";
	}

	public List<Requests> getRequest(int id) {
		boolean accept = false;
		boolean follow = false;

		return this.requestsRepo.findByUserIdAndAccept(id, accept, follow);
	}

	public List<Requests> getSenderRequest(int id) {
		boolean accept = false;
		boolean follow = false;

		return this.requestsRepo.findByUserSenderId(id, accept, follow);
	}

	@Transactional
	public int deleteRequest(int acceptUser, int userId) {
		return this.requestsRepo.deleteByUserIdAndFollowerId(acceptUser, userId);
	}

	@Transactional
	public int declineRequest(int userId) {
		return this.requestsRepo.deleteRequest(userId);
	}

	@Transactional
	public int accept(int loginUserId, int userId) {
		Followers followers = new Followers();
		Following following = new Following();
		User user = new User();
		boolean accepted = true;
		int val = this.requestsRepo.updateAcceptRequest(accepted, loginUserId, userId);
		if (val > 0) {
			Requests requests = this.requestsRepo.findByUserIdAndAcceptAndSendUser(userId, loginUserId);
			if (requests.isAccepted() && requests.getFollowBack()) { // For deleting request if user accepted and follow
																		// back
				this.requestsRepo.deleteByUserIdAndFollowerId(loginUserId, userId);
			}
			user.setId(userId);
			followers.setFollower(user);
			followers.setUser_id(loginUserId);

			User userObj = new User();
			userObj.setId(loginUserId);

			following.setFollowing(userObj);
			following.setUser_id(userId);

			if (this.followingServiceImpl.addfollowing(following) != null
					&& this.followerServiceImpl.addFollower(followers) != null)
				return 1;
		}
		return 0;
	}	

	@Transactional(rollbackFor = Exception.class)
	public boolean saveFollower(int loginUserId, int userId) throws Exception {
		
		System.out.println("Login Id --"+loginUserId);
		System.out.println("userId --"+userId);
		try {
			if (this.requestsRepo.deleteByUserIdAndFollowerId(loginUserId, userId)> 0) {

				Requests requests = new Requests();
				User user = new User();
				user.setId(loginUserId);

				requests.setSender(user);
				requests.setReciever(userId);
				requests.setAccepted(false);
				requests.setFollowBack(true);

				if (this.requestsRepo.save(requests) != null)
					return true;
			}
		} catch (Exception e) {
			throw new Exception("Exception occur");
		}
		return false;
	}
}
