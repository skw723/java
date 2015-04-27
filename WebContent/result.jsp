<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="border-collapse: collapse;">
		<tr>
			<th>차량번호</th>
			<th>연료 소모량</th>
		</tr>
		<c:forEach items="${data}" var="car">
			<tr>
				<td>${car.key}</td>
				<td>${car.value}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>