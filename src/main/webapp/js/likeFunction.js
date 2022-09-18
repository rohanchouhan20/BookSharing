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
		console.log(postid,userid);
		console.log("Dislike")
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