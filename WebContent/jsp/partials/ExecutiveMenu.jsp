<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<script>
	function getStatusPage(){
		var selection = document.getElementById("statusPageId").value;
		
		if (selection == "allCustomerDetails"){
			document.forms[1].action = "${pageContext.request.contextPath}/CustomerReadServlet/customerStatus";
			document.forms[1].submit();
		
		}
			
		else if(selection =="allAccountDetails"){
			document.forms[1].action = "${pageContext.request.contextPath}/AccountReadServlet/accountStatus";
			document.forms[1].submit();
		}
		
		
	}
	
	


</script>
</head>


<nav class="nav-bar">
	<a class="nav-element" href="${pageContext.request.contextPath}/LoginServlet">Home</a>
	<a class="nav-element" href="${pageContext.request.contextPath}/jsp/BankPages/CreateCustomer.jsp">Create Customer</a>
	
	<!-- change
	**added class = "search-by-form"**
	 -->
	<form class = "search-by-form" action="${pageContext.request.contextPath}/CustomerReadServlet/searchCustomer" method="POST">
		<select class="nav-dropdown" name="search-criteria" id ="searchId">
			<option value="SSN">SSN</option>
			<option value="lastName">Last Name</option>
			<option value="customerId">Customer ID</option>
		</select>
		<input type="text" name="search-text" id ="searchString">
		
		<input class = "exc-menu-button" type="submit" value="Search">
	</form>
	
	
	<form class = "status-form" action="" method="POST">
		<select id = "statusPageId" class="nav-status-details" name="status-details" onchange="getStatusPage()">
			<option value="statusDetails">Status Details</option>
			<option value="allAccountDetails">All Account Details</option>
			<option value="allCustomerDetails">All Customer Details</option>
		</select>
	</form>
	

	<a href="${pageContext.request.contextPath}/LogoutServlet" class="nav-element">Logout</a>
</nav>