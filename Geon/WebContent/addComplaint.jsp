<!DOCTYPE html>
<html>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 30%;
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 40px;
}
</style>
<body>

<h3>Create Complaint</h3>

<div>
  <form action="UserController" method="post">
  
    <label for="fname">CustomerName</label>
    <input type="text" id="custname" name="CustomerName">

    <label for="lname">CompanyName</label>
    <input type="text" id="compname" name="CompanyName">
 
     <label for="lname">Email</label>
    <input type="text" id="email" name="Email">

    <label for="lname">PhoneNumber</label>
    <input type="text" id="phoneNumber" name="PhoneNumber">

   <label for="lname">TicketRefNumber</label>
    <input type="text" id="ticketNum" name="TicketRefNumber">


    <label for="status">WarrantyStatus</label>
    <select id="status" name="status">
      <option value="inWarranty">InWarranty</option>
      <option value="outWarranty">OutWarranty</option>
    </select>

<label for="supportCategory">SupportCategory</label>
    <input type="text" id="supportCategory" name="SupportCategory">

<label for="range">Severity</label>
    <select id="range" name="Range">
      <option value="inWarranty">High</option>
      <option value="medium">Medium</option>
 <option value="low">Low</option>
    </select>
  
<label for="issueDescription">Issue Description</label>
    <input type="text" id="issueDescription" name="IssueDescription">

<label for="forwardedEmail">Forwarded Email</label>
    <input type="text" id="forwardedEmail" name="ForwardedEmail">

<label for="Remarks">Remarks</label>
    <input type="text" id="remarks" name="Remarks">

    <input type="submit" value="Submit">
  </form>

<script type="text/javascript">
	var ticketNumber = "${TicketRefNumber}";
	document.getElementById("ticketNum").value = ticketNumber;
</script>
</div>

</body>
</html>
