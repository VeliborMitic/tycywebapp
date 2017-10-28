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
				<h3>Forum</h3>
				<hr>
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered text-center text-info bg-pimary"
						style="background-color: #D8D8D8;">
						<thead>
							<tr>
								<th class="bg-inverse text-center">Id</th>
								<th class="bg-inverse text-center">Link</th>
								<th class="bg-inverse text-center">Edit</th>
								<th class="bg-inverse text-center">Delete</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="links" items="${linkk}">
								<tr>
									<td>${links.id}</td>
									<td>${links.link}</td>
									<td class="text-center"><a
										href="updateforum?id=${links.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td class="text-center"><a
										href="deleteforum?id=${links.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

					<c:choose>
						<c:when test="${added == true}">
							<br>
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