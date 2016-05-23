<!DOCTYPE html>
<html>
<head>
<style> 
input[type=text] {
    width: 50%;
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: none;
    background-color: #3CBC8D;
    color: white;
display:block;
}
</style>
</head>
<body>

<h1>Login</h1>

<form action="LoginController" method="post">
  <label for="fname">Email</label>
  <input type="text" id="fname" name="email" >
  <label for="fname">Password</label>
  <input type="text" id="lname" name="password" >
  <input type="submit" value="submit">
</form>

</body>
</html>
