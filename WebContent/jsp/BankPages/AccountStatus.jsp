<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styleSheet.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/AccountStatus.css">
<meta charset="ISO-8859-1">
<title>Account Status</title>

</head>
<body>
	
	<div class="container">
		
		<c:if test="${userRole != 'Executive'}">
			<h1>Access Denied</h1>
		</c:if>
	
		<c:if test="${userRole == 'Executive'}">
			<div class="header">
				<!-- header -->
				<jsp:include page="../partials/header.jsp" />
			</div>
			
			<div class = "nav">
			<jsp:include page="../partials/ExecutiveMenu.jsp" />
			</div>
			
			<div class="account-status-body">
				<div class="account-status-title">
					Account Status
				</div>
				<c:if test="${not empty accounts}">
					<table class="account-status-table">
						<tr>
							<th>Customer ID</th>
							<th>Account ID</th>
							<th>Account Type</th>
							<th>Account Status</th>
							<th>Balance</th>
							<th>Last Transaction</th>
						</tr>
						
						<c:forEach var="account" items="${accounts }">
							<tr>
								<td>${account.customerId }</td>
								<td>${account.accountId }</td>
								<td><c:if test="${account.type == 'C' }">
										Checking
									</c:if>
									<c:if test="${account.type == 'S' }">
										Savings
									</c:if></td>
								<td>
									<c:if test="${account.status == 'O' }">
										Open
									</c:if>
									<c:if test="${account.status == 'C' }">
										<p style = "color:red" >Closed</p>
									</c:if>
								</td>
								<td>$ ${account.balance }</td>
								<td>${account.lastTransaction }</td>
							</tr>
						
						</c:forEach>
						
						
					</table>
				</c:if>
				<c:if test="${ empty accounts }">
					<div class="account-status-no-data">No Data Available</div>
				</c:if>
				
				<a href="/AccountStatus.jsp"><button>Refresh</button></a>
			</div>
			
			<div class="footer">
				<!-- footer -->
				<jsp:include page="../partials/footer.jsp" />
			</div>
		</c:if>
	
	</div>
	
</body>
</html>