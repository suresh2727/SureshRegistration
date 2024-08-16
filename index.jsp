<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style type="text/css">
        	h1{
        		text-align : center;
        		text-shadow : 2px 1px 2px black;
        	}
        	
        	.errmsg{
        	
        		background: green;
        		padding: 10px;
        		width: 50%;
        		color: white;
        		font-weight: bold;
        		
        	}
        	
        	#heading , #email , #id{
        		text-align: center;
        	}
        	
        	
        
        </style>
</head>
<body>
	<%@include file = "Header.jsp"%>
	
	<%if(request.getAttribute("status")!=null) {%>
	<h1 class="errmsg"><%=request.getAttribute("status")%></h1>
	<%} %>
	
	<br>
	
	<div>
		<h1>Suresh Company..</h1>
	</div>
	        <% if (session.getAttribute("uname") != null) {%>
      			<h1 id="heading">Welcome <%= session.getAttribute("uname") %></h1>
	<h2 id="email">Email <%= session.getAttribute("email") %></h2>
	<h3 id="id">ID : <%= session.getAttribute("id") %></h3>
        <%}%>
</body>
</html>