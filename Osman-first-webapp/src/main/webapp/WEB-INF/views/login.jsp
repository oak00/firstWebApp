<html>
<head>
<%@ include file="common/header.jspf" %> 
</head>
<body>
	<%@ include file="common/navigation.jspf" %>
	    <p><font color="red">${errorMessage}</font></p>
	    <form action="/login" method="POST">
	        Name : <input name="name" type="text" /> 
	        Password : <input name="password" type="password" /> 
	        <input type="submit" class="btn btn-success" />
	    </form>
    <%@ include file="common/footer.jspf" %>
</body>
</html>