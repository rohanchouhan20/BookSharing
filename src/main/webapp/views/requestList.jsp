<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<%@include file="nav.jsp"%>

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
</head>
<c:if test="${msg1!=null}">
	<div class="d-flex justify-content-center">
		<h4>${msg1}</h4>
	</div>
</c:if>
<c:choose>
	<c:when test="${listOfRequest!=null}">
		<div class="container mt-4">
			<div class="row">
				<div class="col-lg-4 offset-lg-4">
					<table border=2>
						<tr>
							<th colspan="5"><h5 class="text-center">ALL REQUESTS</h5></th>
						</tr>
						<c:forEach var="i" items="${listOfRequest}">
							<div class="col-md-3">
								<div class="row mt-5">
									<div class="col-md-6">
										<tr>
											<td><c:if
													test="${i.getSender().getProfilephoto()!=null}">
													<img alt=""
														src="../../image/${i.getSender().getProfilephoto()}"
														height="50" width="50" style="border-radius: 800px">
												</c:if></td>
											<td>
												<div>
													<label class="text-center text-dark">${i.getSender().getUserName()}</label>
												</div>
											</td>
											<td>
												<h6>
													<c:if test="${i.isAccepted() ==  false}">
														<a
															href="/request/acceptrequest?userId=${i.getSender().getId()}">Confirm</a>
													</c:if>
												</h6>
											</td>

											<td>
												<h6>
													<c:if test="${i.isAccepted() ==  false}">
														<a
															href="/request/declinerequest?userId=${i.getSender().getId()}">Decline</a>
													</c:if>
												</h6>
											</td>
											<td>
												<h6>
													<c:if test="${!i.getFollowBack()}">
														<a
															href="/request/followback?userId=${i.getSender().getId()}">Follow
															Back</a>
													</c:if>
												</h6>
											</td>
										</tr>
									</div>
								</div>
							</div>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div class="container mt-5">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<img alt="" src="../../image/Noresultsfound.jpg">
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</c:otherwise>
</c:choose>




