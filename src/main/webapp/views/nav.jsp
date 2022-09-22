</html><%@ page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.Map.Entry"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NavBar</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" /> -->
</head>
<body>
	
	<!--NAVBAR  -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">Friend-Book Sharing</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<!-- <ul class="navbar-nav mr-auto"> -->
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/user/homepageview"><i class="fa-solid fa-house-user"></i> Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="/request/checkrequest"><i class="fa-solid fa-user-group" ></i> Friend Requests </a></li>
				<li class="nav-item active "><a class="nav-link"
					href="/user/userProfile"><i class="fa-solid fa-user"></i> MyProfile </a></li>
				<li class="nav-item active "><a class="nav-link"
					href="/user/loginpage"><i class="fa-solid fa-right-from-bracket"></i> Logout </a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<div class="topnav-right ml-auto">	
					<li class="nav-item active"><a class="nav-link " href="#">
							Username: ${username} <img height="40" width="40"
							style="border-radius: 100px" src="../image/${profile}" />
					</a></li>
				</div>
			</ul>
			<nav class="navbar navbar-light bg-primary">
				<form autocomplete="off" action="/user/searchdata" method="Get"
					class="form-inline">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search" onKeyup="mySearch()"
						id="search" name="search">

					<div class="search-result"></div>
					<button class="btn btn-outline-dark my-2 my-sm-0" type="submit">Search</button>
				</form>
			</nav>
		</div>
	</nav>
	<div class="card col-lg-2 offset-lg-9 fixed-top mt-5" id="box"
		style="height: 100px; display: none; overflow: auto">
		<table class="table">
			<tbody id="searchbox">
			</tbody>
		</table>
	</div>

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
<script src="../js/search.js"></script>

</html>