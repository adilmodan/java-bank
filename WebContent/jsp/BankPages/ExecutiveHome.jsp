<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

<title>Executive Home</title>
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
		
		<!--  change end -->
		
		<!-- change
		**Nest nav in div
		**also put nav<> into excutiveMenu.jsp**
		 -->
		<div class = "nav">
			<jsp:include page="../partials/ExecutiveMenu.jsp" />
		</div>
		<!-- Change end -->
		
		
		<div class="home-body">
			<!-- change
			class="page-title-section" -->
			
			<div class="page-title-section"><h3>Active Customers</h3></div>
			
			<!--  change end -->
			
			<table class="home-body-table">
				<tr>
					<th>Customer ID</th>
					<th>Name</th>
					<th>SSN</th>
					<th>Last Updated</th>
					<th>Actions</th>
				</tr>
				<!--
				Uncomment the below JSP when we have the servlet information.-->
				
				<c:forEach var="customer" items="${customers}">
						<tr>
							<td>${customer.id}</td>
							<td>${customer.firstName} ${customer.lastName}</td>
							<td>
								###-##-${fn:substring(customer.ssn,5,9)}								
								</td>
							<td> ${customer.lastUpdated}</td>
							<td>
								<form action="${pageContext.request.contextPath}/CustomerReadServlet/updateCustomer" method="POST">
									<input type="hidden" name="customerId" value="${customer.id}">
									<input class="table-button" type="submit" value="Edit">
								</form>
								<form action="${pageContext.request.contextPath}/CustomerReadServlet/deleteCustomer" method="POST">
									<input type="hidden" name="customerId" value="${customer.id}">
									<input class="table-button" type="submit" value="Delete">
								</form>
							</td>
						</tr>
				</c:forEach>
				
				

				 
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