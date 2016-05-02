<html>
	<%@ include file="common/header.jspf"%>
	<body>
		<%@ include file="common/navigation.jspf"%>
		Welcome ${name}. <br/>
		Now, you can <a href="/list-todos">manage your todos.</a>
		<%@ include file="common/footer.jspf"%>
	</body>
</html>