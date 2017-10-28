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
				<h3>Create new vote box</h3>
				<hr>
				<form class="form-horizontal" action="savevote" method="POST">
					<div class="form-group" style="width: 650px;">
						<input type="hidden" name="id" value="${voteup.id}" />
						<div class="col-sm-10">
							<input type="text" class="form-control"
								placeholder="Enter the voting title" name="title"
								value="${voteup.title}"> <br /> <input type="text"
								class="form-control" placeholder="Enter the img name"
								name="imglink" value="${voteup.imglink}"> <br /> <input
								type="text" class="form-control"
								placeholder="Enter the voting link" name="votelink"
								value="${voteup.votelink}"> <br />

							<button type="submit" class="btn btn-default pull-left">Add
								Vote</button>
						</div>

					</div>
				</form>
			</div>

		</c:when>
	</c:choose>
</body>
</html>