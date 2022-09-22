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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
	integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="../css/userProfile.css" />
</head>
<body>
	<%@ include file="nav.jsp"%>
	
	<%-- ${postName} --%>
	<%-- <c:if test="${msgsuccess1!=null}">
		<div class="text-center alert alert-success" role="alert">${msgsuccess1}</div>
	</c:if> --%>
	<c:if test="${!postName.isEmpty()}">
		<div>

			<c:forEach var="i" items="${postName}">
				<div class="container mt-4">
					<div class="row">
						<div class="col-lg-4 offset-lg-4">
							<div class="card " style="width: 18rem;">
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
							<c:set var="status" scope="session" value="${true}" />
							<c:forEach var="j" items="${i.likes}">
							
								
								<c:if test="${j.isLike() && j.user.getId() == id}">
									<c:set var="status" scope="session" value="${false}" />
								</c:if>

							</c:forEach>
							<c:if test="${status}">
								<button class="p-1 fa fa-heart" style="color: black;border:none"
									onClick="addislike(${i.getPostId()},${i.getPostUserId().getId()})"
									id="like${i.getPostId()}" ></button>
							</c:if>

							<c:if test="${status!=true}">
								<button class="p-1 fa fa-heart" style="color: red;border:none"
									onClick="dislike(${i.getPostId()},${i.getPostUserId().getId()})"
									id="like${i.getPostId()}"></button>

							</c:if>
							${i.likes.size()} <a
								onClick="getData(${i.getPostId()},${i.getPostUserId().getId()})"
								href="" data-toggle="modal" data-target="#exampleModal" id="btn"><i
								class="fa-regular fa-comment"></i></a> ${i.comment.size()}
								
							<form action="/post/postComments" action="GET">
							<input type="text" hidden="true" id="postid" value="${i.getPostId()}" name="postid">
							<input type="text" hidden="true" id="val"
											value="false" name="val">
								<button type="submit" class="btn btn-primary btn-sm">View All Comments</button>
							</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>
	
</body>

<%@include file="commentModal.jsp"%>
<%-- <%@include file="../js/likeFunction.js"%> --%>
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
	
	
	function dislike(postid,userid){	
		$.ajax({
			url:"/postLike/dislike?postid="+postid+"&userid="+userid,
			success : function(result){
				 var likecount=$("#likecount"+userid).text();

				likecount=parseInt(likecount)-1;
				console.log(likecount);
				$("#likcount"+userid).html(likecount);
				
				$("#dislike"+userid).removeClass("fa fa-heart");
				 $("#dislike"+userid).addClass("fa fa-heart-o");
				 location.reload();
			},
			error: function(result){
				console.log("Error");
			}
		});
	}
	
	function getData(commentUser,postId){
		$("#commentUser").val(commentUser);
		$("#postId").val(postId);
	}
</script>












</html>