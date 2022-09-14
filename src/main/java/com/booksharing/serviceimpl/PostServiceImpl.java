package com.booksharing.serviceimpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booksharing.entity.Following;
import com.booksharing.entity.PostEntity;
import com.booksharing.entity.User;
import com.booksharing.repository.FollowingRepo;
import com.booksharing.repository.PostRepo;
import com.booksharing.repository.UserRepo;
import com.booksharing.services.PostService;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepo postRepo;

	@Autowired
	PostEntity postEntity;

	@Autowired
	User user;

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	private FollowingRepo followingRepo;

	
	private List<String> listConvert(List<List<String>> listOfList) {
		List<String> allPost = new ArrayList<String>();
		
		for (List<String> list:listOfList) {
			for (String string : list) {
				allPost.add(string);			
			}
		}
		return allPost;
	}
	
	public List<String> getFollowingPost(HttpSession session) {
		List<Integer> followingId = followingRepo.getFollowingCount((Integer)session.getAttribute("id")); 
		System.out.println("Following ID list "+followingId);
		List<List<String>> postName = new ArrayList<>();
		 for (int i = 0; i < followingId.size(); i++) {
			 postName.add(postRepo.getPostName(followingId.get(i)));
		 }
		 List<String> postNames= listConvert(postName);
		return postNames;
	}
	
	@Override
	public void postUpload(MultipartFile imageFile, HttpSession session) throws IOException {
		String profilePhoto = "";
		if (!imageFile.isEmpty()) {
			profilePhoto = imageFile.getOriginalFilename().trim();
			InputStream is = imageFile.getInputStream();
			String path = "C:\\Users\\DELL\\Desktop\\Spring STS Projects\\BookSharing\\src\\main\\webapp\\uploadedPosts\\"
					+ profilePhoto;
			int bytes = 0;
			FileOutputStream fs = new FileOutputStream(path);
			while ((bytes = is.read()) != -1)
				fs.write(bytes);
			fs.close();
		}
		int loginUserId = (int) session.getAttribute("id");
		user.setId(loginUserId);
		postEntity.setPostName(profilePhoto);
		postEntity.setPostUserId(user);	
		postRepo.save(postEntity);

	}
	
	public List<PostEntity> listOfPost(int Id){
		List<PostEntity> list =  postRepo.findListOfPost(Id);
		return list;
	}

}
