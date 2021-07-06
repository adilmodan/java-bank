<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/CreateCustomerBody.css">
<meta charset="ISO-8859-1">
<title>Create New Customer</title>
</head>
<body>

<div class="container">
		
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
		
		

		<div class="home-body">
			<div class="home-body-title">Create Customer</div>
			<form action="${pageContext.request.contextPath}/CustomerWriteServlet/createCustomer" method="POST" onsubmit="return validate()">
				<label>First Name</label><br>
				<input type="text" name="firstName" id="createCustomerFirstName"><br>
				<p style="color:red" id="error_firstName"></p>
				<label>Last Name</label><br>
				<input type="text" name="lastName" id="createCustomerLastName"><br>
				<p style="color:red" id="error_lastName"></p>
				<label>SSN:</label><br>
				<input type="text" name="SSN" id="createCustomerSSN"><br>
				<p style="color:red" id="error_SSN"></p>
				<label>Date of Birth</label><br>
				<input type="date" name="dob" id="createCustomerDOB"><br>
				<label>Address Line 1</label><br>
				<input type="text" name="addressLine1" id="createCustomerAddressLine1"><br>
				<p style="color:red" id="error_addressLine1"></p>
				<label>Address Line 2</label><br>
				<input type="text" name="addressLine2" id="createCustomerAddressLine2"><br>
				<p style="color:red" id="error_addressLine2"></p>
				<label>City</label><br>
				<input type="text" name="city" id="createCustomerCity"><br>
				<p style="color:red" id="error_city"></p>
				<select name="state" id="createCustomerState">
					<option value="unknown">Select State</option>
					<option value="Texas" id="defaultState" >Texas</option>
					<option value="California">California</option>
					<option value="New York">New York</option>
				</select><br>
				<p style="color:red" id="error_state"></p>
				<label>Zip Code</label><br>
				<input type="text" name="zipCode" id="createCustomerZipCode"><br>
				<p style="color:red" id="error_zipCode"></p>
				<input type="submit" value="Save">
				<p style="color:red" id="error_NoAdd">${operationResult}</p>
				<input type="button" value="Reset" onclick="reset1()"><br>
			</form>
		</div>
		
		<script type="text/javascript">
			function validate(){
				let firstName = document.getElementById("createCustomerFirstName").value;
				let lastName = document.getElementById("createCustomerLastName").value;
				let ssn = document.getElementById("createCustomerSSN").value;
				let addressLine1 = document.getElementById("createCustomerAddressLine1").value;
				let addressLine2 = document.getElementById("createCustomerAddressLine2").value;
				let city = document.getElementById("createCustomerCity").value;
				let zipCode = document.getElementById("createCustomerZipCode").value;
				let state = document.getElementById("createCustomerState").value;
				
				let anyErrors = false;
				// First Name Validation
				if(!/^[a-z]+$/i.test(firstName)){
					anyErrors = true;
					document.getElementById("error_firstName").innerHTML = "First Name Invalid"
				}else{
					document.getElementById("error_firstName").innerHTML = ""
				}
				
				// Last Name Validation
				if(!/^[a-z]+$/i.test(lastName)){
					anyErrors = true;
					document.getElementById("error_lastName").innerHTML = "Last Name Invalid"
				}else{
					document.getElementById("error_lastName").innerHTML = ""
				}
				
				//SSN Validation
				if(false)){
					anyErrors = true;
					document.getElementById("error_SSN").innerHTML = "Invalid SSN. SSN must be in this formant : 000-00-0000"
				}else{
					document.getElementById("error_SSN").innerHTML = ""
				}
				
				//Address Line 1
				if(addressLine1.length==0){
					anyErrors = true;
					document.getElementById("error_addressLine1").innerHTML = "Address Is Required"
				}else{
					document.getElementById("error_addressLine1").innerHTML = ""
				}
				
				//Address Line 2
				if(addressLine2.length==0){
					anyErrors = true;
					document.getElementById("error_addressLine2").innerHTML = "Address Is Required"
				}else{
					document.getElementById("error_addressLine2").innerHTML = ""
				}
				
				//City Validation
				if(!/^[a-z]+$/i.test(city)){
					anyErrors = true;
					document.getElementById("error_city").innerHTML = "City Name Invalid"
				}else{
					document.getElementById("error_city").innerHTML = ""
				}
				
				// Zip Code Validation
				if(!/^[0-9]{5}$/.test(zipCode)){
					anyErrors = true;
					document.getElementById("error_zipCode").innerHTML = "Invalid Zip Code"
				}else{
					document.getElementById("error_zipCode").innerHTML = ""
				}
				
				// State Validation
				if(state==="unknown"){
					anyErrors = true;
					document.getElementById("error_state").innerHTML = "Please Select a State"
				}else{
					document.getElementById("error_state").innerHTML = ""
				}
				
				if(anyErrors){
					return false
				}else{
					return true
				}
			}
			
			function reset1(){
				//console.log("Reset Errors")
				document.getElementById("createCustomerFirstName").value = ""
				document.getElementById("createCustomerLastName").value = ""
				document.getElementById("createCustomerSSN").value = ""
				document.getElementById("createCustomerAddressLine1").value = ""
				document.getElementById("createCustomerAddressLine2").value = ""
				document.getElementById("createCustomerCity").value = ""
				document.getElementById("createCustomerZipCode").value = ""
				document.getElementById("createCustomerDOB").value=""
				document.getElementById("createCustomerState").selectedIndex=0
				//console.log("Reset Errors")
				document.getElementById("error_firstName").innerHTML = ""
				document.getElementById("error_lastName").innerHTML = ""
				document.getElementById("error_SSN").innerHTML = ""
				document.getElementById("error_addressLine1").innerHTML = ""
				document.getElementById("error_addressLine2").innerHTML = ""
				document.getElementById("error_city").innerHTML = ""
				document.getElementById("error_zipCode").innerHTML = ""
				document.getElementById("error_state").innerHTML = ""
				document.getElementById("error_NoAdd").innerHTML = ""
				
			}
		</script>
		
		
		
		
		<div class="footer">
			<div class="footer-element">
				<div class="footer-title">
					About Us
				</div>
				<div class="footer-body">
					FedBank Choice Bank was founded on June 14, 2016 with objective of supporting local businesses and customers.
				</div>
			</div>
			
			<div class="footer-element">
				<div class="footer-title">
					Services
				</div>
				<div class="footer-body">
					Personal Banking.
					Business Banking.
					Credit and Debit Cards.
				</div>
			</div>
			
			<div class="footer-element">
				<div class="footer-title">
					Contact Us
				</div>
				<div class="footer-body">
					Email: customer.service@fedchoice.com
					Phone:1-800-555-1234
					Address: 1 Fed Way, Walla Walla, WA, 99362
				</div>
			</div>
		</div>

</div>

</body>
</html>