<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prijava</title>
</head>
<body>

<div class="row">
	<div class="col-md-offset-5 col-md-3">
		<div class="loginForm">
		<form action="LoginServlet" method="post">
			<img src="css/images/url.gif" width="280">
			<h4>Prijavite se.</h4>
			<input type="text" name="username" class="form-control input-sm chat-input" placeholder="Korisničko ime"/>
			<br/>
			<input type="password" name="password" class="form-control input-sm chat-input" placeholder="Lozinka"/>
			<br/>
			<div class="wrapper">
				<span class="group-btn"> 
				<input type="submit" value="Prijavi se" class="btn btn-primary"/>						
				</span>
				<br/>
				<br/>
			</div>
		</form>
		</div>
     
	</div>
</div>

</body>
</html>