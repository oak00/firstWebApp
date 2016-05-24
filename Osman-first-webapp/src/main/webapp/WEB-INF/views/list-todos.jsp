<html>
<%@ include file="common/header.jspf" %>
	<body>
		<%@include file="common/navigation.jspf" %>
		<div class="container">
			<table class="table table-striped">
				<caption><spring:message code="todo.caption"/></caption>
				
				<thead>
					<tr>
						<th><spring:message code="listTodos-description.caption"/></th>
						<th><spring:message code="listTodos-targetDate.caption"/></th>
						<th><spring:message code="listTodos-isCompleted.caption"/></th>
						<th></th>
					</tr>
				</thead>
		
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.desc}</td>							
							<td><fmt:formatDate pattern="dd/MM/yyyy"
												value="${todo.targetDate}" /></td>
							<td>${todo.done}</td> <!-- 'is-' prefix removed due to java bean convention -->
							<td>
								<a href="/update-todo?id=${todo.id}" class="btn btn-success"><spring:message code="listTodos-updateButton.caption"/></a>
								<a href="/delete-todo?id=${todo.id}" class="btn btn-danger"><spring:message code="listTodos-deleteButton.caption"/></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<a class="btn btn-success" href="/add-todo"><spring:message code="listTodos-addButton.caption"/></a>
			</div>	
		</div>	
		<%@include file="common/footer.jspf" %>
	</body>
</html>