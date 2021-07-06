<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<title>Update Customer Page</title>
</head>
<body>
	<c:choose>
		<c:when test="${userRole=='Executive'}"> 
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
				<div class="page-title-section">
					<h3>View/Edit Customer</h3>
				</div>
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
									<c:out value = "${account.accountId}"/>
								  </td>
								  <td>
									<c:out value = "${account.type}"/>
								  </td>
								  <td>
								  	<c:out value = "${account.status}"/>
								  </td>
								  <td>
								  	<c:out value = "${account.balance}"/>
								  </td>	
								  <td>
									<c:out value = "${account.lastTransaction}"/>
								  </td>	
								  
							</tr>
						</c:forEach>
					</tbody>
				</table>
 				</c:if>
				<input type="button" class="create-account-button" id="createAccountButton" value="Create New Account" onclick="toggleCreateAccount()"/>
				
				<div class="create-account" id="createAccountDiv" style="display: none;">
				
					<h3>Create Account</h3><br>
					
					<form action="" method="POST" onsubmit="toggleCreateAccount()">
						<label>Customer ID: ${customer.id}</label><br>
						
						<label>select account type:</label>
						<select name="accountType">
							<option value="savings">savings</option>
							<option value="checkings">checkings</option>
						</select><br>
						
						<label>Deposit Amount:</label>
						<input type="text" name="depositAmount"/><br>
						
						<div class="create-account-form-buttons">
							<input type="button" value="Cancel" onclick="toggleCreateAccount()">
						    <input type="button" value="Save" onclick="toggleCreateAccount()">
						</div>
					</form>
				</div>
			</div>
				<form action="${pageContext.request.contextPath}/CustomerWriteServlet/updateCustomer" method="POST" onsubmit="return validateUpdateInputs()">
					<label>Customer ID:</label>
					<input type='text' name='customer_id' value="${customer.id}" readonly/><br>
					
					<label>First Name:</label>
					<input type="text" name="firstName" id="updateCustomerFirstName" value="${customer.firstName}"><br>
					<p style="color:red" id="error_update_first_name"></p>
					
					<label>Last Name:</label>
					<input type="text" name="lastName" id="updateCustomerLastName" value="${customer.lastName}"><br>
					<p style="color:red" id="error_update_last_name"></p>
					
					<label>SSN: ${fn:substring(customer.ssn,0,3)}-${fn:substring(customer.ssn,3,5)}-${fn:substring(customer.ssn,5,9)}</label><input type='hidden' name='SSN' value="${customer.ssn}" readonly><br>
					<label>DOB: ${customer.dob}</label><input type='hidden' name='dob' value="${customer.dob}" readonly><br>
					
					<label>Address Line 1:</label>
					<input type="text" name="addressLine1" id="updateCustomerAddressLine1" value="${customer.address1}"><br>
					<p style="color:red" id="error_update_line1"></p>
					
					<label>Address Line 2:</label>
					<input type="text" name="addressLine2" id="updateCustomerAddressLine2" value="${customer.address2}"><br>
					
					<label>City:</label>
					<input type="text" name="city" id="updateCustomerCity" value="${customer.city}"><br>
					<p style="color:red" id="error_update_city"></p>
					
					<label>State:</label>
					<select name="state" id="updateCustomerState">
						<option value="unknown">Select State</option>
						<option value="Texas" ${customer.state == 'Texas' ? 'selected' : ''}>Texas</option>
						<option value="California" ${customer.state == 'California' ? 'selected' : ''}>California</option>
						<option value="New York" ${customer.state == 'New York' ? 'selected' : ''}>New York</option>
					</select><br>
					<p style="color:red" id="error_update_state"></p>
					
					<label>Zip Code:</label>
					<input type="text" name="zipCode" id="updateCustomerZipCode" value="${customer.zipCode}"><br>
					<p style="color:red" id="error_update_zip"></p>
					
<%-- 					<a href="${pageContext.request.contextPath}/LoginServlet">Cancel</a> --%>
					<input type="button" value="Cancel" onclick="window.location.href='${pageContext.request.contextPath}/LoginServlet'"/>
					<input type="submit" value="Save">
					<p style="color:red" id="error_NoAdd">${operationResult}</p>
				</form>
			</div>
		
			<div class="footer">
				<!-- footer -->
				<jsp:include page="../partials/footer.jsp" />
			</div>	
		</c:when>
		<c:otherwise> <!-- DISPLAY FOR NON EXECUTIVE USERS ACCESSING PAGE -->
			<h1>UNAUTHORIZED ACCESS</h1>
		</c:otherwise>
	</c:choose>
	
	
	
	
	
	
	<script type="text/javascript">
		function validateUpdateInputs(){
			let firstName = document.getElementById("updateCustomerFirstName").value;
			let lastName = document.getElementById("updateCustomerLastName").value;
			let addressLine1 = document.getElementById("updateCustomerAddressLine1").value;
			let addressLine2 = document.getElementById("updateCustomerAddressLine2").value;
			let city = document.getElementById("updateCustomerCity").value;
			let state = document.getElementById("updateCustomerState").value;
			let zip = document.getElementById("updateCustomerZipCode").value;
			
			let anyErrors = false;

			// First Name Validation
			if(!/^[a-z]+$/i.test(firstName)){
				anyErrors = true;
				document.getElementById("error_update_first_name").innerHTML = "First Name Invalid"
			}else{
				document.getElementById("error_update_first_name").innerHTML = ""
			}
			
			// Last Name Validation
			if(!/^[a-z]+$/i.test(lastName)){
				anyErrors = true;
				document.getElementById("error_update_last_name").innerHTML = "Last Name Invalid"
			}else{
				document.getElementById("error_update_last_name").innerHTML = ""
			}
	
			//Address Line 1
			if(addressLine1.length==0){
				anyErrors = true;
				document.getElementById("error_update_line1").innerHTML = "Address Is Required"
			}else{
				document.getElementById("error_update_line1").innerHTML = ""
			}
			
			//City Validation
			if(!/^[a-z]+$/i.test(city)){
				anyErrors = true;
				document.getElementById("error_update_city").innerHTML = "City Name Invalid"
			}else{
				document.getElementById("error_update_city").innerHTML = ""
			}
			
			// Zip Code Validation
			if(!/^[0-9]{5}$/.test(zip)){
				anyErrors = true;
				document.getElementById("error_update_zip").innerHTML = "Invalid Zip Code"
			}else{
				document.getElementById("error_update_zip").innerHTML = ""
			}
			
			// State Validation
			if(state==="unknown"){
				anyErrors = true;
				document.getElementById("error_update_state").innerHTML = "Please Select a State"
			}else{
				document.getElementById("error_update_state").innerHTML = ""
			}
			
			if(anyErrors){
				return false
			}else{
				return true
			}
			
		}
		
		function toggleCreateAccount(){
			let button = document.getElementById("createAccountButton");
			let div = document.getElementById("createAccountDiv");
			
			if (div.style.display !== "block"){
				div.style.display = "block";
				button.style.display = "none";
			}else{
				div.style.display = "none";
				button.style.display = "block";
			}
		}
	</script>
</body>
</html>