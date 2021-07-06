<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<link rel="styleSheet" href="${pageContext.request.contextPath}/css/CreateCustomerBody.css">
<title>Teller Account</title>
</head>
<body>

		<div class="header">
			<!-- Header Partial -->
			<jsp:include page="../partials/header.jsp" />
		</div>
		
		<div class="nav">
			<jsp:include page="../partials/ExecutiveMenu.jsp" />
		</div>
		<div class="home-body">
			<div class="Account-section">
				<h3 class="accounts-header">Accounts</h3>
				
 			<c:if test="${accounts.size() > 0}">
				
				<table class="accounts-update-page" style="empty-cells:hide;">
					<thead>
						<tr>
							<th>Account ID</th>
							<th>Account Type</th>
							<th>Account Status</th>
							<th>Balance</th>
							<th>Last Transaction</th>
							<th>Action</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="account" items="${accounts}">
							<tr>
							      <td>
									${account.accountId}
								  </td>
								  <td>
									${account.type}
								  </td>
								  <td>
								  	${account.status}
								  </td>
								  <td>
								  	${account.balance}
								  </td>	
								  <td>
									${account.lastTransaction}
								  </td>	
								 
								  
								  <td>
								<form method="POST" onsubmit="">
									<input type="hidden" name="customerId" value="${customer.id}">
									<input class="table-button" type="submit" value="Transaction">
								</form>
								<form method="POST">
									<input type="hidden" name="customerId" value="${customer.id}">
									<input class="table-button" type="submit" value="Statements">
								</form>
							</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				 
				 
				</c:if>  
 				
		
				</div>
				
				<div>
			
					<label >Customer ID: </label> ${customer.id}
					<br>
					
					<label>First Name: </label>  ${customer.firstName}
					<br>
					
					<label>Last Name: </label> ${customer.lastName}
					<br>
					
					<label>SSN: </label> ${fn:substring(customer.ssn,0,3)}-${fn:substring(customer.ssn,3,5)}-${fn:substring(customer.ssn,5,9)}
					<br>				
					
					<label>DOB: </label> ${customer.dob}
					<br>
					
					<label>Address Line 1: </label>  ${customer.address1}
					<br>
					
					
					<label>Address Line 2: </label> ${customer.address2}
					<br>
					
					<label>City: </label> ${customer.city}
					<br>
										
					<label>State: </label> ${customer.state}
					<br>
					
					
					<label>Zip Code: </label> ${customer.zipCode}
					<br>
					
					<input type="button" value="Cancel" onclick="window.location.href='${pageContext.request.contextPath}/jsp/BankPages/TellerHome.jsp'">
				</div>
							
			</div>

</body>
</html>