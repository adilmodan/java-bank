<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<title>Login CSS Demo</title>
</head>
<body>

<div class = "container">
	
	<div class = "header">
		<!-- header -->
		<jsp:include page="jsp/partials/header.jsp" />
	</div>
	
	<!-- partial menu -->
	<div class = "login-nav">
		<jsp:include page="jsp/partials/loginMenu.jsp" />
	</div>
		
	<div class = "login-body">
		<div class = "page-title-section">
			<h3>Please login to access</h3>
		</div>
		
		<!-- input fields and button-->
		<form name="loginForm" method= 'post'>
			<label class = "usernameLabel">Username</label> <input id='username' type='text' name='username' placeholder = "Enter Username" required/> <br />
			<label class = "passwordLabel">Password</label> <input id='password' type='password' name='password' placeholder = "Enter Password" required/><br /> 
			
			<input type='button' value='Login' onclick = 'verifyLogin()'/>
		</form>
	</div>
	
	<label id='error'>${message}</label>
	
	<!-- footer -->
	<div class = "footer">
		<jsp:include page="jsp/partials/footer.jsp" />
	</div>
	
</div>
</body>
<script>
window.onload = function() {
    if(${userRole != null}){
    	window.location.href = "${pageContext.request.contextPath}/LoginServlet";
    }
 }
 
function verifyLogin(){
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var errorLabel = document.getElementById('error');
	var usernamePattern = /^[a-z\d]{8,}$/i;
	var passwordPattern = /^[a-z\d*#\?\&\!]{10,}/i;
	if (!username.match(usernamePattern)){
		errorLabel.innerHTML = 'Invalid username or password!!';
	}
	else if (!password.match(passwordPattern)){
		errorLabel.innerHTML = 'Invalid username or password!!';
	}
	else{
		document.forms[0].action = "${pageContext.request.contextPath}/LoginServlet";
		document.forms[0].submit();
	}
}
</script>
</html>