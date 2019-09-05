<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Health Test</title>
</head>
<body>
	<h1>Login</h1>
	<form name='f' action='/SolidWareProject/healthTest' method='POST'>
		<table>
			<tr><td>Authentication For TEST</td><td>ID : member PW : member</td></tr>
			<tr><td>User:</td><td><input type='text' name='username' value=''></td></tr>
			<tr><td>Password:</td><td><input type='password' name='password'/></td></tr>
			<tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</body>
</html>