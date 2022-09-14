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

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
</head>
<body>

	<%@ include file="nav.jsp"%>
	<%
		String input1 = (String) request.getAttribute("msgsuccess1");
	if (input1 != null) {
	%>
	<div class=" text-center alert alert-success" role="alert">${msgsuccess1}</div>
	<%
		}
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-5 offset-md-11">
				<c:if test="${user.getProfilephoto()!=null}">
					<img height="100" width="100" style="border-radius: 100px"
						src="../image/${user.getProfilephoto()}" />
				</c:if>
				<c:if test="${user.getProfilephoto()==null}">
					<img height="100" width="100" style="border-radius: 100px"
						src="../image/Default.png" />
				</c:if>
			</div>
		</div>
	</div>
	<c:if test="${!postName.isEmpty()}">
	<div>	
		<c:forEach var="i" items="${postName}">
			<div class="container mt-4">
				<div class="row">
					<div class="col-lg-4 offset-lg-4">
					<div class="card" style="width: 20rem;">
						<div class="card" style="width: 18rem;">
							<img class="card-img-center"
								src="../uploadedPosts/${i}" alt="Card image cap">
						</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	</c:if>
</body>
</html>