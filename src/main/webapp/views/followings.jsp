<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Following</title>
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
</head>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container mt-4">
		<div class="row">
			<div class="col-lg-4 offset-lg-4">
				<table table border=1 style="width: 100%">
					<tr align="center" style= "height:50px">
						<th colspan="3">All FOLLOWING</th>
					</tr>
					<tr >
						<th>ProfilePhoto</th>
						<th>Name</th>
						<th>Fucn</th>
					</tr>
					<c:forEach var="j" items="${listOfFollowing}">	
						<tr>
					
							<td><img src="../image/${j.following.profilephoto}" alt="" border=3 height=60 width=60></img></td>
							<td>${j.following.fullName}</td>
							<td><a class="btn btn-sm btn-danger"
								href="/following/delete/${j.following.id}">Unfollow</a></td>
						</tr>
					</c:forEach>
				</table>
				<div class="container mt-4">
					<div class="row">
						<div class="col-lg-4 offset-lg-4">
							<a href="/following/goback" class="btn btn-success active"
								role="button" aria-pressed="true">Go-Back</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>


</html>