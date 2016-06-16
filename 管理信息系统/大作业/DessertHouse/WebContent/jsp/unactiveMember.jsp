<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="edu.nju.desserthouse.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<title>会员首页</title>
</head>
<body class = "main-bg">
	<%
		Member m = (Member)session.getAttribute("member");
	%>
	<nav class="navbar navbar-default nav-bg" role="navigation">
		<div class="navbar-header">
			<label class="navbar-brand active">DessertHouse</label>
		</div>
		<div>
			<ul class="nav navbar-nav ">
				<li><a href="/DessertHouse/memberMain">会员首页</a></li>
				<li><a href="/DessertHouse/reserveProduct">预定产品</a></li>
				<li><a href="/DessertHouse/myOrder">我的订单</a></li>
				<li><a href="/DessertHouse/consumeRecord">消费记录</a></li>
				<li><a href="/DessertHouse/payRecord">缴费记录</a></li>
				<li><a href="/DessertHouse/personalInfo">个人信息</a></li>
			</ul>

			<ul class="nav navbar-nav pull-right">
				<li><a href="/DessertHouse/logout">注销</a></li>
			</ul>
		</div>
		</nav>
	<div class="main">
		<div class="form-panel" id="js-warning">
			<h3>亲爱的会员 <%=m.getCid() %></h3>
			<h3>您还没有激活您的会员账户，请先激活</h3>
			<br/>
			<button type="button" class="btn btn-warning btn-lg" onclick="activeMember()">激活会员</button>
		</div>
		<div class="display-none" id="js-active-member">
			<div class=" form-panel-left ">
			<form action="/DessertHouse/activeMember" method="post" class="login-form">
		 		<div class="form-group">
      				<label class="login-label">银行卡号</label>
      				<s:textfield name="bcid" class="form-control"/>
         	
   				</div>
   				<div class="form-group">
      				<label class="login-label">充值金额</label>
      				<s:textfield name="money" class="form-control"/>
   				</div>
   				<input type="submit" class="btn btn-success login-btn" value="充值">
			</form>
			</div>
			<div class="right-message1">
				<p>一次性充值满200元可享受部分商品9.5折优惠</p>
				<p>一次性充值满400元可享受部分商品8.8折优惠</p>
				<p>一次性充值满800元可享受部分商品8.5折优惠</p>
			</div>
		</div>
		 
		 
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
		function activeMember(){
			$("#js-warning").hide();
			$("#js-active-member").addClass("display-inline-block");
		}
	</script>
</body>
</html>