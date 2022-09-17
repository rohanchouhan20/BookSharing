package com.booksharing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booksharing.serviceimpl.PostLikeService;

@RestController
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
	

	@GetMapping("/dislike")
	public String dislike(@RequestParam("postid") int postid,@RequestParam("userid") int userid,HttpSession session) {
		int loginuserid = (int)session.getAttribute("id");
		System.out.println("User ID - " + userid);
		System.out.println("POST ID - " + postid);
		System.out.println("LOGIN User ID - " + loginuserid);
		if(this.postLikeService.delete(userid,loginuserid,postid)>0) {
			
			System.out.println("TRUE");
			session.setAttribute("succMsg", "Dislike.....");}
		else {
			System.out.println("FALSE");
			session.setAttribute("failMsg", "Something went wrong.....");
		}
		return "success";
	}

}
