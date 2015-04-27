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
	<form action="/CarManager/CalcCunsumption" method="post">
		<table style="border-collapse: collapse;">
			<tr>
				<th>차량번호</th>
				<th>이동거리</th>
			</tr>
			<c:forEach items="${carNumbers}" var="carNumber">
				<tr>
					<td>${carNumber}</td>
					<td name="distance"><input type="text" name="distance"></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="계산">
	</form>
</body>
</html>
