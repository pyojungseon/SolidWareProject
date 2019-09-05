<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ADD</h1>
	<form action="/SolidWareProject/person" method="post">
		NAME : <input type="text" id="name" name="name" ><br>
		<input type="submit" value="ADD" >
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
	<h1>DELETE</h1>
	NAME :<input type="text" id="deleteName" name="deleteName" ><br>
	<form name="deleteForm">
		<input type="button" value="delete" onClick="getDelete()">
		<input type="hidden" name="_method" value="delete"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
	<script>
	function getDelete()
	{
		var theForm = document.deleteForm;
		var delName = document.getElementById('deleteName');
		theForm.method = "post"; 
		theForm.action = "/SolidWareProject/person/"+delName.value;
		theForm.submit();
	}
	</script>
	
	<h1>GET LIST</h1>
	<form action="/SolidWareProject/person" method="get">
		<input type="submit" value="GET" >
	</form>
	<h1>GET GROUP LIST</h1>
	Group Size : <input type="text" id="groupSize" name="groupSize" ><br>
	Limit Size : <input type="text" id="limitSize" name="limitSize" ><br>
	<form name=grouListForm>
		<input type="button" value="group list" onClick="getGroup()">
	</form>
	
	<script>
	function getGroup()
	{
		var theForm = document.grouListForm;
		var groupSize = document.getElementById('groupSize');
		var limitSize = document.getElementById('limitSize');
		
		theForm.method = "get"; 
		theForm.action = "/SolidWareProject/random/"+groupSize.value+"/"+limitSize.value;
		theForm.submit();
	}
	</script>
			
</body>
</html>