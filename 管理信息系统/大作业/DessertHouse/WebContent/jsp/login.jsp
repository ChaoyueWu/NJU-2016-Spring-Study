<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
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
		 	<legend class="login-legend">登录</legend>
		 	<form action="/DessertHouse/login" method="post" class="login-form">
		 		<div class="form-group">
      				<label class="login-label">账号</label>
      				<s:textfield name="id" class="form-control"/>
         	
   				</div>
   				<div class="form-group">
      				<label class="login-label">密码</label>
      				<s:password name="password" class="form-control"/>
   				</div>
   				<input type="submit" class="btn btn-success login-btn" value="登陆">
			</form>
			<br/>
			<form action="/DessertHouse/getMemberId" method="post" class="login-form">
   					<input type="submit" class="btn btn-info login-btn" value="注册">
   				</form>
         </fieldset>
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
	
	</script>
</body>
</html>