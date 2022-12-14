package com.booksharing.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.booksharing.entity.PostEntity;
import com.booksharing.serviceimpl.PostServiceImpl;


@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostServiceImpl postServiceImpl;

	@GetMapping("/postPage")
	public String postPage() {
		return "postPage";
	}
	@GetMapping("/goback")
	public RedirectView goback() {
		RedirectView redirectview = new RedirectView();
		redirectview.setUrl("/user/homepageview");			
		return redirectview;
	}
	ModelAndView modelAndView = new ModelAndView();
	
	
	@PostMapping("/addPost")
	public ModelAndView addPhotos(@RequestParam("imageFile") MultipartFile imageFile,HttpSession session) throws IOException {
		ModelAndView modelAndView = new ModelAndView();
		boolean val = postServiceImpl.postUpload(imageFile,session);
		if(val) {
		modelAndView.addObject("postAdded", "Post Added Successfully");
		}else {			
			modelAndView.addObject("postAdded", "Error");	
		}
		modelAndView.setViewName("redirect:/user/userProfile");
		return modelAndView;
		
	}
	
	@GetMapping("/postComments")
	public ModelAndView postComments(@RequestParam("postid") int postid,@RequestParam("val") String val,HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		PostEntity post = postServiceImpl.getAllComments(postid);
		System.out.println("Post -> "+post);
		modelAndView.addObject("postComment", post);
		modelAndView.addObject("postid", postid);
		if(val.equals("true")){
		modelAndView.addObject("val", true);}else {modelAndView.addObject("val", false);}
		modelAndView.addObject("loginid", (int)session.getAttribute("id"));
		System.out.println("Inside");
		modelAndView.setViewName("viewComment");
		return modelAndView;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable int id, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		postServiceImpl.postDelete(id);
		modelAndView.setViewName("redirect:/user/userProfile");
		return modelAndView;
	}
	
}
