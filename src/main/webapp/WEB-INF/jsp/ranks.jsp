<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<jsp:include page="header.jsp" />

<body class="body-custom">

			<jsp:include page="navbarcms.jsp" />

			<div class="container text-center" id="taskDiv">

				<h3>Create new rank</h3>
				<hr>
				<div class="row">
					<div class="col-xs-6">
						<form class="form-horizontal" action="saveranks" method="POST">
							<div class="form-group" style="width: 650px;">
								<input type="hidden" name="id" value="${ranksup.id}" />
								<div class="col-sm-10">
									<input type="text" class="form-control"
										placeholder="Enter the rank title" name="ranktitle"
										value="${ranksup.ranktitle}"> <br /> <input
										type="text" class="form-control"
										placeholder="Enter the img name" name="rankimg"
										value="${ranksup.rankimg}"> <br /> <input type="text"
										class="form-control" placeholder="Enter the rank price"
										name="rankprice" value="${ranksup.rankprice}"> <br />
									<input type="text" class="form-control"
										placeholder="Enter the background img title or leave blank"
										name="titlebg" value="${ranksup.titlebg}"> <br /> <input
										type="text" class="form-control"
										placeholder="Enter the color for the title and price"
										name="titlecolor" value="${ranksup.titlecolor}"> <br />
									<button type="submit" class="btn btn-default pull-left">Add
										Rank</button>
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