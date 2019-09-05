<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Titanic</h1>
	<form name='titanicForm' action='/SolidWareProject/titanic' method='POST'>
		<table>
			<tr><td>If you were in the Titanic....</td><td>How about you?! Live? Or Dead?</td></tr>
			<tr><td>Name:</td><td><input type='text' name='Name' value=''></td></tr>
			<tr><td>Sex:</td>
			<td><input type="radio" name="Sex" value="male" checked="checked">male
				<input type="radio" name="Sex" value="female">female</td></tr>
			<tr><td>Passenger Class:</td><td><select name="Pclass">
			    <option value="">Select</option>
			    <option value="1">1st</option>
			    <option value="2">2nd</option>
			    <option value="3">3rd</option>
			</select></td></tr>
			<tr><td>Fare:</td><td><input type='text' name='Fare'/></td></tr>
			<tr><td>Port of Embarkation:</td><td><select name="Embarked">
			    <option value="">Select</option>
			    <option value="C">Cherbourg</option>
			    <option value="Q">Queenstown</option>
			    <option value="S">Southampton</option>
			</select></td></tr>
			<tr><td>Number of Parents/Children Aboard:</td><td><input type='text' name='Parch'/></td></tr>
			<tr><td>Age:</td><td><input type='number' name='Age'/></td></tr>
			<tr><td>Cabin:</td><td><input type='text' name='Cabin'/></td></tr>
			<tr><td>Number of Siblings/Spouses Aboard:</td><td><input type='text' name='SibSp'/></td></tr>
			<tr><td colspan='2'><input name="call" type="submit" value="submit post call"/></td></tr>
			<tr><td colspan='2'><input type="button" value="call restful api" onClick="callRestAPIPost()"></td></tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="hidden" name="PassengerId" value=""/>
	</form>
	
	<script>
	function callRestAPIPost()
	{
		var theForm = document.titanicForm;
		theForm.method = "POST"; 
		theForm.action = "/SolidWareProject/titanic/restful";
		theForm.submit();
	}
	</script>
</body>
</html>