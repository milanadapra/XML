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
                    <li><a href="HomePagePresident.jsp">Usvojeni Akti</a></li>
                    <li><a href="ActsInProgressPresident.jsp">Akti u proceduri</a></li>
                    <li><a href="NewActPresident.jsp">Novi akt</a></li>
                      <li><a href="ResultsPresident.jsp">Sjednica</a></li>
                    <li class="nav-divider"></li>
                   	<li>
						<a>
                    		<form action="LogoutServlet" method="post">
                    			<button class="btn btn-primary">
                    				${currentUser.username} <input type="image" alt="submit" src="css/images/out.png" width="20">
                    			</button>
                    		</form>
                    	</a>                  
                     </li>
                </ul>
		</nav>
	</div>
	
	<div class="content">
		<div>
			<form action="SetSjednicaOn" method="post" >
			Započnite sjednicu, u tom periodu se neće moći predlagati novi akti i amandmani.<br/>
				<input type="hidden" name="sjednica" value="${sjednica}">
				<input type="submit" value="Započni sjednicu" width="30" <c:if test="${sjednica == true}"><c:out value="disabled='disabled'"/></c:if>>
			</form>
			<br/>
			<form action="SetSjednicaOff" method="post" >
			Završite sjednicu, opet će se moći predlagati novi akti i amandmani.<br/>
				<input type="hidden" name="sjednica" value="${sjednica}">
				<input type="submit" value="Završi sjednicu" width="30" <c:if test="${sjednica == false}"><c:out value="disabled='disabled'"/></c:if>>
			</form>
		</div>
		<br/>
		<div class="items" style="width: 90%;">
			<div style="position: absolute; left:2%; width:54%;">
			<h3>Akti</h3>
			<c:forEach var="akt" items="${aktiUproceduri}">
				<div class="item" style="width: 100%;">
					<div>
					<br/>
						&nbsp; <b>${akt.key}</b>
					</div>
					<div class="openPerspective">
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
							<tr>
								<td colspan="3">
								<form action="ResultServlet" method="post">
									<input type="hidden" name="fileUri" value="${akt.value}">
									<input type="text" name="za" placeholder="Za" size="5"/>
									<input type="text" name="protiv" placeholder="Protiv" size="5"/>
									<input type="image" alt="submit" src="css/images/check.png" width="20">
							</form>
							</td>
							</tr>
						</table>
					</div>
					
				</div>
				<br/>
			</c:forEach>
			</div>
			<div style="position: absolute; left: 60%; width:54%;">
			<h3>Amandmani</h3>
			<c:forEach var="amandman" items="${amandmani}">
				<div class="item"  style="width: 90%;">
					<div>
					<br/>
						&nbsp; <b>${amandman.key}</b>
					</div>
					<div class="openPerspective" style="left: 60%;">
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
							<tr>
								<td colspan="3">
								<form action="ResultServlet">
									<input type="hidden" name="fileUri" value="${amandman.value}">
									<input type="text" name="za" placeholder="Za" size="5"/>
									<input type="text" name="protiv" placeholder="Protiv" size="5"/>
									<input type="image" alt="submit" src="css/images/check.png" width="20">
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
</div>
</body>
</html>