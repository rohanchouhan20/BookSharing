package com.booksharing.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.booksharing.entity.PostEntity;
import com.booksharing.entity.User;
import com.booksharing.serviceimpl.FollowerServiceImpl;
import com.booksharing.serviceimpl.FollowingServiceImpl;
import com.booksharing.serviceimpl.PostServiceImpl;
import com.booksharing.serviceimpl.UserServiceImpl;

import net.bytebuddy.asm.Advice.This;

@Controller
@RequestMapping("/user")
public class UserController {
	ModelAndView modelAndView= new ModelAndView();
	HttpSession session;
	
	@Autowired
	private UserServiceImpl serviceImpl;
	
	@Autowired
	private FollowingServiceImpl followingServiceImpl;
	
	@Autowired
	private FollowerServiceImpl realFollowerServiceImpl;
	
	@Autowired
	private PostServiceImpl postServiceImpl;
	
	

	public UserController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/homepageview")
	public ModelAndView homepage() {
		List<String> list = postServiceImpl.getFollowingPost(session);
		modelAndView.addObject("postName", list);
		modelAndView.addObject("msgsuccess1", "Welcome to Share your knowledge by Sharing");
		modelAndView.addObject("user", serviceImpl.getDetails((String)session.getAttribute("username")));
		modelAndView.setViewName("homePage");
		return modelAndView;
	}
	@GetMapping("/signuppage")
	public String signup() {
		return "signup";
	}
	
	
	
	@GetMapping("/searchdata")	
	public ModelAndView searchdata(@RequestParam("search") String search) {
		System.out.println("Search -> "+search);
		User in  = serviceImpl.getDetails(search);
		if(in!=null) {
		modelAndView.addObject("user", in);
		modelAndView.addObject("msgsuccess", search);
		modelAndView.setViewName("friendsProfile");
		return modelAndView;
		}
		modelAndView.addObject("user", null);
		modelAndView.addObject("msgsuccess", "No User Found");
		modelAndView.setViewName("friendsProfile");
		return modelAndView;
	}

	@GetMapping("/userProfile")
	public ModelAndView userProfile() {
		modelAndView.setViewName("userProfile");
		modelAndView.addObject("msgsuccess", null);
		modelAndView.addObject("allPost", this.postServiceImpl.listOfPost((Integer)session.getAttribute("id")));
		modelAndView.addObject("user", serviceImpl.getDetails((String)session.getAttribute("username")));
		modelAndView.addObject("followingcount", followingServiceImpl.countFollowing((Integer)session.getAttribute("id")));
		modelAndView.addObject("followerscount", realFollowerServiceImpl.countFollower((Integer)session.getAttribute("id")));
		return modelAndView;
	}

	@GetMapping("/loginpage")
	public String logingoto(HttpSession session) {
		session.invalidate();
		return "login";
	}
	@GetMapping("/onetimeprofile")
	public ModelAndView onetimeprofile() {
		modelAndView.addObject("user", serviceImpl.getDetails((String)session.getAttribute("username")));
		modelAndView.setViewName("onetimeprofile");
		return modelAndView;
	}


	@GetMapping("/profileEdit")
	public ModelAndView profileEdit(HttpSession session) {
		modelAndView.addObject("msgfail", null);
		modelAndView.addObject("user", serviceImpl.getDetails((String)session.getAttribute("username")));
		modelAndView.setViewName("profileEdit");
		return modelAndView;
	}

	@PostMapping("/editProfile")
	public ModelAndView uploadImage(@ModelAttribute User u, @RequestParam("imageFile") MultipartFile imageFile,
			HttpSession session) throws IOException {
		boolean val = serviceImpl.profileSave(u, imageFile ,(String)session.getAttribute("username"));
		if(val) {
		modelAndView.addObject("msgsuccess", "Profile Updated Successfully");
		modelAndView.addObject("user", serviceImpl.getDetails((String)session.getAttribute("username")));
		modelAndView.setViewName("homePage");
		modelAndView.setViewName("userProfile");}
		else {
			modelAndView.addObject("msgfail", "NAME OR EMAIL CAN'T BE NULL");
			modelAndView.setViewName("profileEdit");
		}
		return modelAndView;
	}
	@PostMapping("/onetimeprofile")
	public ModelAndView onetimeprofile(@ModelAttribute User u, @RequestParam("imageFile") MultipartFile imageFile,
			HttpSession session) throws IOException {
		serviceImpl.oneTimeProfile(u, imageFile ,(String)session.getAttribute("username"));
		modelAndView.addObject("msgsuccess1", "Welcome to Share your knowledge by Sharing");
		modelAndView.addObject("user", serviceImpl.getDetails((String)session.getAttribute("username")));
		modelAndView.setViewName("homePage");
		return modelAndView;
	}

	@PostMapping("/signupcheck")
	public ModelAndView login(@ModelAttribute User u) {
		ModelAndView modelAndView = new ModelAndView();
		String  check= serviceImpl.check(u);
		if (check=="ok"){
			if (serviceImpl.isPresent(u)) {
				modelAndView.addObject("msgfail", "User already present");
				modelAndView.setViewName("signup");
			}else {
			String username = serviceImpl.generateUsername(u.getFullName());
			serviceImpl.addUser(u, username);
			modelAndView.addObject("msgsuccess", "Successfully Registered");
			modelAndView.setViewName("login");
			}
		} else if(check=="blank"){
			modelAndView.addObject("msgfail", "Please Enter all the fields");
			modelAndView.setViewName("signup");
		}
	 else if(check=="password"){
		modelAndView.addObject("msgfail", "Please Follow Correct Sequence");
		modelAndView.setViewName("signup");
	}
		return modelAndView;
	}

	@PostMapping("/logincheck")
	public ModelAndView islogin(@ModelAttribute User u,HttpSession session) {
		this.session=session;
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("IN");
		if (serviceImpl.checkLogin(u)) {
			if (serviceImpl.isPresent(u)) {
				User user = serviceImpl.userName(u);
				String username = user.getUserName();
				session.setAttribute("username", username);
				session.setAttribute("id", user.getId());
				boolean val = serviceImpl.getVal(u);
				if (val) {
					serviceImpl.setFalse(u);
					modelAndView.addObject("msgsuccess", "Login Successfully");
					modelAndView.setViewName("onetimeprofile");
				} else {
					modelAndView.addObject("msgsuccess1", "Welcome to Share your knowledge by Sharing");
					modelAndView.addObject("user", serviceImpl.getDetails((String)session.getAttribute("username")));
					modelAndView.setViewName("homePage");
				}
			} else {
				modelAndView.addObject("msgfail", "Invalid credential");
				modelAndView.setViewName("login");
			}
		} else {
			modelAndView.addObject("msgfail", "Please Enter all the Fields");
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
	@ResponseBody
	@GetMapping("/search")
	public List<User> getAllUsers(@RequestParam("name") String name) {
		System.out.println("VALUE : "+name);	
		List<User> users=serviceImpl.getAllUser(name);
		System.out.println(users);
		return users;
	}

	

	
}
