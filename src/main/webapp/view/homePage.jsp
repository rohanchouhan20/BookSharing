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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="nav.jsp"%>
	
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
							<!-- <img id="myImg1" src="/image/heart.png" alt="The Pulpit Rock" width="30" height="30">
							<img id="myImg2" src="/image/whiteheart.png" alt="The Pulpit Rock" width="30" height="30"> -->
							<button onClick="adddislike()"><p style="color:red; border:none" class="fa-solid fa-heart-o" id="dislike"></p></button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>
</body>


<script>
var i=0;
	function adddislike(){
		if(i==0){
			$ ("#dislike").removeClass("fa-solid fa-heart-o");
			 $("#dislike").addClass("fa-solid fa-heart"); 
			 i=1;
		}else{
			$("#dislike").removeClass("fa-solid fa-heart");
			 $("#dislike").addClass("fa-solid fa-heart-o");
			 i=0;	
		}
	}
	
</script>












</html>