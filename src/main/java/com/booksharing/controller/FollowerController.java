package com.booksharing.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.booksharing.entity.Followers;
import com.booksharing.serviceimpl.FollowerServiceImpl;

@RestController
@RequestMapping("/follower")
public class FollowerController {
	
	
	@Autowired
	public FollowerServiceImpl followerServiceImpl;
	
	@RequestMapping("/followerList")
	public ModelAndView followersList(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		int id = (int)session.getAttribute("id");
		List<Followers> listOfFollowers= followerServiceImpl.followersList(id);
		modelAndView.addObject("listOfFollowers", listOfFollowers);
		modelAndView.setViewName("followers");
		return modelAndView;
	}
	
	@GetMapping("/goback")
	public RedirectView goback() {
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl("/user/userProfile");			
		return redirectview;
	}
}
