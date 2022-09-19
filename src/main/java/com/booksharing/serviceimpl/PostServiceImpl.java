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
	UserRepo userRepo;
	
	@Autowired
	private FollowingRepo followingRepo;

	
	public List<PostEntity> getPost(int id){
		List<PostEntity> postList = postRepo.getPostEntity(id);
		return postList;
	}
	
	private List<PostEntity> listConvert(List<List<PostEntity>> listOfList) {
		List<PostEntity> allPost = new ArrayList<PostEntity>();
		
		for (List<PostEntity> list:listOfList) {
			for (PostEntity string : list) {
				allPost.add(string);			
			}
		}
		return allPost;
	}
	
	public List<PostEntity> getFollowingPost(HttpSession session) {
		List<Integer> followingId = followingRepo.getFollowingCount((Integer)session.getAttribute("id")); 
		System.out.println("Following ID list "+followingId);
		List<List<PostEntity>> postName = new ArrayList<>();
		 for (int i = 0; i < followingId.size(); i++) {
			 postName.add(postRepo.getPostEntity(followingId.get(i)));
		 }
		 List<PostEntity> postNames= listConvert(postName);
		return postNames;
	}
	
	@Override
	public boolean postUpload(MultipartFile imageFile, HttpSession session) throws IOException {
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
		
		int loginUserId = (int) session.getAttribute("id");
		PostEntity postEntity = new PostEntity();
		User user=new User();
		user.setId(loginUserId);
		postEntity.setPostName(profilePhoto);
		postEntity.setPostUserId(user);	
		postRepo.save(postEntity);
		return true;
	}
		return false;
	}
	
	public List<PostEntity> listOfPost(int Id){
		List<PostEntity> list =  postRepo.findListOfPost(Id);
		return list;
	}
	public PostEntity getAllComments(int postid) {

		return postRepo.findById(postid).get();
	}

}
