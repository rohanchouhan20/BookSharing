package com.booksharing.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.booksharing.entity.Following;
import com.booksharing.serviceimpl.FollowingServiceImpl;

@RestController
@RequestMapping("/following")
public class FollowingController {

	@Autowired
	public FollowingServiceImpl followingServiceImpl;

	@RequestMapping("/followingList")
	public ModelAndView followersList(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		int id = (int) session.getAttribute("id");
		List<Following> listOfFollowing = followingServiceImpl.followingList(id);
		modelAndView.addObject("listOfFollowing", listOfFollowing);
		modelAndView.setViewName("followings");
		return modelAndView;
	}

	@GetMapping("/goback")
	public RedirectView goback() {
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl("/user/userProfile");
		return redirectview;
	}
}
