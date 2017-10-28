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

				<h3>Send newsletter</h3>
				<hr>
				<div class="row">
					<div class="col-xs-6">
						<form class="form-horizontal" action="sendnewsletter"
							method="POST">
							<div class="form-group" style="width: 650px;">
								<div class="col-sm-10">
									<input type="text" class="form-control" placeholder="Subject"
										name="subject"> <br />
									<textarea class="form-control"
										placeholder="Nasticraft Newsletter" name="textarea"></textarea>
									<br /> <br />

									<button type="submit" class="btn btn-default pull-left">Send
										Newsletter</button>
								</div>

							</div>
						</form>
					</div>
					<div class="col-xs-6">
						<div class="alert alert-warning text-left">
							<strong>Emails in database!</strong> <br />
							<p>${emailsavailable}</p>
						</div>
					</div>
				</div>


			</div>
			<c:choose>
				<c:when test="${send == true}">
					<br>
					<div class="alert alert-info text-center">
						<strong>Success</strong> You send the newslettler.
					</div>
				</c:when>

				<c:when test="${emptyFields == true}">
					<br>
					<div class="alert alert-danger">
						<strong>Error ! One or both fields are empty, please fill
							them up </strong>
					</div>
				</c:when>
			</c:choose>



		</c:when>
	</c:choose>
</body>
</html>