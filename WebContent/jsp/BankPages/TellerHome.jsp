<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 
	Points for Integration:
	1.Rename this file to JSP When integrating and uncomment the JSP Tags.
	2. Add the required imports when the servlets are implemented. For Example Customer Class
	3. Remove the placeholder data once the backend is setup.
	4.The Table expects a ArrayList<Customer> objects to populate the data in the table. And also add all the
	  actions and hrefs once those functionalities are done.
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/CreateCustomerBody.css">
<title>Teller Home</title>
</head>
<body>

	<div class="container">
		
		<!-- change
		** added header as a partial **
		 -->
		 
		<div class="header">
			<!-- header -->
			<jsp:include page="../partials/header.jsp" />
		</div>
		
		
		<!-- change
		**Nest nav in div**
		 -->
		 
		<div class = "nav">
			<jsp:include page="../partials/tellerMenu.jsp" />
		</div>
		
		<!--  change end -->
				
		<div class="home-body">
		
			<!-- change
			class="page-title-section" 
			also nested title in <h3><h3>
			-->
			
			<div class="page-title-section"><h3>Active Customers</h3></div>
			
			<!--  change end -->
						
			<table class="home-body-table">
				<tr>
					<th>Customer ID</th>
					<th>Name</th>
					<th>SSN</th>
					<th>Actions</th>
				</tr>
				<!--
				Uncomment the below JSP when we have the servlet information.
				-->
				<c:forEach var="customer" items="${customers}">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.firstName} ${customer.lastName}</td>
							<td>${customer.ssn }</td>
							<td>
								<form method="POST" onsubmit="">
									<input type="hidden" name="customerId" value="${customer.id}">
									
									<input class="table-button" type="submit" value="Edit">
								</form>
								<form method="POST" action="${pageContext.request.contextPath}/CustomerReadServlet/viewCustomer" onsubmit="" >
									<input type="hidden" name="customerId" value="${customer.id}">
									<input class="table-button" type="submit" value="DepositWithdraw">
								</form>
							</td>
						</tr>
						</c:forEach>
				
				
				<!-- Placeholder Data to test the styles -->
				
			</table>
			
			<a href=""><button class="home-body-button">Refresh</button></a>
		</div>
		
		<!-- changed
		** added footer as a partial **
	 	-->
		<div class="footer">
			<!-- footer -->
			<jsp:include page="../partials/footer.jsp" />
		</div>
		
		<!--  change end -->
	
	</div>
	

</body>
</html>