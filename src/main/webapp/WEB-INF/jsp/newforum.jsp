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
				<h3>Add a forum link</h3>
				<hr>
				<form class="form-horizontal" action="saveforum" method="POST">
					<div class="form-group" style="width: 650px;">
						<input type="hidden" name="id" value="${links.id}" />
						<div class="col-sm-10">
							<input type="text" class="form-control"
								placeholder="Enter forum Link" name="link" value="${links.link}">
							<br />
							<button type="submit" class="btn btn-default pull-left">Add
								Link</button>
						</div>

					</div>
				</form>
			</div>

		</c:when>
	</c:choose>
</body>
</html>