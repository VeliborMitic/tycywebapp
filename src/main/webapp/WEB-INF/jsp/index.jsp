<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<title>NASTYCRAFT | Gamster Community</title>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">



<link
	href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="static/css/nastycraft.css" rel="stylesheet" media="screen" type="text/css">
<link href="static/css/checkbox.css" rel="stylesheet" media="screen">
<link href="static/css/carousel.css" rel="stylesheet" media="screen">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="static/js/nastycraft.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="icon" type="image/png" href="static/images/fav.png">
</head>

<body>

	<c:choose>
		<c:when test="${mode == 'HOME_INDEX'}">

			<div class="container full">
				<!-- Logo -->
				<img src="static/images/nasticraft2.png" width="800" height="300"
					class="img-responsive center-block" />

				<!-- Menu -->

				<section class="ccblue">
					<div class="mainmenu">
						<form action="savenewsletter" method="POST">
							<ul>
								<li class="menuli"><a href="/" class="nounderline"><i
										class="icon-home icon-large"></i> <main>Home</main><span>Nasticraf</span></a></li>
								<li class="menuli"><a href="/donations" class="nounderline"><i
										class="icon-btc icon-large"></i> <main>Donations</main><span>Good
											offers</span></a></li>
								<li class="menuli"><a href="/voting" class="nounderline"><i
										class="icon-bar-chart icon-large"></i> <main>Vote Us</main><span>Vote
											for us</span></a></li>
								<c:forEach var="links" items="${linkk}">
									<li class="menuli"><a href="${links.link}"
										class="nounderline"><i class="icon-qrcode icon-large"></i> <main>Forum</main><span>Check
												the news</span></a></li>
								</c:forEach>
							</ul>

							<span class="form-custom-nasticraft-span"><input
								type="text" class="form-custom-nasticraft"
								placeholder="Enter your email to subscribe" name="email"><button type="submit" class="btn-nastycraft btn-default">
								<span class="glyphicon glyphicon-envelope"></span>
								</button></span>

							<ul  class="pull-right" style="overflow-x: hidden;">
								<li class="menuli"><a href="/" class="nounderline"><i
										class="icon-facebook icon-large"></i> <main>Follow us</main><span>nasticraft</span></a></li>
								<li class="menuli"><a href="/" class="nounderline"><i
										class="icon-youtube icon-large"></i> <main>Subscribe</main><span>nasticraft</span></a></li>
								<li class="menuli"><a href="/" class="nounderline"><i
										class="icon-google-plus icon-large"></i> <main>Google
										us</main><span>nasticraft</span></a></li>
							</ul>
						</form>
					</div>
				</section>

				<c:choose>
					<c:when test="${added == true}">
						<br>
						<div class="alert alert-info text-center">
							<strong>Success</strong> You subscribe to Nasticraft newsletter.
						</div>
					</c:when>
					<c:when test="${added == false}">
						<br>
						<div class="alert alert-danger text-center">
							<strong>Error !</strong> Invalid email address.
						</div>
					</c:when>
					<c:when test="${ipExist == true}">
						<br>
						<div class="alert alert-danger text-center">
							<strong>Error !</strong> A subscription was already made from
							this machine.
						</div>
					</c:when>
					<c:when test="${emailExist == true}">
						<br>
						<div class="alert alert-danger text-center">
							<strong>Error !</strong> You already subscribe with this email
							address.
						</div>
					</c:when>
				</c:choose>


				<c:choose>
					<c:when test="${display == 'HOME'}">
					
					<div class="container">
        <div class="row">
         
            <div class="col-6 col-md-4">
                <div class="card">
                    <img class="card-img-top" src="static/images/1.jpg">
                    
                    <div class="card-block">
                        <h4 class="card-title">Server Informations</h4>

                        <div class="card-text">
                        
                        <div class="update-nag">
           					 <div class="update-split"><i class="glyphicon glyphicon-play-circle"></i></div>
            				 <div class="update-text">Play <a href="#">mc.nasticraft.ro</a> </div>
        				 </div>
        				 
        				     <div class="update-nag">
            					<div class="update-split update-info"><i class="glyphicon glyphicon-user"></i></div>
           						 <div class="update-text">Users online : <a href="#">${onlineusers}</a> </div>
         					 </div>
         					 
         					 <div class="update-nag">
            					<div class="update-split update-success"><i class="glyphicon glyphicon-flash"></i></div>
           						 <div class="update-text">Server Status : <span class="blink_me blink_colorg">ONLINE</span> </div>
         					 </div>

                        </div> 
                    </div>
                </div>
            </div>
            
            <div class="col-6 col-md-4">
                <div class="card">
                    <img class="card-img-top" src="static/images/2.jpg">
                    <div class="card-block">
                        <h4 class="card-title">Latest Event</h4>
                        <div class="card-text">
                           Under Construction.
                        </div>
                    </div>
                 
                </div>
            </div>
            
            
            <div class="col-6 col-md-4">
                <div class="card">
                    <img class="card-img-top" src="static/images/3.jpg">
                    <div class="card-block">
                        <h4 class="card-title"><span class="glyphicon glyphicon-hand-right"></span> Give us a Like</h4>
            
                        <div class="card-text">
                             Under Construction.
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
           
          
           <div class="bg-light content" style="padding:10px;">
     	
     	<div class="row" style=" height:30px; line-height: 30px;">
  			<div class="col-sm-8 bigfontsizebold">Announce Title</div>
  			<div class="col-sm-4 text-right"><span class="glyphicon glyphicon-pushpin" style="font-size:13px;"></span> Type of the announce</div>
	   </div>	

		        <div class="alert alert-warning"> 
		        fweffwf<br>
		         fweffwf<br>
		          fweffwf<br>
		           fweffwf<br>
		            fweffwf<br>
		             fweffwf<br>
		              fweffwf<br>
		               fweffwf<br>
		                fweffwf<br>
		                 fweffwf<br>
		                  fweffwf<br>
		        </div>
        	
        		<div>
  			<a href="#" class="btn btn-sm btn-warning"><span class="glyphicon glyphicon-eye-open"></span> Read More</a>
	  			 </div>
	   
	   
      </div>
             
             
        </div>
					</c:when>
					
					<c:when test="${display == 'DONATIONS'}">
						<table class="gocenter text-center" width="1200" border="0">
							<tr>
								<td colspan="1"></td>

								<c:forEach var="rank" items="${ranksList}">
									<td><span
										style="background: url(static/images/${rank.titlebg}.gif)"><b><font
												color="${rank.titlecolor}">${rank.ranktitle}</font></b></span></td>
								</c:forEach>
							</tr>
							<tr>
								<td><img src="static/images/nasticraft2.png" width="320"
									height="120" alt="logo" /></td>
								<c:forEach var="rank" items="${ranksList}">
									<td><img src="static/images/${rank.rankimg}.png"
										width="200" height="200" alt="logo" /></td>
								</c:forEach>
							</tr>

							<tr>
								<td colspan="1"></td>
								<c:forEach var="rank" items="${ranksList}">
									<td><span><font color="${rank.titlecolor}"><b>${rank.rankprice}</b></font></span></td>
								</c:forEach>
							</tr>
							<tr>
								<td colspan="5"><hr></td>
							</tr>
							<tr>
								<td colspan="5">

									<table
										class="table table-striped table-hover table-bordered text-center text-info bg-grey">
										<c:forEach var="rankoption" items="${ranksOptionsList}">
											<tr>
												<th class="text-center" width="320"><b>${rankoption.name}</b></th>
												<td><img src="static/images/${rankoption.helper}.png"
													width="24" height="24" /></td>
												<td><img
													src="static/images/${rankoption.moderator}.png" width="24"
													height="24" /></td>
												<td><img src="static/images/${rankoption.admin}.png"
													width="24" height="24" /></td>
												<td><img src="static/images/${rankoption.operator}.png"
													width="24" height="24" /></td>
											</tr>
										</c:forEach>
									</table>

								</td>
							</tr>
						</table>
					</c:when>
					<c:when test="${display == 'VOTING'}">

						<table class="gocenter text-center" width="1200" border="0">
							<tr>

								<c:forEach var="vote" items="${votingList}">
									<td><span><b>${vote.title}</b></span></td>
								</c:forEach>
							</tr>

							<tr>

								<c:forEach var="vote" items="${votingList}">
									<td><a href="${vote.votelink}" target="_blank"><img
											src="static/images/${vote.imglink}.png" width="240"
											height="210"></a></td>
								</c:forEach>
							</tr>
						</table>

					</c:when>

				</c:choose>


				<div class="footer-down">
					<p class="text-muted credit">
						Powered by <a href="http://nasticraft.ro">TyCy</a> | &copy; 2017 <a
							href="http://nasticraft.ro">Nasticraft</a>
					</p>
				</div>
			</div>

		</c:when>
	</c:choose>

</body>
</html>
