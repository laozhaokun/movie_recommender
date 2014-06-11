<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>The recommendations</title>
</head>
<body>
<a href="index.jsp">回首页</a>
	<div id="body">
		<div class="left">
			<h2>Your reviewed movies</h2>
			<table border="1">
				<tr>
					<td>Movie Name</td>
					<td>Your Score</td>
				</tr>
				<c:forEach var="item" items="${usermovielist}">
					<tr>
						<td>${item.title}</td>
						<td>${item.score}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="right">
			<h2>Recommend movies to you</h2>
			<table border="1" align="center">
				<tr>
					<td>Movie Name</td>
					<td>Predict Score</td>
				</tr>
				<c:forEach var="item" items="${recommendedmovielist}">
					<tr>
						<td>${item.title}</td>
						<td>${item.score}</td>
					</tr>
				</c:forEach>
			</table>
			<br/>
			<br/>
			<br/>
			<br/>
			<s:include value="footer.html"></s:include>
		</div>
	</div>
</body>
</html>