package com.booksharing.serviceimpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booksharing.entity.User;
import com.booksharing.repository.UserRepo;
import com.booksharing.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;

	public void addUser(User u, String username) {
		u.setUserName(username);
		u.setValue(true);
		repo.save(u);
	}

	public User userName(User u) {

		return repo.findByEmail(u.getEmail());
	}

	public boolean isPresent(User u) {
		if (repo.findByEmailAndPassword(u.getEmail(), u.getPassword()) != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getVal(User u) {
		u = repo.findByEmail(u.getEmail());
		return u.getValue();
	}

	public void setFalse(User u) {
		u = repo.findByEmail(u.getEmail()); // Getting object of corresponding row
		u.setValue(false); //
		repo.save(u);
	}

	public boolean profileSave(User u, MultipartFile imageFile, String username) throws IOException {
		String profilePhoto = "";
		String name = u.getFullName();
		String email = u.getEmail();
		String book = u.getFavbooks();
		String song = u.getFavsongs();
		String places = u.getFavplaces();

		if (name.isEmpty() || email.isEmpty()) {
			return false;
		}
		if (!imageFile.isEmpty()) {
			profilePhoto = imageFile.getOriginalFilename().trim();
			InputStream is = imageFile.getInputStream();
			String path = "C:\\Users\\DELL\\Desktop\\Spring STS Projects\\FriendBookSharing\\src\\main\\webapp\\image\\"
					+ profilePhoto;
			int bytes = 0;
			FileOutputStream fs = new FileOutputStream(path);
			while ((bytes = is.read()) != -1)
				fs.write(bytes);
			fs.close();
		}

		u = repo.findByUserName(username);

		if (!profilePhoto.isEmpty()) {
			u.setProfilephoto(profilePhoto);
		}
		if (!name.isEmpty()) {
			u.setFullName(name);
		}
		if (!email.isEmpty()) {
			u.setEmail(email);
		}
		u.setFavbooks(book);
		u.setFavsongs(song);
		u.setFavplaces(places);
		repo.save(u);
		return true;
	}

	public void oneTimeProfile(User u, MultipartFile imageFile, String username) throws IOException {
		String profilePhoto = "";
		if (!imageFile.isEmpty()) {
			profilePhoto = imageFile.getOriginalFilename().trim();	
			InputStream is = imageFile.getInputStream();
			String path = "C:\\Users\\DELL\\Desktop\\Spring STS Projects\\FriendBookSharing\\src\\main\\webapp\\image\\"
					+ profilePhoto;
			int bytes = 0;
			FileOutputStream fs = new FileOutputStream(path);
			while ((bytes = is.read()) != -1)
				fs.write(bytes);
			fs.close();
		}
		String book = u.getFavbooks();
		String song = u.getFavsongs();
		String places = u.getFavplaces();

		u = repo.findByUserName(username);

		if (!profilePhoto.isEmpty()) {
			u.setProfilephoto(profilePhoto);
		}
		u.setFavbooks(book);
		u.setFavsongs(song);
		u.setFavplaces(places);
		repo.save(u);

	}

	public String generateUsername(String fullName) {
		Random random = new Random();
		String num = 100 + random.nextInt(899) + "";
		String username = fullName.substring(0, 1).toUpperCase() + fullName.substring(1) + num;
		System.out.println(username);
		return username;
	}

	public User getDetails(String username) {
		return repo.findByUserName(username);
	}

	public String check(User u) {
		Pattern patternPassword = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Z a-z 0-9 \\s_]).{5,20}$");
		Matcher matcherPassword = patternPassword.matcher(u.getPassword());
		if (u.getFullName().equals("") || u.getEmail().equals("") || u.getPassword().equals(""))
			return "blank";
		if (!matcherPassword.find()) {
			return "password";
		}

		return "ok";

	}

	public boolean checkLogin(User u) {
		System.out.println(u);
		if (u.getEmail().equals("") || u.getPassword().equals("")) {
			return false;
		}
		return true;
	}

	public List<User> getAllUser(String name, int id) {
		List<User> userList= repo.findByUserNameContains(name);
		
		List<User> tempList=userList.stream().filter(x->x.getId()!=id).collect(Collectors.toList());
		
//		for(int i=0;i<userList.size();i++) {
//			if(userList.get(i).getId()==id)
//				continue;
//			
//			tempList.add(userList.get(i));
//		}
		return tempList;
	}
}