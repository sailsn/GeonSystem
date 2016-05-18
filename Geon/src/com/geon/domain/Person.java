package com.geon.domain;



//Each class in this package represents the database table.
public class Person {

	private String status  ;
	

	private String companyName;
	private String email;
	private int phoneNumber;
	private int ticketRefNumber;
	private String warrantyStatus;
	private String supportCategory;
	private String severity;
	private String issueDescription;
	private String forwardedEmail;
	private String remarks;
	private String customerName;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getTicketRefNumber() {
		return ticketRefNumber;
	}

	public void setTicketRefNumber(int ticketRefNumber) {
		this.ticketRefNumber = ticketRefNumber;
	}

	public String getWarrantyStatus() {
		return warrantyStatus;
	}

	public void setWarrantyStatus(String warrantyStatus) {
		this.warrantyStatus = warrantyStatus;
	}

	public String getSupportCategory() {
		return supportCategory;
	}

	public void setSupportCategory(String supportCategory) {
		this.supportCategory = supportCategory;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	public String getForwardedEmail() {
		return forwardedEmail;
	}

	public void setForwardedEmail(String forwardedEmail) {
		this.forwardedEmail = forwardedEmail;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Person [TicketRefNumber=" + ticketRefNumber + ", CustomerName=" + customerName + ", CompanyName="
				+ companyName + ", Email=" + email + ", PhoneNumber=" + phoneNumber + ",WarrantyStatus="
				+ warrantyStatus + ",SupportCategory=" + supportCategory + ",Severity=" + severity
				+ ",IssueDescription=" + issueDescription + ",ForwardedEmail=" + forwardedEmail + ",Remarks=" + remarks
				+ ",]";
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}

