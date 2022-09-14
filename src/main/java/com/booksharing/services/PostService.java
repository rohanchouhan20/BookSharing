package com.booksharing.services;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.booksharing.entity.PostEntity;

import java.util.List;

public interface PostService {

	public void postUpload(MultipartFile imageFile, HttpSession session)throws IOException;
	
	public List<PostEntity> listOfPost(int Id);
}
