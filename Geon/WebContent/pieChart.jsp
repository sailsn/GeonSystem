
<!DOCTYPE html>
<html>
<head>
<title>Pie Chart Demo</title>
<script type="text/javascript">
        function refreshPage() 
        {
                document.forms.formId.submit();
        }
</script>
</head>
<body>

        <h3>Create Pie Chart Dynamically using JFreechart</h3>
        <%
                response.setIntHeader("Refresh", 10);
        %>
        <form action="PieChartController" method="get">
           <input type="button" onclick="refreshPage()" value="Refresh Page" />
           <br /> <img src="displayChart" />
        </form>
</body>
</html>