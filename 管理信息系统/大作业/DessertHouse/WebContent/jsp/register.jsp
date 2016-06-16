<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<title>DessertHouse</title>
</head>
<body class = "login-bg">
	<%
		session.invalidate();
	%>
	<div class="main">
		 <fieldset class="login-field">
		 	<legend class="login-legend">注册</legend>
		 	<form action="/DessertHouse/register" method="post" class="login-form">
		 		<h3 style="color:white">您的会员账号为 <s:property value="#request.id"/></h3>
		 		<div class="form-group">
      				<label class="login-label">密码</label>
      				<s:password name="password1" class="form-control"/>
         	
   				</div>
   				<div class="form-group">
      				<label class="login-label">确认密码</label>
      				<s:password name="password2" class="form-control"/>
   				</div>
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
				<div class="control-group login-label">
					<label class="control-label">性别</label>
					<div class="controls">
						<s:radio list="#{'1':'先生','0':'女士'}" name="gender" value="1"/>
					</div>
				</div>
   				<input type="submit" class="btn btn-success login-btn" value="注册">
			</form>
         </fieldset>
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
</body>
</html>