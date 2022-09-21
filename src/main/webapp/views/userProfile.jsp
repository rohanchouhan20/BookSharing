<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/cssedit.css">
<meta charset="ISO-8859-1">
<title>User Profile Page</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

	<%@ include file="nav.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<c:if test="${msgsuccess!=null}">
					<div class="text-center alert alert-success" role="alert">${msgsuccess}</div>
				</c:if>
				<c:if test="${postAdded!=null}">
					<div class="alert alert-success" role="alert">${postAdded}</div>
				</c:if>
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-info">Your Profile</h4>

						<form action="/editProfile" method="POST"
							enctype="multipart/form-data">
							<div class="text-center">
								<c:if test="${user.getProfilephoto()!=null}">
									<img height="100" width="100" style="border-radius: 100px"
										src="../image/${user.getProfilephoto()}" />
								</c:if>
								<c:if test="${user.getProfilephoto()==null}">
									<img height="100" width="100" style="border-radius: 100px"
										src="../image/Default.png" />
								</c:if>
							</div>
							<div class="text-center">
								<h5>${user.getUserName()}</h5>
							</div>
							<div class="text-center">
								<ul class="navbar-nav mr-auto">
									<li class="nav-item active"><a class="nav-link"
										href="/user/profileEdit">
											<h5 class="btn btn-outline-success my-2 my-sm-0">Edit
												Profile</h5> </span>
									</a></li>
								</ul>
							</div>

						</form>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<h5>${followerscount}</h5>
					</div>
					<div class="col-md-4">
						<h5>${followingcount}</h5>
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<!-- <h5>Followers</h5> -->
						<h5>
							<a href="/follower/followerList">Followers</a>
						</h5>
					</div>
					<div class="col-md-4">
						<!-- <h5>Following</h5> -->
						<h5>
							<a href="/following/followingList">Following</a>
						</h5>
					</div>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<br>
	<div class="col-md-7 offset-md-4">
		<table>
			<tr>
				<th><h5>Favorite-Book -> ${user.getFavbooks()}</h5></th>
			</tr>
			<tr>
				<th><h5>Favorite-Song -> ${user.getFavsongs()}</h5></th>
			</tr>
			<tr>
				<th><h5>Favorite-Place -> ${user.getFavplaces()}</h5></th>
			</tr>

		</table>
	</div>
	<br>
	<hr>
	<section>
		<div class="container mt-4">
			<div class="row">
				<div class="col-lg-4 offset-lg-5">
					<h1>All Posts</h1>
					<a
						<h5 class="btn btn-outline-success my-2 my-sm-0" name="imageFile" href="/post/postPage">Add Photo</h5>></a>
				</div>
			</div>
		</div>
		<%-- ${allPost} --%>
		<c:forEach var="i" items="${allPost}">
			<div class="container mt-4">
				<div class="row">
					<div class="col-lg-4 offset-lg-4">
						<div class="card" style="width: 18rem;">
							<img class="card-img-top"
								src="../uploadedPosts/${i.getPostName()}" alt="Card image cap">

							<%-- ${i.comment} --%>
							<br>
							<div class="row">
								<div class="col-md-4">
										
									<i class="fa fa-heart"
										style="color: red; border: none"> - ${i.likes.size()}</i>
									<form action="/post/postComments" action="GET">
										<input type="text" hidden="true" id="postid"
											value="${i.getPostId()}" name="postid">
										<input type="text" hidden="true" id="val"
											value="true" name="val">
										<button type="submit" class="fa-regular fa-comment"
											style="color: green; border: none"> - ${i.comment.size()}</button>
									</form>
									
								</div>
							</div>
							<a class="btn btn-sm btn-danger"
								href="/post/delete/${i.getPostId()}">Delete Post</a>

						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</section>
	<section>
		<br> <br> <br>
	</section>
	<script src="../js/search.js"></script>

	<!-- <!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
		integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>