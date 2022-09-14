package com.booksharing.services;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.booksharing.entity.User;

@Component
public interface UserService {

	public void addUser(User u, String username);

	public User userName(User u);

	public boolean isPresent(User u);

	public boolean getVal(User u);

	public void setFalse(User u);

	public boolean profileSave(User u, MultipartFile imageFile, String username) throws IOException;

	public void oneTimeProfile(User u, MultipartFile imageFile, String username) throws IOException;

	public String generateUsername(String fullName);

	public User getDetails(String username);

	public String check(User u);

	public boolean checkLogin(User u);

	public List<User> getAllUser(String name);

}
