<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile Page</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>

	<%@ include file="nav.jsp"%>
	<br>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<c:if test="${msgfail!=null}">
				<div class="text-center alert alert-danger" role="alert">${msgfail}</div>
				</c:if>
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Edit Profile</h4>

						<form action="/user/editProfile" method="POST" enctype ="multipart/form-data">

							<div class="form-group" >
								<label for="exampleFormControlFile1" >Add your profile photo</label>
								<input type="file" class="form-control-file"
									id="exampleFormControlFile1" name = "imageFile" value="${user.getProfilephoto()}"/>
							</div>
							<div class="form-group">
								<label>Name *</label> <input type="text"
									class="form-control" name="fullName" value = "${user.getFullName()}">
							</div>
							<div class="form-group">
								<label>Email *</label> <input type="email"
									class="form-control" name="email" value = "${user.getEmail()}">
							</div>
							<div class="form-group">
								<label>Favorite Songs</label> <input type="text"
									class="form-control" name="favsongs" value = "${user.getFavsongs()}">
							</div>

							<div class="form-group">
								<label>Favorite Books</label> <input type="text"
									class="form-control" name="favbooks" value = "${user.getFavbooks()}">
							</div>
							<div class="form-group">
								<label>Favorite Places</label> <input type="text"
									class="form-control" name="favplaces" value = "${user.getFavplaces()}">
							</div>
							<input type="hidden" name="username" value="${username}">
							<button class="btn btn-success btn-block">Submit</button>
						</form>
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src = "../js/search.js"></script>
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