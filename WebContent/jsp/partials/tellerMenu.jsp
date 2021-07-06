<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
</head>

<nav class="nav-bar">
		
	<a class="nav-element" href="${pageContext.request.contextPath}/LoginServlet">Home</a>
	
	<form class = "teller-search-by-form" action="${pageContext.request.contextPath}/CustomerReadServlet/searchCustomer" method="POST">
		<select class="nav-dropdown" name="search-criteria">
			<option value="SSN">SSN</option>
			<option value="customerId">Customer ID</option>
			<option value="accountId">Account ID</option>
		</select>
		<input type="text" name="search-text">
		
		<!-- change
		**added class = "teller-menu-button"**
		 -->
		<input class = "teller-menu-button" type="submit" value="Search">
	</form>
	
	<a href="${pageContext.request.contextPath}/LogoutServlet" class="nav-element">Logout</a>
</nav>