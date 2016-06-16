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
<title>会员首页</title>
</head>
<body class = "welcome-bg">
	<%
		Member m = (Member)session.getAttribute("member");
		int level = m.getLevel();
		String levelName;
		if(level == 1){
			levelName ="银卡";
		}else if(level == 2){
			levelName = "金卡";
		}else{
			levelName = "钻石卡";
		}
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
		<div class="form-panel-1" id="js-warning">
			<p>亲爱的会员 <%=m.getCid() %>，</p>
			<p>您现在的会员卡级别为 <%=m.getLevel() %>级  <%=levelName %></p>
   			<p>可享受部分商品<%=m.getDiscount()%>折</p>
   			<%
   				DecimalFormat df = new DecimalFormat("######0.0"); 
				String percent = df.format(m.getCredit());
   			%>
   			<p>拥有积分<%=percent %>点</p>
   			<p>账户余额<%=m.getBalance() %>元</p>
   			<button type="button" class="btn btn-warning" onclick="exchangeCredit()">兑换积分</button>
   			<button type="button" class="btn btn-warning" onclick="activeMember()">充值</button>
   			<form action="/DessertHouse/stopMember" method="post" class="">
   				<br/>
   				<input type="submit" class="btn btn-danger " value="取消会员资格">
   			</form>
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
			<div class="right-message1 color-white">
				<p class="color-white">一次性充值满200元可享受部分商品9.5折优惠</p>
				<p class="color-white">一次性充值满400元可享受部分商品8.8折优惠</p>
				<p class="color-white">一次性充值满800元可享受部分商品8.5折优惠</p>
			</div>
		</div>
		
		<div class="display-none" id="js-exchange-credit">
			<div class=" form-panel-left ">
			<form action="/DessertHouse/exchangeCredit" method="post" class="exchange-credit-from">
			<p class="color-white">您有<%=m.getCredit() %>点积分可以兑换</p>
		 		<div class="form-group">
      				<label class="login-label">兑换的积分个数</label>
      				<s:textfield name="credit" class="form-control"/>
   				</div>
   				<input type="submit" class="btn btn-warning" value="确认兑换">
			</form>
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
		function exchangeCredit(){
			$("#js-warning").hide();
			$("#js-exchange-credit").addClass("display-inline-block");
		}
	</script>
</body>
</html>