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
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<title>Home Page</title>
<link rel="stylesheet" href="../css/login.css" />
</head>
<body onload="cap()">
<body class="img js-fullheight"
	style="background-image: url(../image/bg.jpg); background-size: cover; background-position: center; height: 100vh">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<br>
				<h2 class="heading-section">Sign-Up</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-4">
				<div class="login-wrap p-0">
					<!-- <h3 class="mb-4 text-center">Have an account?</h3> -->
					<form action="/user/logincheck" method="POST">

						<div class="form-group">
								<input type="text"
								class="form-control" placeholder="FullName" name="fullName">
						</div>

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
						<br> <label>Enter Captcha:</label>
						<div class="form-row">
							<div class="form-group col-md-6">
								<input type="text" class="form-control" readonly id="capt">
							</div>
							<div class="form-group col-md-6">
								<input type="text" class="form-control" id="textinput">
							</div>
						</div>

						<h6>Captcha not visible <img src="../image/refresh.jpg" width="30px"
								onclick="cap()">
						</h6>
						<div class="form-group">
							<button type="submit" 
								class="form-control btn btn-primary submit px-3">Sign-Up</button>
						</div>
					</form>
					<p class="w-100 text-center">&mdash; Have an account? &mdash;</p>
					<div class="social d-flex text-center">
						<a href="loginpage" class="px-2 py-2 mr-md-1 rounded"><span
							class="ion-logo-facebook mr-2">SIGN-IN</span></a>
						<!-- <a href="#" class="px-2 py-2 ml-md-1 rounded"><span class="ion-logo-twitter mr-2"></span> Twitter</a> -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- <div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">

				<c:if test="${msgfail!=null}">
					<div class="text-center alert alert-danger" role="alert">${msgfail}</div>
				</c:if>
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
							<br> <label>Enter Captcha:</label>
							<div class="form-row">
								<div class="form-group col-md-6 no" >
									<input type="text" class="form-control" readonly id="capt">
								</div>
								<div class="form-group col-md-6">
									<input type="text" class="form-control" id="textinput">
								</div>
							</div>

							<h6>
								Captcha not visible <img src="../image/refresh.jpg" width="30px"
									onclick="cap()">
							</h6>
							<div class="form-group">
								<button onclick="validcap()" type="submit"
									class="btn btn-success btn-block">Signup</button>
							</div>
						</form>
						<form action="loginpage" method="GET">
							<button class="btn btn-primary btn-block">Already
								Registered then Signin</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div> --%>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script type="text/javascript">
  function cap(){
    var alpha = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V'
                 ,'W','X','Y','Z','1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g','h','i',
                 'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z', '!','@','#','$','%','^','&','*','+'];
                 var a = alpha[Math.floor(Math.random()*71)];
                 var b = alpha[Math.floor(Math.random()*71)];
                 var c = alpha[Math.floor(Math.random()*71)];
                 var d = alpha[Math.floor(Math.random()*71)];
                 var e = alpha[Math.floor(Math.random()*71)];
                 var f = alpha[Math.floor(Math.random()*71)];

                 var final = a+b+c+d+e+f;
                 document.getElementById("capt").value=final;
               }
               function validcap(){
                var stg1 = document.getElementById('capt').value;
                var stg2 = document.getElementById('textinput').value;
                if(stg1==stg2){
                  alert("Form is validated Succesfully");
                  return true;
                }else{
                  alert("Please enter a valid captcha");
                  return false;
                }
               }
</script>
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
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
</body>

</html>