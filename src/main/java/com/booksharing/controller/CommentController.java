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
		RedirectView md=new RedirectView();
		HttpSession session=req.getSession();
//		System.out.println("POST ID - "+Integer.parseInt(req.getParameter("postId")));
//		System.out.println("COMMENT USER - "+Integer.parseInt(req.getParameter("commentUser")));
//		System.out.println("COMMENT - "+req.getParameter("comment"));
//		System.out.println("CURRENT ID - "+(int)session.getAttribute("id"));
		//add comment
		boolean status=this.commentServiceImpl.addComment((int)session.getAttribute("id"),Integer.parseInt(req.getParameter("postId")),Integer.parseInt(req.getParameter("commentUser")),req.getParameter("comment"));
		if(status) {
//			session.setAttribute("succMsg","comment added..");
			System.out.println("TRUEEEEEEEEE");
		}
		else {
			System.out.println("FALSEEEEEEEEEEE");
//			session.setAttribute("failMsg","Please Add Proper Comment.");
		}
		md.setUrl("/user/homepageview");
		return md;
	}
}
