<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%@ page import="edu.nju.desserthouse.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<title>缴费记录</title>
</head>
<body class = "main-bg">
	<%
		List<SalesRecord> srList = (List<SalesRecord>)request.getAttribute("srList");
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
	<table class="table table-hover table-condensed ">
	<thead>
      <tr>
      	 <th>账单编号</th>
         <th>消费时间</th>
         <th>商品编号</th>
         <th>商品数量</th>
         <th>总价</th>
         <th>实际支付金额</th>
         <th>优惠信息</th>
      </tr>
	</thead>
   <tbody>
   <%
		for (SalesRecord item :srList){
			if(item.getIsValid()==1){
	%>
		<tr>
         <td><%=item.getSrid() %></td>
         <td><%=item.getSalesTime() %></td>
         <td><%=item.getDid() %></td>
         <td><%=item.getAmount() %></td>
         <td><%=item.getTotal() %></td>
          <%
			    DecimalFormat df = new DecimalFormat("######0.0"); 
          		String realTotal = df.format(item.getRealTotal());
		  %>

         <td><%=realTotal %></td>
         <td><%=item.getDiscountMessage() %></td>
     	 </tr>
	<%}} %>
   </tbody>
</table>
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
</body>
</html>