<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
<title>Grad Novi Sad</title>
</head>
<body style="background-image: url('css/images/noviSad.jpg');" onload="proveriValidnost()">
<div class="container">
	<div class="col-sm-2">
		<nav class="nav-sidebar">
				<ul class="nav">
                    <li><a href="HomePagePresident.jsp">Usvojeni Akti</a></li>
                    <li><a href="ActsInProgressPresident.jsp">Akti u proceduri</a></li>
                    <li><a href="NewActPresident.jsp">Novi akt</a></li>
                      <li><a href="ResultsPresident.jsp">Sjednica</a></li>
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
		
		<div class="items">
			<c:forEach var="amandman" items="${amandmani}">
				<div class="item">
					<div>
					<br/>
						&nbsp; <b>${amandman.key}</b>
					</div>
					<div class="openPerspective">
						<table>
							 <tr>
								<td>
									<form action="PdfGenerator" method="post">
									<input type="hidden" name="fileName" value="${amandman.key}">
									<input type="hidden" name="fileUri" value="${amandman.value}">
									&nbsp;<input type="image" alt="submit" src="css/images/pd.png" width="30">
									</form>
								</td>
								<td>
									<form action="XmlGenerator" method="post" >
									<input type="hidden" name="fileName" value="${amandman.key}">
									<input type="hidden" name="fileUri" value="${amandman.value}">
									&nbsp;<input type="image" alt="submit" src="css/images/xm.png" width="30">
									</form>
								</td>
								<td>
									<form action="HtmlGenerator" method="post" >
									<input type="hidden" name="fileName" value="${amandman.key}">
									<input type="hidden" name="fileUri" value="${amandman.value}">
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
</body>
</html>