<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friends Profile Page</title>
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
	<br>
		<c:if test="${msg6!=null}">
				<div class="text-center alert alert-success" role="alert">${msg6	}</div>
				</c:if>
	<br>
	<div class="d-flex justify-content-center">
		<c:if test="${user.getProfilephoto()!=null}">
			<img height="200" width="200" style="border-radius: 900px"
				src="../image/${user.getProfilephoto()}" />
		</c:if>
	</div>
		<br>
	<c:if test="${user.getProfilephoto()!=null}">
		<div class="d-flex justify-content-center">
			<h3>${msgsuccess}</h3>
		</div>
		<div class="d-flex justify-content-center">
			<c:forEach var="j" items="${requests}">
		<c:if test="${j.sender.id == id}">
			<h4><a href="/request/deleterequest?userId=${user.getId()}">Decline</a></h4>
		</c:if>
		</c:forEach>
		<c:if test="${requests.isEmpty()}">
			<h4><a href="/request/followrequest?userId=${user.getId()}">Follow</a></h4>
		</c:if>
	
		</div>
	</c:if>
	<c:choose>
		<c:when test="${msgsuccess3!=null}">
			<div class="d-flex justify-content-center">
				<h4>${msgsuccess3}</h4>
			</div>
		</c:when>
		<c:otherwise>
			<div class="d-flex justify-content-center">
				<c:if test="${user.getProfilephoto()==null}">
					<img src="../image/Noresultsfound.jpg" />
				</c:if>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>