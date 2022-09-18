<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Comment</title>
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
			<%-- ${postComment} --%>
			<table table border=1 cellspacing="1">
				<tr>
					<th colspan="2">COMMENTS</th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Comment</th>
				</tr>
				<c:forEach var="j" items="${postComment.comment}">
				<tr>
					<td>${j.user.fullName}</td>
					<td>${j.usercomments}</td>
				</tr>
				</c:forEach>
			</table>
			<a href="/post/goback" class="btn btn-success active" role="button" aria-pressed="true">Go-Back</a>
		</div>
		</div>
	</div>
</body>













</html>