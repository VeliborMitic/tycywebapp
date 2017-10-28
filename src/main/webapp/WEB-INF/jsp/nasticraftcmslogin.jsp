<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<jsp:include page="header.jsp" />

<body class="body-custom">
	
					<div class="container">
						<div class="card card-container">

							<img id="profile-img" class="profile-img-card"
								src="static/images/logo.png" width="96" height="96" />
							<p id="profile-name" class="profile-name-card">Nasticraft
								Admin CP</p>
							<form class="form-signin" method="POST" action="login-user">
								<span id="reauth-email" class="reauth-email"></span> <input
									type="text" id="inputEmail" class="form-control"
									placeholder="name" name="name" required autofocus> <input
									type="password" id="inputPassword" class="form-control"
									placeholder="password" name="password" required>
								<div id="remember" class="checkbox">
									<label> <input type="checkbox" value="remember-me">
										Remember me
									</label>
								</div>
								<button class="btn btn-lg btn-primary btn-block btn-signin"
									type="submit">Sign in</button>
							</form>
							<!-- /form -->
							<p id="profile-name" class="profile-name-card">
								&copy; <a href="http://nasticraft.ro" class="forgot-password">nasticraft.ro
								</a> | <a href="" class="forgot-password">Powered by TyCy </a>
							</p>

							<c:choose>
								<c:when test="${wrong_password == true}">
									<br>
									<div class="alert alert-danger">
										<strong>Error!</strong> Wrong Details!
									</div>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when test="${log_out == true}">
									<br>
									<div class="alert alert-info">
										<strong>Info!</strong> Logged Out
									</div>
								</c:when>
							</c:choose>

						</div>
						<!-- /card-container -->
					</div>
					<!-- /container -->
					
</body>
</html>