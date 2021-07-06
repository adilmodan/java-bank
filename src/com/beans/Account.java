package com.beans;

public class Account {
		private String accountId, customerId, type, status, lastTransaction;
		private Double balance;
		
		public String getAccountId() {
			return accountId;
		}
		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getLastTransaction() {
			return lastTransaction;
		}
		public void setLastTransaction(String lastTransaction) {
			this.lastTransaction = lastTransaction;
		}
		public Double getBalance() {
			return balance;
		}
		public void setBalance(Double balance) {
			this.balance = balance;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Account [accountId=");
			builder.append(accountId);
			builder.append(", customerId=");
			builder.append(customerId);
			builder.append(", type=");
			builder.append(type);
			builder.append(", status=");
			builder.append(status);
			builder.append(", lastTransaction=");
			builder.append(lastTransaction);
			builder.append(", balance=");
			builder.append(balance);
			builder.append("]");
			return builder.toString();
		}
		
		
	
	
}
