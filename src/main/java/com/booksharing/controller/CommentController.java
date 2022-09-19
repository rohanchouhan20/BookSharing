package com.booksharing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.booksharing.serviceimpl.CommentServiceImpl;

@RestController
@RequestMapping("/comment")
public class CommentController {

	
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	
	@ResponseBody
	@Transactional
	@GetMapping("/addcomment")
	public RedirectView addComment(HttpServletRequest req) {
		RedirectView redirectview=new RedirectView();
		HttpSession session=req.getSession();
		boolean status=this.commentServiceImpl.addComment((int)session.getAttribute("id"),Integer.parseInt(req.getParameter("postId")),Integer.parseInt(req.getParameter("commentUser")),req.getParameter("comment"));
		if(status) {
			System.out.println("TRUEEEEEEEEE");
		}
		else {
			System.out.println("FALSEEEEEEEEEEE");
		}
		redirectview.setUrl("/user/homepageview");
		return redirectview;
	}
}
