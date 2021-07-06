<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/DeleteCustmer.css">
<meta charset="ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>
	
	<div class="container">
		<div class="header">
			<!-- header -->
			<jsp:include page="../partials/header.jsp" />
		</div>
		
		<div class = "nav">
			<jsp:include page="../partials/ExecutiveMenu.jsp"/>
		</div>
		
		<div class= "home-title">
				Delete Customers
			</div>
		
		<div class="delete-customer-body">
						
			<div class="delete-customer-left-body">
				<div class="delete-left-body-elements">
					<div>Customer ID: ${customer.id} </div>
					
				</div>
				<div class="delete-left-body-elements">
					<div>First Name: ${customer.firstName}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>Last Name: ${customer.lastName}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>SSN: ${customer.ssn}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>DOB: ${customer.dob}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>Address Line 1 : ${customer.address1}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>Address Line 2 : ${customer.address2}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>City : ${customer.city}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>State : ${customer.state}</div>
				</div>
				<div class="delete-left-body-elements">
					<div>Zipcode: ${customer.zipCode}</div>
				</div>
				
				
							
				
			</div>
			
			<div class="delete-customer-right-body">
				<div class="delete-right-header">Accounts</div>
				<table class="delete-customer-account-table">
					<tr>
						<th>Account ID</th>
						<th>Account Type</th>
						<th>Account Status</th>
						<th>Balance</th>
						<th>Last Transaction</th>
					</tr>
					<c:forEach var="account" items="${accounts}">
						<tr>
							<td>${account.accountId}</td>
							<td>${account.type }</td>
							<td>${account.status }</td>
							<td>${account.balance }</td>
							<td>${account.lastTransaction}</td>
						</tr>
					</c:forEach>
					<tr>
						<th>10000001</th>
						<th>Checking</th>
						<th>Open</th>
						<th>1000</th>
						<th>05-24-2021</th>
					</tr>
				</table>
				<form id="delete-account-form"class="delete-account-form" action="${pageContext.request.contextPath}/CustomerWriteServlet/deleteCustomer" method="POST">
					<a href="${pageContext.request.contextPath}/LoginServlet">Cancel</a>
					<input type="hidden" value="${customer.id }" name="customerID">
					<input type="button" value="Delete" onclick="confirmDeletion()">
				</form>
			</div>
		</div>
		
		<script>
			function confirmDeletion(){
				if(confirm("Are you sure you want to delete the Customer")){
					document.getElementById("delete-account-form").submit();
				}
			}
		</script>
		
		<div class="footer">
			<!-- footer -->
			<jsp:include page="../partials/footer.jsp" />
		</div>
		
		
	</div>
	
</body>
</html>