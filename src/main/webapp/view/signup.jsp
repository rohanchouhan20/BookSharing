<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
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

<title>Home Page</title>
</head>
<body>

		
	<br>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<%String input2 = (String)request.getAttribute("msgfail");
				if(input2!=null){%>
					<div class="alert alert-danger" role="alert">${msgfail}</div>
				<%}%>
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-primary">Sign-Up</h4>

						<form id="frm" action="/user/signupcheck" method=POST>

							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									class="form-control" name="fullName">
							</div>
							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									class="form-control" name="email">
							</div>

							<div class="form-group">
								<label>Enter Password</label> <input type="password"
									class="form-control" name="password">
							</div>
							<button type="submit" class="btn btn-success btn-block">Signup</button>
							<br>

						</form>
						<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
						<script
							src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
						<form action="loginpage" method="GET">
							<button class="btn btn-primary btn-block">Already
								Registered then Signin</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
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