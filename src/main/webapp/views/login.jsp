<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/login.css" />
<title>Login Page</title>
</head>
<body class="img js-fullheight"
	style="background-image: url(../image/bg.jpg); background-size: cover; background-position: center; height: 100vh">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<br>
				<h2 class="heading-section">Login</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-4">
				<div class="login-wrap p-0">
					<h3 class="mb-4 text-center">Have an account?</h3>
					<form action="/user/logincheck" method="POST">

						<div class="form-group">

							<div class="form-group">
								<input type="text" class="form-control" placeholder="Email"
									name="email" required>
							</div>
							<div class="form-group">
								<input id="password-field" type="password" class="form-control"
									placeholder="Password" name="password" required> <span
									toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>
							</div>

							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">Sign
									In</button>
							</div>
					</form>
					<p class="w-100 text-center">&mdash; Not Registered? &mdash;</p>
					<div class="social d-flex text-center">
						<a href="/user/signuppage" class="px-2 py-2 mr-md-1 rounded"><span
							class="ion-logo-facebook mr-2">Signup</span></a>
						<!-- <a href="#" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Twitter</a> -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- <div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
			
			 <c:if test = "${msg!=null}">
         <p><c:out value = "<div class="alert alert-success" role="alert">${msg}</div>"/><p>
      		</c:if>
      		
				<%String input1 = (String)request.getAttribute("msgsuccess");
				if(input1!=null){%>
					<div class=" text-center alert alert-success" role="alert">${msgsuccess}</div>
				<%}%>
				<%String input2 = (String)request.getAttribute("msgfail");
				if(input2!=null){%>
					<div class=" text-center alert alert-danger" role="alert">${msgfail}</div>
				<%}%>
				<c:if test="${msgsuccess!=null}">
				<div class="text-center alert alert-success" role="alert">${msgsuccess}</div>
				</c:if>
				<c:if test="${msgfail!=null}">
				<div class="text-center alert alert-danger" role="alert">${msgfail}</div>
				</c:if>
				<%String val = (String)request.getAttribute("msgInvalid");
				if(val!=null){
				%>
					<div class="alert alert-success" role="alert">${msgInvalid}</div>
				<%} %>
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Login</h4>

						<form action="/user/logincheck" method="POST">

							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									class="form-control" name="email">
							</div>

							<div class="form-group">
								<label>Enter Password</label> <input type="password"
									class="form-control" name="password">
							</div>

							<button class="btn btn-success btn-block">Signin</button>
						</form>
						<br>
						<form action="/user/signuppage" method="GET">
							<button class="btn btn-primary btn-block">Not Registered then Signup</button>
							</form>
					</div>
				</div>
			</div>
		</div>
	</div> --%>




	<!-- <!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
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