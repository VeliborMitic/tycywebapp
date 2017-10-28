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
				<h3>Voting boxes</h3>
				<hr>
				<div class="table-responsive">
					<table
						class="table table-striped table-bordered text-center text-info bg-pimary"
						style="background-color: #D8D8D8;">
						<thead>
							<tr>
								<th class="bg-inverse text-center">Id</th>
								<th class="bg-inverse text-center">Title</th>
								<th class="bg-inverse text-center">Img link</th>
								<th class="bg-inverse text-center">Voting Link</th>
								<th class="bg-inverse text-center">Edit</th>
								<th class="bg-inverse text-center">Delete</th>
							</tr>
						<thead>
						<tbody>
							<c:forEach var="vote" items="${votingList}">
								<tr>
									<td>${vote.id}</td>
									<td>${vote.title}</td>
									<td>${vote.imglink}</td>
									<td>${vote.votelink}</td>
									<td class="text-center"><a
										href="updatevoting?id=${vote.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td class="text-center"><a
										href="deletevoting?id=${vote.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

					<c:choose>

						<c:when test="${addedv == true}">
							<a href="/newvote" class="btn btn-primary pull-left"><span
								class="glyphicon glyphicon-plus"></span> Add More</a>
							<br />
							<br />
							<div class="alert alert-success">
								<strong>Success!</strong>
							</div>
						</c:when>

						<c:when test="${deletedv == true}">
							<br />
							<div class="alert alert-success">
								<strong>Success!</strong>
							</div>
						</c:when>

						<c:when test="${addNoMoreVote == true}">
							<br>
							<div class="alert alert-danger">
								<strong>Error ! You are not allowed to add more than 4
									voting box.</strong>
							</div>
						</c:when>

					</c:choose>
				</div>
			</div>


		</c:when>
	</c:choose>
</body>
</html>