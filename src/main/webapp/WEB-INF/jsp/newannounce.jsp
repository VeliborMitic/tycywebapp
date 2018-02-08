<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<jsp:include page="header.jsp" />

<body class="body-custom">

			<jsp:include page="navbarcms.jsp" />

			<div class="container text-center" id="taskDiv">

				<h3>Create new Announce</h3>
				<hr>
				<div class="row">
					<div class="col-xs-6">
						<form class="form-horizontal" action="saveranks" method="POST">
							<div class="form-group" style="width: 650px;">
								<input type="hidden" name="id" value="${ranksup.id}" />
								<div class="col-sm-10">
									<input type="text" class="form-control"
										placeholder="Announce Title" name="ranktitle"
										value="${ranksup.ranktitle}"> <br /> <input
										type="text" class="form-control"
										placeholder="Announce sub-text" name="rankimg"
										value="${ranksup.rankimg}"> <br /> 
										
									  <select class="form-control glyphicon">
   									<option>Select announce title color</option>
   										 <option value="#ff0000" style="background-color: #FF0000;color:#fff">RED</option>
   										 <option value="#C0C0C0" style="background-color: #C0C0C0;color:#fff">SILVER</option>
   										 <option value="#000000" style="background-color: #000000;color:#fff">BLACK</option>
   										 <option value="#8E44AD" style="background-color: #8E44AD;color:#fff">PURPLE</option>
   										 <option value="#3498DB" style="background-color: #3498DB;color:#fff">BLUE</option>
   										 <option value="#E67E22" style="background-color: #E67E22;color:#fff">ORANGE</option>
   										 <option value="#922B21" style="background-color: #922B21;color:#fff">MAROON</option>
   										 <option value="#34495E" style="background-color: #34495E;color:#fff">GRAY</option>
   										 <option value="#2ECC71" style="background-color: #2ECC71;color:#fff">GREEN</option>
									</select> 
										<br />
										
									  <select class="form-control glyphicon">
   									<option>Select announce type</option>
   										 <option>&#xe146; Important</option>
    									 <option>&#xe107; Warning</option>
    									 <option>&#xe136; Mentenance</option>
    									 <option>&#xe017; Server Offline</option>
    									 <option>&#xe227; Donations</option>
    									 <option>&#xe034; Event</option>
    									 <option>&#xe022; Announce</option>
									</select> 
										<br />	
																	 
   									 <input
										type="text" class="form-control"
										placeholder="Read more Link"
										name="titlecolor" value="${ranksup.titlecolor}"> <br />
										
										<textarea class="form-control"
										placeholder="Announce content" name="textarea"></textarea>
									<br /> <br />
									
									<button type="submit" class="btn btn-default pull-left">Create
										Announce</button>
								</div>

							</div>
						</form>
					</div>
					<div class="col-xs-6">
						<div class="alert alert-warning text-left">
							<strong>Images name should be written without extensions
								!</strong>
							<p>Example: imgname / Not imgname.png</p>
							<br> <strong>Colors for the title and price should
								be written in hexadecimal format !</strong>
							<p>Example: #0066ff</p>
						</div>
					</div>
				</div>

				<div class="alert alert-info text-left">
					<strong>Background title images names: </strong>
					<p>bg1 to bg9</p>
					<strong>Title and Price color samples: </strong>
					<p>
						<span style="color: #00e600;">#00e600</span> <span
							style="color: #9933ff;">#9933ff</span> <span
							style="color: #e600e6;">#e600e6</span> <span
							style="color: #0066ff;">#0066ff</span>

					</p>
				</div>

			</div>

</body>
</html>