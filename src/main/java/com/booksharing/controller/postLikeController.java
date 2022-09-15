package com.booksharing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.booksharing.serviceimpl.PostLikeService;

@Controller
@RequestMapping("/postLike")
public class postLikeController {

	@Autowired
	private PostLikeService postLikeService;

	@ResponseBody
	@GetMapping("/addlike")
	public String addLike(@RequestParam("postid") int postid, @RequestParam("userid") int userid, HttpSession session) {
		System.out.println("POST ID - " + postid);
		System.out.println("User ID - " + userid);
		int id = (Integer) session.getAttribute("id");
		System.out.println("Login User Id - " + id);

		if (postLikeService.addPostLike(postid, userid, id)) {
			return "success";
		} else {
			return "fail";
		}

	}

}
