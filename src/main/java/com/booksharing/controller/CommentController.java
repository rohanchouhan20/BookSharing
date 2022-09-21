package com.booksharing.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.booksharing.entity.Comment;
import com.booksharing.entity.PostEntity;
import com.booksharing.serviceimpl.CommentServiceImpl;
import com.booksharing.serviceimpl.PostServiceImpl;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private PostServiceImpl postServiceImpl;

	@Autowired
	private CommentServiceImpl commentServiceImpl;
	
	
	@GetMapping("/goback")
	public RedirectView goback() {
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl("/user/userProfile");			
		return redirectview;
	}

	@ResponseBody
	@Transactional
	@GetMapping("/addcomment")
	public RedirectView addComment(HttpServletRequest req) {
		RedirectView redirectview = new RedirectView();
		HttpSession session = req.getSession();
		boolean status = this.commentServiceImpl.addComment((int) session.getAttribute("id"),
				Integer.parseInt(req.getParameter("postId")), Integer.parseInt(req.getParameter("commentUser")),
				req.getParameter("comment"));
		if (status) {
			System.out.println("TRUEEEEEEEEE");
		} else {
			System.out.println("FALSEEEEEEEEEEE");
		}
		redirectview.setUrl("/user/homepageview");
		return redirectview;
	}

	@GetMapping("/editComments")
	public ModelAndView postComments(@RequestParam("commentid") int commentid, @RequestParam("comment") String c,
			@RequestParam("postid") int postid, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Comment Comment = commentServiceImpl.editComment(commentid, c);
		PostEntity post = postServiceImpl.getAllComments(postid);
		modelAndView.addObject("Comment", Comment);
		modelAndView.addObject("postComment", post);
		modelAndView.addObject("postid", postid);
		modelAndView.addObject("loginid", (int) session.getAttribute("id"));
		modelAndView.addObject("update", "Comment Updated Successfully");
		modelAndView.setViewName("viewComment");
		return modelAndView;
	}

	@Transactional
	@GetMapping("/deleteComment")
	public ModelAndView deleteComment(@RequestParam("commentid") int commentid, @RequestParam("postid") int postid,
			@RequestParam("val") String val, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if (val.equals("true")) {
			System.out.println("IFFFFFFF");
			commentServiceImpl.deleteUserComment(commentid);
		} else {
			System.out.println("ELSEEEEEE");
			commentServiceImpl.deleteComment(commentid, (int) session.getAttribute("id"));
		}
		modelAndView.addObject("postid", postid);
		modelAndView.addObject("val", val);
		modelAndView.addObject("update", "Comment Deleted Successfully");
		modelAndView.addObject("loginid", (int) session.getAttribute("id"));
		PostEntity post = postServiceImpl.getAllComments(postid);
		modelAndView.addObject("postComment", post);
		modelAndView.setViewName("viewComment");
		return modelAndView;
	}
}
