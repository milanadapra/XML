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
<script type="text/javascript">
			function proveriValidnost()
			{
				var valid = document.getElementsByName("valid")[0].value;
				var notValid = document.getElementsByName("notValid")[0].value;
				var reason = document.getElementsByName("reason")[0].value;
			    if(valid != "")
					alert(valid + " and was insert in database.");
			    else if(notValid != "")
			    	alert(notValid + "\n" + reason);
			}
</script>
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
		<form action="UploadAct" method="post" enctype="multipart/form-data">
					<input type="file" name="uploadFile" size="30" />
					<input type="hidden" name="valid" value="${valid}" size="30" />
					<input type="hidden" name="notValid" value="${notValid}" size="30" />
					<input type="hidden" name="reason" value="${reason}" size="30" />
					<input type="hidden" name="user" value="${currentUser.role}" size="30" />
					<input type="submit" value="Dodaj" width="30">
			</form>
		
		<form action="AddNewAct" method="post" id="xmltext">
		 			Naziv akta: <input type="text" name="filename" />
		 			<input type="hidden" name="user" value="${currentUser.role}" size="30" />
					<input type="submit" value="Dodaj akt" width="30">
			</form>
			<br/>
			<textarea form ="xmltext" placeholder="Unesi sadrzaj akta..." name="tekst" id="taid" rows= "35" cols="128" wrap="soft"></textarea>
	
	</div>
</div>
</body>
</html>