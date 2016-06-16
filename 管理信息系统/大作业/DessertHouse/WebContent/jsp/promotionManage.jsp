<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.nju.desserthouse.model.stavo.*"%>
<%@ page import="edu.nju.desserthouse.model.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>Welcome</title>
</head>
<%
	List<Promotion> plist = (List<Promotion>) request.getAttribute("plist");
%>
<body class="main-bg">
	<nav class="navbar navbar-default nav-bg" role="navigation">
	<div class="navbar-header">
		<label class="navbar-brand active">DessertHouse</label>
	</div>
	<div>
		<ul class="nav navbar-nav ">
			<li><a href="/DessertHouse/crm">客户关系管理</a></li>
				<li><a href="/DessertHouse/promotionManage">促销策略管理</a></li>
				<li><a href="/DessertHouse/productSta">商品销售管理</a></li>
				<li><a href="/DessertHouse/shopSta">店铺销售管理</a></li>
		</ul>

		<ul class="nav navbar-nav pull-right">
			<li><a href="/DessertHouse/logout">注销</a></li>
		</ul>
	</div>
	</nav>

	<div class="main">
		<div class="leftnav">
			<ul class="nav nav-pills nav-stacked">
				<li><a class="left-nav-item active" id="nav-item-1" href="#">查看促销策略</a></li>
				<li><a class="left-nav-item" id="nav-item-2"
					href="/DessertHouse/newPromotion">制定代金券</a></li>
				<li>
			</ul>
		</div>
		<div class="right-table">
			<table class="table table-hover table-condensed ">
				<thead>
					<tr>
						<th>编号</th>
						<th>类别</th>
						<th>面额</th>
						<th>要求</th>
						<th>到期时间</th>
						<th>针对用户类型</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Promotion p : plist) {
					%>
					<tr>
						<td><%=p.getId() %></td>
						<td><%=p.getName() %></td>
						<td><%=p.getValue() %></td>
						<td>消费满<%=p.getRequire() %>元可用</td>
						<td><%=p.getDeadline() %></td>
						<%
							int level = p.getMemtype();
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
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
		
	</script>
</body>
</html>