<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- <script src="//code.jquery.com/jquery-1.11.3.min.js"></script> -->
<!-- <script src="js/like-dislike.js"></script> -->

<!-- Bootstrap CSS -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->

<!--  <link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"> 
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
	integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1"> 

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script> -->
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
	<%-- ${postName} --%>
	<c:if test="${msgsuccess1!=null}">
		<div class="text-center alert alert-success" role="alert">${msgsuccess1}</div>
	</c:if>
	<c:if test="${!postName.isEmpty()}">
		<div>

			<c:forEach var="i" items="${postName}">
				<div class="container mt-4">
					<div class="row">
						<div class="col-lg-4 offset-lg-4">
							<div class="card" style="width: 18rem;">
								<div class="row">
									<div class="col-md-4">
										<img height="50" width="50" style="border-radius: 100px"
											src="../image/${i.getPostUserId().getProfilephoto()}" />
									</div>
									<div class="col-md-8">
										<h4 class="card-title">${i.getPostUserId().getUserName()}</h4>
									</div>
								</div>
								<img class="card-img-center"
									src="../uploadedPosts/${i.getPostName()}" alt="Card image cap">
							</div>
							
							 <c:set var = "status" scope = "session" value ="${true} }"/>
							<c:forEach var="j" items="${i.likes}">
							<p>${j.isLike()}</p>
								<c:if test="${j.isLike()}">
									<c:set var = "status" scope = "session" value ="${false}"/>
								</c:if>
							</c:forEach>
							<c:if test="${status}">
							<p>Inside If</p>
								<button class="p-1 fa fa-heart-o" style="color: red"
								onClick="addislike(${i.getPostId()},${i.getPostUserId().getId()})"
								id="like${i.getPostId()}"></button>
							</c:if>
							
							<c:if test="${status!=true}"></c:if>
							<p>Inside else</p>
								<button class="p-1 fa fa-heart" style="color: red"
										onClick="addislike(${i.getPostId()},${i.getPostUserId().getId()})"
										id="like${i.getPostId()}"></button>
							${i.likes.size()}
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>
</body>


<script>
	function addislike(postid , userid){
		console.log(postid,userid);
		$.ajax({
			
			url:"/postLike/addlike?postid="+postid+"&userid="+userid,
			success : function(result){
				console.log(result)
				 var likecount=$("#likecount"+userid).text();
				
				likecount=parseInt(likecount)+1;
				$("#likcount"+userid).html(likecount);
				
				$("#addlike"+userid).removeClass("fa fa-heart-o");
				 $("#addlike"+userid).addClass("fa fa-heart");
				 location.reload();	
				 
			},
		error: function(result){
			console.log("Error");
		}
		});
	}
	
</script>












</html>