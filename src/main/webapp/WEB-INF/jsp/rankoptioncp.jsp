<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<jsp:include page="header.jsp" />

<body class="body-custom">
	<%
		Object loggedIn = session.getAttribute("loggedIn");
	%>
	<c:choose>

		<c:when test="${loggedIn eq true}">
			<jsp:include page="navbarcms.jsp" />


			<div class="container text-center" id="taskDiv">
				<h3>Ranks Options</h3>
				<hr>
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered text-center text-info bg-pimary"
						style="background-color: #D8D8D8;">
						<thead>
							<tr>
								<th class="bg-inverse text-center">Id</th>
								<th class="bg-inverse text-center">NAME</th>
								<th class="bg-inverse text-center">HELPER</th>
								<th class="bg-inverse text-center">MODERATOR</th>
								<th class="bg-inverse text-center">ADMIN</th>
								<th class="bg-inverse text-center">OPERATOR</th>
								<th class="bg-inverse text-center">Edit</th>
								<th class="bg-inverse text-center">Delete</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="rankO" items="${ranksOptionsList}">
								<tr>
									<td>${rankO.id}</td>
									<td>${rankO.name}</td>
									<td><img src="static/images/${rankO.helper}.png"
										width="24" height="24" /></td>
									<td><img src="static/images/${rankO.moderator}.png"
										width="24" height="24" /></td>
									<td><img src="static/images/${rankO.admin}.png" width="24"
										height="24" /></td>
									<td><img src="static/images/${rankO.operator}.png"
										width="24" height="24" /></td>
									<td class="text-center"><a
										href="updaterankoption?id=${rankO.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td class="text-center"><a
										href="deleterankoption?id=${rankO.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

					<c:choose>
						<c:when test="${addedr == true}">
							<a href="/newrankoption" class="btn btn-primary pull-left"><span
								class="glyphicon glyphicon-plus"></span> Add More</a>
							<br />
							<br />
							<div class="alert alert-success">
								<strong>Success!</strong>
							</div>
						</c:when>

						<c:when test="${deletedr == true}">
							<br />
							<div class="alert alert-success">
								<strong>Success!</strong>
							</div>
						</c:when>

					</c:choose>
				</div>
			</div>

		</c:when>
	</c:choose>
</body>
</html>