package com.booksharing.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.booksharing.entity.Requests;
import com.booksharing.serviceimpl.FollowerServiceImpl;
import com.booksharing.serviceimpl.RequestsServiceImpl;

@RestController
@RequestMapping("/request")
public class RequestsController {
	@Autowired
	private RequestsServiceImpl requestsServiceImpl;

	private HttpSession session;

	private int loginUserId;
	@Autowired
	FollowerServiceImpl followerServiceImpl;

	@GetMapping("/followrequest")
	public ModelAndView SendRequest(@RequestParam("userId") int userId, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		this.session = request.getSession();
		this.loginUserId = (int) session.getAttribute("id");
		String state = this.requestsServiceImpl.addRequest(userId, loginUserId);
		if (state.equals("positive"))
			modelAndView.addObject("msgsuccess3", "Request Sent Successfully");
		else if (state.equals("negative"))
			modelAndView.addObject("msgsuccess3", "Error");
			modelAndView.setViewName("friendsProfile");
		return modelAndView;
	}

	@GetMapping("/checkrequest")
	public ModelAndView checkRequest(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		this.session = request.getSession();
		this.loginUserId = (int) session.getAttribute("id");
		List<Requests> listOfRequest = this.requestsServiceImpl.getRequest(loginUserId);
		modelAndView.addObject("listOfRequest", listOfRequest);
		System.out.println(listOfRequest);
		modelAndView.setViewName("requestList");
		return modelAndView;
	}

	@GetMapping("/acceptrequest")
	public ModelAndView acceptRequest(@RequestParam("userId") int userId) {
		ModelAndView modelAndView = new ModelAndView();
		if (this.requestsServiceImpl.accept(loginUserId, userId) > 0)
			modelAndView.addObject("msg1", "Request Accepted");
		else
			modelAndView.addObject("msg1", "Error");
			modelAndView.setViewName("success");
		return modelAndView;
	}

	@GetMapping("/followback")
	public ModelAndView followBack(@RequestParam("userId") int userId) {
		ModelAndView modelAndView = new ModelAndView();
		if (this.requestsServiceImpl.saveFollower(loginUserId, userId))
			modelAndView.addObject("msg1", "Follow-Back Successfully");
			modelAndView.setViewName("success");
		return modelAndView;
	}

	@GetMapping("/declinerequest")
	public ModelAndView declineRequest(@RequestParam("userId") int requestUser) {
		ModelAndView modelAndView = new ModelAndView();
		int value = this.requestsServiceImpl.deleteRequest(loginUserId, requestUser);
		if (value > 0)
			modelAndView.addObject("msg1", "Request Declined");
		else
			modelAndView.addObject("msg1", "Error");
			modelAndView.setViewName("success");
		return modelAndView;
	}

}
