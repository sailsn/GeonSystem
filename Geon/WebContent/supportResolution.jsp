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
	width: 100%;
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

	<h3>Support Resolution</h3>

	<div>
		<form action="UserController" method="post">
			<table>
				<tr>
					<td>TicketRefNumber</td>
					<td><input type="text" id="ticketNum" name="TicketRefNumber"></td>
				</tr>
				<tr>
					<td>CaseStudy</td>
					<td><textarea rows="4" cols="50" name="caseStudy"></textarea></td>
				</tr>

				<tr>
					<td>ProblemObserved</td>
					<td><textarea rows="4" cols="50" name="problemObserved"></textarea></td>
				</tr>


				<tr>
					<td>Resolutions</td>
					<td><textarea rows="4" cols="50" name="resolutions"></textarea></td>
				</tr>


				<tr>
					<td>SupportEngineer Details</td>
					<td><textarea rows="4" cols="50" name="supportEngineerDetails"></textarea></td>
				</tr>

				<tr>
					<td>Problem Resolution</td>
					<td><input type="radio" name="problemResolution" value="yes"
						checked> Yes <input type="radio" name="problemResolution"
						value="no"> No</td>
				</tr>


				<tr>
					<td>Remarks</td>
					<td><textarea rows="4" cols="50" name="remarks"></textarea></td>
				</tr>

				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>

		<script type="text/javascript">
			var ticketNumber = "${TicketRefNumber}";
			document.getElementById("ticketNum").value = ticketNumber;
		</script>
	</div>

</body>
</html>