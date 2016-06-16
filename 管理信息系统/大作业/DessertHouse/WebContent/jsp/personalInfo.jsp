<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="edu.nju.desserthouse.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<title>个人信息</title>
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
		 <div id="js-member-info">
		 	<fieldset class="login-field">
		 	<legend class="login-legend">个人信息</legend>
		 		<p class="control-label login-label font-set" >会员编号：<%=m.getCid() %></p>
		 		<p class="control-label login-label font-set" >账户余额：<%=m.getBalance() %></p>
		 		<p class="control-label login-label font-set" >积分个数：
				<%
	   				DecimalFormat df = new DecimalFormat("######0.0"); 
					String percent = df.format(m.getCredit());
   				%> <%=percent %>点
				</p>
   				<p class="control-label login-label font-set" >出生日期：<%=m.getBirth() %></p>
				<p class="control-label login-label font-set">居住城市：<%=m.getAddress() %></p>
				<%
					int g = m.getSex();
					String sex;
					if(g == 0){
						sex = "女士";
					}else{
						sex = "先生";
					}
				%>
				<p class="control-label login-label font-set">性别：<%=sex %></p>
   			
				<br/>
				<button type="button" class="btn btn-warning" onclick="updateInfo()">修改个人信息</button>
         	</fieldset>
		 </div>
	
		 <div class="display-none" id="js-update-info">
		 	<fieldset class="login-field">
		 	<legend class="login-legend">修改个人信息</legend>
		 	<form action="/DessertHouse/updateInfo" method="post" class="login-form">
   				<div class="control-group">
   					<label class="control-label login-label" style="font-weight:bold">出生日期：</label>
						<div class="controls">
							<s:textfield name="birth" class="form-control"/>
						</div>
					</div>
				<div class="control-group">
					<label class="control-label login-label">居住城市</label>
						<div class="controls">
							<s:textfield name="address" class="form-control"/>
						</div>
				</div>
				<div class="form-group">
      				<label class="login-label">密码</label>
      				<s:password name="password1" class="form-control"/>
         	
   				</div>
   				<div class="form-group">
      				<label class="login-label">确认密码</label>
      				<s:password name="password2" class="form-control"/>
   				</div>
   				<div class="control-group login-label">
					<label class="control-label">性别</label>
					<div class="controls">
						<s:radio list="#{'1':'先生','0':'女士'}" name="gender" value="1"/>
					</div>
				</div>
				<br/>
   				<input type="submit" class="btn btn-success login-btn" value="确认修改">
			</form>
         	</fieldset>
		 </div>
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
		function updateInfo(){
			$("#js-member-info").hide();
			$("#js-update-info").addClass("display-block");
		}
	</script>
</body>
</html>