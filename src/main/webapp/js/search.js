
	function mySearch() {
		var name = $("#search").val();
		if(name!="")
		{
		$.ajax({
			url : "../user/search?name=" + name,
			method : "get",
			success : function(result) {
				console.log(name);
				$('tr').remove(".rex");
				$("#box").show();
				for(i=0;i<result.length;i++)
				{
				console.log(result[i].userName);
$('#searchbox').append('<tr class="rex"><td><a href="/user/searchdata?search='+result[i].userName+'"><img height="30" width="30" style="border-radius:100px" src="../image/'+result[i].profilephoto+'"/>   '+ result[i].userName + '</a></td></tr>');
				}
			},
		    error:function(result){
		    	console.log(result);
		    }
		});
		}
		else{
			$('tr').remove(".rex");
			$("#box").hide();
			}
	}