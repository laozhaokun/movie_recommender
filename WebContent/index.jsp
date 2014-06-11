<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>movie recommend system</title>
</head>
<body>
	<center>
		<h3>Please fill this form to get recommendations.</h3>
		<form action="getRecommendationsAction" method="post">
			<table border="0">
				<tr>
					<td align="right">userid</td>
					<td align="left"><input type="text" name="userid"><span style="font-size:10px">for who</span></td>
				</tr>
				<tr>
					<td align="right">size</td>
					<td align="left"><input type="text" name="size"><span style="font-size:10px">how many</span></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><span>method</span><input type="radio"
						name="method" checked="checked" value="mahout_userbased">UserBased
						<input type="radio" name="method" value="mahout_itembased">ItemBased
						<input type="radio" name="method" value="mahout_slopeone">SlopeOne
					</td>
				</tr>
				<tr>
					<td colspan="5" align="center"><input type="submit"
						value="submit"></td>
				</tr>
			</table>
		</form>
	</center>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<div style="border-top: 1px solid #ECECEC;text-align:center;">
<p>注：本站为一个基于<a target="_blank" href="http://mahout.apache.org">Mahout</a>的电影推荐系统的练习,速度还很慢！尚待完善...<br/>
现部署于SAE，为降低云豆消耗，请下载源码在本地安装测试。<br/>
全部源码放在<a target="_blank" href="http://www.github.com/laozhaokun/movie_recommender">Github</a>上。</p>
	 <dl>
  <dd>
  	<span>相关链接：</span> 
	<a target="_blank" href="http://blog.csdn.net/laozhaokun">博客</a>
	|
	<a target="_blank" href="http://www.github.com/laozhaokun">Github</a>
	|
	<a target="_blank" href="http://www.mianshibaike.com?huntinfo">面试</a>
	|
	<a target="_blank" href="http://sae.sina.com.cn">SAE</a>
	|
	<a target="_blank" href="http://huntinfo.sinaapp.com?movie">水木招聘信息抓取</a>
	|
	<a href="mailto:zhf.thu@gmail.com">Email</a>
</dd>
</dl>
</div>
</body>
</html>