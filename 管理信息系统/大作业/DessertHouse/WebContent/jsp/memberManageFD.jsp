<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@ page import="edu.nju.desserthouse.model.*" %>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>会员管理</title>
</head>
<body class = "main-bg">
	<%
		List<Member> memberList = (List<Member>)request.getAttribute("memberList");
		List<PaymentRecord> paymentRecordList = (List<PaymentRecord>)request.getAttribute("paymentRecordList");
		List<SalesRecord> salesRecordList = (List<SalesRecord>)request.getAttribute("salesRecordList");
	%>
	<nav class="navbar navbar-default nav-bg" role="navigation">
		<div class="navbar-header">
			<label class="navbar-brand active">DessertHouse</label>
		</div>
		
		<div>
			<ul class="nav navbar-nav ">
				<li><a href="/DessertHouse/saleDessert">销售商品</a></li>
				<li><a href="/DessertHouse/memberManage">会员管理</a></li>
			</ul>

			<ul class="nav navbar-nav pull-right">
				<li><a href="/DessertHouse/logout">注销</a></li>
			</ul>
		</div>
	</nav>
	<div class="main">
		<div class = "leftnav">
			<ul class="nav nav-pills nav-stacked">
				<li><a class="left-nav-item active" id="nav-item-1" href="#" onclick="getMemberInfo()">会员基本信息</a></li>
				<li><a class="left-nav-item" href="#" id="nav-item-2" onclick="getSalesRecord(this)">会员消费记录</a></li>
				<li><a class="left-nav-item" href="#" id="nav-item-3" onclick="getPaymentRecord(this)">会员缴费记录</a></li>
			</ul>
		</div>
		<div class="right-table" id="js-table-info">
			<table class="table table-hover table-condensed ">
				<thead>
			      <tr>
			         <th>会员编号</th>
			         <th>性别</th>
			         <th>出生日期</th>
			         <th>居住城市</th>
			         <th>账户余额</th>
			         <th>积分个数</th>
			         <th>用户等级</th>
			         <th>用户状态</th>
			      </tr>
				</thead>
			   <tbody>
			   <%
					for (Member m :memberList){
				%>
					<tr>
						<td><%=m.getCid() %></td>
						<%
							int g = m.getSex();
							String sex;
							if(g == 0){
								sex = "女士";
							}else{
								sex = "先生";
							}
						%>
				        <td><%=sex %></td>
				        <td><%=m.getBirth() %></td>
				        <td><%=m.getAddress()%></td>
				        <td><%=m.getBalance() %></td>
				         <%
			   				DecimalFormat df = new DecimalFormat("######0.0"); 
							String percent = df.format(m.getCredit());
			   			%>
				        <td><%=percent %></td>
				        <%
							int level = m.getLevel();
							String levelName;
							if(level == 1){
								levelName ="银卡会员";
							}else if(level == 2){
								levelName = "金卡会员";
							}else if(level == 3){
								levelName = "钻石卡会员";
							}else{
								levelName = "未激活会员";
							}
						%>
						<td><%=levelName %></td>
						<%
							int state = m.getState();
							String stateName;
							if(state == 0){
								stateName ="未激活";
							}else if(state == 1){
								stateName = "活跃会员";
							}else if(state == 2){
								stateName = "会员卡已暂停";
							}
							else{
								stateName = "会员卡已停止";
							}
						%>
						<td><%=stateName %></td>
			     	 </tr>
				<%} %>
			   </tbody>
			</table>
		</div>
		<div class="right-table" id="js-table-sale">
			<table class="table table-hover table-condensed ">
				<thead>
			      <tr>
			         <th>会员编号</th>
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
					for (SalesRecord s :salesRecordList){
						int cid = s.getCid();
						if((s.getIsValid() == 1)&&(cid!=0)){
				%>
					<tr>
						<td><%=s.getCid() %></td>
						<td><%=s.getSrid() %></td>
				         <td><%=s.getSalesTime() %></td>
				         <td><%=s.getDid() %></td>
				         <td><%=s.getAmount() %></td>
				         <td><%=s.getTotal() %></td>
				         <%
							    DecimalFormat df = new DecimalFormat("######0.0"); 
				          		String realTotal = df.format(s.getRealTotal());
						  %>

         				<td><%=realTotal %></td>
				         <td><%=s.getDiscountMessage() %></td>
			     	 </tr>
				<%}} %>
			   </tbody>
			</table>
		</div>
		<div class="right-table" id="js-table-pay">
			<table class="table table-hover table-condensed ">
				<thead>
			      <tr>
			         <th>会员编号</th>
			         <th>缴费时间</th>
			         <th>缴费金额</th>
			         <th>银行卡号</th>
			      </tr>
				</thead>
			   <tbody>
			   <%
					for (PaymentRecord item :paymentRecordList){
				%>
					<tr>
						<td><%=item.getCid() %></td>
				        <td><%=item.getDate() %></td>
				        <td><%=item.getAmount() %></td>
				        <td><%=item.getBcid()%></td>
			     	 </tr>
				<%} %>
			   </tbody>
			</table>
		</div>
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("#js-table-pay").hide();
		$("#js-table-sale").hide();
	});
		function getMemberInfo(){
			$("#nav-item-1").addClass("active");
			$("#nav-item-2").removeClass("active");
			$("#nav-item-3").removeClass("active");
			$("#js-table-pay").hide();
			$("#js-table-sale").hide();
			$("#js-table-info").show();
		}
		
		function getSalesRecord(){
			$("#nav-item-2").addClass("active");
			$("#nav-item-1").removeClass("active");
			$("#nav-item-3").removeClass("active");
			$("#js-table-pay").hide();
			$("#js-table-info").hide();
			$("#js-table-sale").show();
		}
		
		function getPaymentRecord(){
			$("#nav-item-3").addClass("active");
			$("#nav-item-2").removeClass("active");
			$("#nav-item-1").removeClass("active");
			$("#js-table-info").hide();
			$("#js-table-sale").hide();
			$("#js-table-pay").show();
		}
	</script>
</body>
</html>