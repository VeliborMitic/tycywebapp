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
								<th class="bg-inverse text-center">Rank Title</th>
								<th class="bg-inverse text-center">Img name</th>
								<th class="bg-inverse text-center">Price</th>
								<th class="bg-inverse text-center">Title Color</th>
								<th class="bg-inverse text-center">Background img name</th>
								<th class="bg-inverse text-center">Edit</th>
								<th class="bg-inverse text-center">Delete</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="rank" items="${ranksList}">
								<tr>
									<td>${rank.id}</td>
									<td>${rank.ranktitle}</td>
									<td>${rank.rankimg}</td>
									<td>${rank.rankprice}</td>
									<td><span style="color:${rank.titlecolor}">${rank.titlecolor}</span></td>
									<td><img src="static/images/${rank.titlebg}.gif"
										width="24" height="24"></td>
									<td class="text-center"><a
										href="updateranks?id=${rank.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td class="text-center"><a
										href="deleteranks?id=${rank.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

					<c:choose>
						<c:when test="${addedr == true}">
							<a href="/newrank" class="btn btn-primary pull-left"><span
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

						<c:when test="${addNoMore == true}">
							<br>
							<div class="alert alert-danger">
								<strong>Error ! You are not allowed to add more than 4
									ranks.</strong>
							</div>
						</c:when>
					</c:choose>
				</div>
			</div>




		</c:when>
	</c:choose>
</body>
</html>