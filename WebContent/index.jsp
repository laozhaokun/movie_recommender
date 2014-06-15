<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="style1.css">
<title>movie recommend system</title>
<script type="text/javascript">
	function validateForm() {
		var x = document.getElementById("source").value.trim();
		if (x == null || x == "") {
			alert("Please input something.");
			return false;
		} else if (x.length > 1000) {
			alert("The length must be less than 1000.");
			return false;
		}
	}
</script>
</head>
<body>
<div id="body">
		<div id="header">
			<p><a href="index.jsp">A simple Movie Recommender
					System</a></p>
		</div>
		<center><h2>Please fill this form with integers to get recommendations.</h2></center>
		<div id="content">
			<form action="getRecommendationsAction" method="post" onsubmit="return validateForm()">
				userid:<input type="text" name="userid" id="userid">for who<br/><br/>
				 size:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="size" id="size">how many <br/><br/>
				 method:&nbsp;&nbsp;&nbsp;<input type="radio" name="method" checked="checked" value="mahout_userbased">UserBased
				<input type="radio" name="method" value="mahout_itembased" >ItemBased
				<input type="radio" name="method" value="mahout_slopeone">SlopeOne<br/>
				<br/>
				<input type="submit" value="submit">
			</form>
		</div>
		</div>
		<jsp:include page="footer.html"></jsp:include>
</body>
</html>