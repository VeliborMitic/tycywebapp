<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<html>

<jsp:include page="header.jsp" />

<body class="body-custom">
	
			<div class="container">
						<div class="card card-container">

							<img id="profile-img" class="profile-img-card"
								src="static/images/logo.png" width="96" height="96" />
							<p id="profile-name" class="profile-name-card">ERROR PAGE</p>
							<br>
							<div class="alert alert-danger text-center">
								<strong>Error!</strong> ${errormsg}
							</div>

							<div class="text-center">
								<a href="/"><button type="button"
										class="btn btn-warning">Click Here To return home</button></a>
							</div>

						</div>
						<!-- /card-container -->
					</div>
</body>
</html>