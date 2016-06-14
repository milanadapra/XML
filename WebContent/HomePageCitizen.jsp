<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
<title>Grad Novi Sad</title>
</head>
<body style="background-image: url('css/images/noviSad.jpg');">
<div class="container">
	<div class="col-sm-2">
		<nav class="nav-sidebar">
				<ul class="nav">
                    <li><a href="HomePageCitizen.jsp">Usvojeni Akti</a></li>
                    <li><a href="ActsInProgressCitizen.jsp">Akti u proceduri</a></li>
                    <li class="nav-divider"></li>
                   <li><a>
                    		<form action="LogoutServlet" method="post">
                    			<button class="btn btn-primary">
                    				${currentUser.username} <input type="image" alt="submit" src="css/images/out.png" width="20">
                    			</button>
                    		</form>
                    	</a></li>
                </ul>
		</nav>
	</div>
	
	<div class="content">
		<div style="position:absolute; left: 75%;">
		 <form action="BrowseSearchServlet" method="post">
		 		<ul class="nav">
		 		 	<li><a><input type="text" name="sadrzaj" placeholder="Sadrzaj"/></a></li>
                    <li><a><input type="text" name="imeAkta" placeholder="Naziv akta"/></a></li>
                    <li><a><input type="text" name="predlozio" placeholder="Ime predlagaca"/></a></li>
                    <li><a>Datum predlaganja<input type="date" name="datumPredlaganjaOd"/>
   						<input type="date" name="datumPredlaganjaDo"/></a></li>
   					 <li><a>Datum odbijanja<input type="date" name="datumOdbijanjaOd"/>
   						<input type="date" name="datumOdbijanjaDo"/></a></li>
   					 <li><a>Datum usvajanja<input type="date" name="datumUsvajanjaOd"/>
   						<input type="date" name="datumUsvajanjaDo"/></a></li>
                    <li class="nav-divider"></li>
                   <li><a>
                   		<input type="submit" value="Pretraga" class="btn btn-primary"/></a></li>
                </ul>
	     </form>
		</div>
		<br/>
		<div class="items">
			<c:forEach var="akt" items="${usvojeniAkti}">
			<div class="item">
					<div>
					<br/>
						&nbsp; <b>${akt.key}</b>
					</div>
					<div class="openPerspective" >
						<table>
							 <tr>
								<td>
									<form action="PdfGenerator" method="post">
									<input type="hidden" name="fileName" value="${akt.key}">
									<input type="hidden" name="fileUri" value="${akt.value}">
									&nbsp;<input type="image" alt="submit" src="css/images/pd.png" width="30">
									</form>
								</td>
								<td>
									<form action="XmlGenerator" method="post" >
									<input type="hidden" name="fileName" value="${akt.key}">
									<input type="hidden" name="fileUri" value="${akt.value}">
									&nbsp;<input type="image" alt="submit" src="css/images/xm.png" width="30">
									</form>
								</td>
								<td>
									<form action="HtmlGenerator" method="post" >
									<input type="hidden" name="fileName" value="${akt.key}">
									<input type="hidden" name="fileUri" value="${akt.value}">
									&nbsp;<input type="image" alt="submit" src="css/images/ht.png" width="30">
									</form>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<br/>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>