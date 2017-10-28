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
				<h3>Create new rank option</h3>
				<hr>
				<form class="form-horizontal" action="saveranksoption" method="POST">
					<div class="form-group" style="width: 890px;">
						<input type="hidden" name="id" value="${rankOptionsup.id}" />
						<div class="col-sm-10">
							<input type="text" class="form-control"
								placeholder="Enter the rank option name" name="name"
								value="${rankOptionsup.name}"> <br />


							<div class="pull-left">
								<!--  <label for="default" class="btn btn-default">CHECK ALL <input type="checkbox" id="default" class="badgebox"><span class="badge">&check;</span></label> -->
								<label for="success" class="btn btn-success">HELPER <input
									type="checkbox" id="success" class="badgebox" value="green"
									name="helper"
									${rankOptionsup.helper == 'green' ? 'checked' : ''}><span
									class="badge">&check;</span></label> <label for="danger"
									class="btn btn-purple">MODERATOR <input type="checkbox"
									id="danger" class="badgebox" value="green" name="moderator"
									${rankOptionsup.moderator == 'green' ? 'checked' : ''}><span
									class="badge">&check;</span></label> <label for="info"
									class="btn btn-pink">ADMIN <input type="checkbox"
									id="info" class="badgebox" value="green" name="admin"
									${rankOptionsup.admin == 'green' ? 'checked' : ''}><span
									class="badge">&check;</span></label> <label for="primary"
									class="btn btn-primary">OPERATOR<input type="checkbox"
									id="primary" class="badgebox" value="green" name="operator"
									${rankOptionsup.operator == 'green' ? 'checked' : ''}><span
									class="badge">&check;</span></label>

							</div>
							<br /> <br /> <br />
							<button type="submit" class="btn btn-default pull-left">Add
								Rank Option</button>
						</div>

					</div>
				</form>
			</div>


		</c:when>
	</c:choose>
</body>
</html>