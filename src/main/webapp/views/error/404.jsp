<%
	if(session.getAttribute("id")!=null)
	{	
%>
		<script>
			window.location = "http://localhost:8080/user/loginpage";
		</script>
<%
	}
	else
	{
%>
		<script>
			window.location = "http://localhost:8080/user/loginpage";
		</script>
<%
	}
%>