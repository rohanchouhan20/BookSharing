package com.booksharing.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.booksharing.repository.PostRepo;
import com.booksharing.serviceimpl.PostServiceImpl;
import com.booksharing.serviceimpl.UserServiceImpl;


@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostServiceImpl postServiceImpl;
	
	@Autowired
	private UserServiceImpl serviceImpl;
	
	@Autowired
	private PostRepo postRepo;

	@GetMapping("/postPage")
	public String postPage() {
		return "postPage";
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
	
	
}
