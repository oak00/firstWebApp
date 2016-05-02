

<html>
	<%@ include file="common/header.jspf" %>
	<body>
		<%@include file="common/navigation.jspf" %>
		<div class ="container">
		<h1>Add a ToDo</h1>
			<form:form method="post" commandName="todo"> <!-- Command Object -->
				
				<form:hidden path="id" />
				<fieldset class="form-group ">
					<form:label path="desc"> Description</form:label>
					<form:input path="desc" type="text" class="form-control" required="required"/>
					<form:errors path="desc" cssClass="text-warning" />
				</fieldset>
				
				<fieldset class="form-group ">
					<form:label path="targetDate"> Target Date</form:label>
					<form:input path="targetDate" type="text" class="form-control" required="required"/>
					<form:errors path="targetDate" cssClass="text-warning" />
				</fieldset>
				
				<input type="submit" value="Submit" class="btn btn-success"/>
			</form:form>
		</div>
		<%@include file="common/footer.jspf" %>
	</body>
</html>