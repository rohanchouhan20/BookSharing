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
	<%-- <div class="container mt-4">
		<div class="row">
			<div class="col-lg-4 offset-lg-4">
				<c:if test="${update!=null}">
					<div class="text-center alert alert-success" role="alert">${update}</div>
				</c:if>
				${postComment.comment}
				<table table border=1 style="width: 100%">
					<tr align="center" style="height: 50px">
						<th colspan="4">ALL COMMENTS</th>
					</tr>
					<tr>
						<th>Profile</th>
						<th>Name</th>
						<th>Comment</th>
						<th>MODIFY</th>
					</tr>
					<c:forEach var="j" items="${postComment.comment}">

						<tr>
							<td><img src="../image/${j.user.profilephoto}" alt=""
								border=3 height=60 width=60></img></td>
							<td>${j.user.fullName}</td>
							<td id="${j.id}">${j.usercomments}</td>
							<td><c:if test="${j.user.id==loginid}">
									<button type="button" class="btn btn-primary btn-sm"
										onclick="getdata2(${j.id})" data-toggle="modal"
										data-target="#exampleModal">Edit</button>

									<form action="/comment/deleteComment" action="post">
										<input type="text" hidden="true" id="commentid"
											value="${j.id}" name="commentid"> <input type="text"
											hidden="true" id="postid" value="${postid}" name="postid">
										<input type="text" hidden="true" id="val" value="false"
											name="val">
										<button type="submit" class="btn btn-danger btn-sm">Delete</button>
									</form>
									<!-- Modal -->
									<div class="modal fade" id="exampleModal" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Edit
														Comment</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<form action="/comment/editComments" action="post"
													autocomplete="off">
													<div class="modal-body">
														<input type="text" placeholder="Enter Comment" 
															name="comment" value="${j.usercomments}" id="commentshow">
														<input type="text"  id="commentid2" hidden="true"
															value="${j.id}" name="commentid"> <input
															type="text" hidden="true" id="postid" value="${postid}"
															name="postid">
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Close</button>
														<button type="submit" class="btn btn-primary">Save
															changes</button>
													</div>
												</form>
											</div>
										</div>
									</div>
									<!-- Modal -->
								</c:if> <c:if test="${val==true}">
									<form action="/comment/deleteComment" action="post">
										<input type="text" hidden="true" id="commentid"
											value="${j.id}" name="commentid"> <input type="text"
											hidden="true" id="postid" value="${postid}" name="postid">
										<input type="text" hidden="true" id="val" value="true"
											name="val">
										<button type="submit" class="btn btn-danger btn-sm">Delete</button>
									</form>
								</c:if></td>
						</tr>
					</c:forEach>
				</table>
				<div class="container mt-4">
					<div class="row">
						<div class="col-lg-4 offset-lg-4">
							<c:if test="${val==true}">
								<a href="/comment/goback" class="btn btn-success active"
									role="button" aria-pressed="true">Go-Back</a>
							</c:if>
							<c:if test="${val==false}">
								<a href="/post/goback" class="btn btn-success active"
									role="button" aria-pressed="true">Go-Back</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> --%>
	<div class="row d-flex justify-content-center mt-100 mb-100">
    <div class="col-lg-9">
        <div class="card">
            <div class="card-body text-center">
                <h4 class="card-title">Latest Comments</h4>
            </div>
	<c:forEach var="j" items="${postComment.comment}">
            <div class="comment-widgets">
                <!-- Comment Row -->
                <div class="d-flex flex-row comment-row m-t-0">
                    <div class="p-2"><img src="../image/${j.user.profilephoto}" alt=""
								border=3 height=60 width=60></img></div>
						<div class="comment-text w-100">
							<h6 class="font-medium">${j.user.fullName}</h6>
							<span class="m-b-15 d-block" id="${j.id}">${j.usercomments}</span>
							<div class="comment-footer">
							
							<div class = "row ml-1">
								<c:if test="${j.user.id==loginid}">
									<button type="button" class="btn btn-primary btn-sm mr-2"
										onclick="getdata2(${j.id})" data-toggle="modal"
										data-target="#exampleModal">Edit</button>

									<form action="/comment/deleteComment" action="post">
										<input type="text" hidden="true" id="commentid"
											value="${j.id}" name="commentid"> <input type="text"
											hidden="true" id="postid" value="${postid}" name="postid">
										<input type="text" hidden="true" id="val" value="false"
											name="val">
										<button type="submit" class="btn btn-danger btn-sm">Delete</button>
									</form>
								</c:if> 
								</div>
								
								<c:if test="${val==true}">
									<form action="/comment/deleteComment" action="post">
										<input type="text" hidden="true" id="commentid"
											value="${j.id}" name="commentid"> <input type="text"
											hidden="true" id="postid" value="${postid}" name="postid">
										<input type="text" hidden="true" id="val" value="true"
											name="val">
										<button type="submit" class="btn btn-danger btn-sm">Delete</button>
									</form>
								</c:if>
								
								
							</div>
						</div>
					</div> <!-- Comment Row -->
					<br>
            </div> <!-- Card -->
</c:forEach>
        </div>
    </div>
</div>
									<!-- Modal -->
									<div class="modal fade" id="exampleModal" tabindex="-1"
										role="dialog" aria-labelledby="exampleModalLabel"
										aria-hidden="true">
										<div class="modal-dialog" role="document">
											<div class="modal-content">
												<div class="modal-header">
													<h5 class="modal-title" id="exampleModalLabel">Edit
														Comment</h5>
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<form action="/comment/editComments" action="post"
													autocomplete="off">
													<div class="modal-body" style = "width:100%">
														<input class = "form-control" type="text" placeholder="Enter Comment" 
															name="comment" value="${j.usercomments}" id="commentshow">
											
														<input type="text"  id="commentid2" hidden="true"
															value="${j.id}" name="commentid"> <input
															type="text" hidden="true" id="postid" value="${postid}"
															name="postid">
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-secondary"
															data-dismiss="modal">Close</button>
														<button type="submit" class="btn btn-primary">Save
															changes</button>
													</div>
												</form>
											</div>
										</div>
									</div>
					<div class="row ">
						<div class="col-lg-4 offset-lg-9">
							<c:if test="${val==true}">
								<a href="/comment/goback" class="btn btn-success active"
									role="button" aria-pressed="true">Go-Back</a>
							</c:if>
							<c:if test="${val==false}">
								<a href="/post/goback" class="btn btn-success active"
									role="button" aria-pressed="true">Go-Back</a>
							</c:if>
						</div>
					</div>
				</div>
									<div class="container mt-4">
									<!-- Modal -->
</body>
<%-- <%@include file="editComment.jsp"%> --%>


<script type="text/javascript">
	function getData(commentid, usercomments) {
		$("#commentid").val(commentid);
		$("#usercomments").val(usercomments);
	}
	 function getdata2(comment){
			console.log(comment);
			$("#commentid2").val(comment);
			$("#commentshow").val($("#"+comment).html());
		}
	
</script>


</html>