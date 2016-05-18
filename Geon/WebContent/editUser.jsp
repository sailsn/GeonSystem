


<!DOCTYPE html>
<html>
<style>
input[type=text], select {
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	display: block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 50%;
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

	<h2>Edit User</h2>

	<div>
		<form action="AdminController" method="post">
			<label for="fname">First Name</label> <input type="text" id="fname"
				name="firstName" value="${user.firstName}" /><br> <label
				for="lname">Last Name</label> <input type="text" id="lname"
				name="lastName" value="${user.lastName}" /> <br> <label
				for="email">Email</label> <input type="text" id="email" name="email"
				value="${user.email}" /> <br> <label for="phoneNumber">Phone
				Number</label> <input type="text" id="phoneNumber" name="phoneNumber"
				value="${user.phoneNumber}" /> <label for="joiningDate">Joining
				Date</label> <input type="date" id="date" name="joiningDate"
				value="${user.joiningDate}" /> <br> <label for="country">Experience</label>
			<select id="experience" name="experience" >
				<option value="0">0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select> <label for="education">Education</label> <input type="text"
				id="education" name="education" value="${user.education}" /> 
			<input type="submit"  value="Update">
				                     
				 
				<%-- <a href="/Geon/AdminController?action=update&email=${user.email}&firstName=${user.firstName}&lastName=${user.lastName}&phoneNumber=${user.phoneNumber}&joiningDate=${user.joiningDate}&experience=${user.experience}&education=${user.education}">Update</a> --%>
		</form>

	</div>
	<script type="text/javascript">
		var exp= "${user.experience}";
		var email = "${user.email}";
		exp =2;
		var expId = document.getElementById("experience");
		expId.options[exp].selected = true;
	</script>
</body>
</html>





































