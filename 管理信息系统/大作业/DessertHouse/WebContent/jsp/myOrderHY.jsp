<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="edu.nju.desserthouse.model.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		HashMap<Integer,Dessert> idMap = (HashMap<Integer,Dessert>)request.getAttribute("idMap");
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
      	 <th>订单编号</th>
         <th>商品名称</th>
         <th>图片</th>
         <th>商品个数</th>
         <th>总价</th>
         <th>实际支付金额</th>
         <th>下单时间</th>
		 <th>取货时间</th>
		 	
      </tr>
	</thead>
   <tbody>
   <%
		for (SalesRecord item :srList){
	%>
		<tr>
			<td><%=item.getSrid() %></td>
			<td><%=idMap.get(item.getDid()).getName() %></td>
			<td>
				<img src='<%=idMap.get(item.getDid()).getImage() %>' class="img-rounded">
			</td>
			<td><%=item.getAmount() %></td>
			<td><%=item.getTotal() %></td>
			<%
			    DecimalFormat df = new DecimalFormat("######0.0"); 
          		String realTotal = df.format(item.getRealTotal());
		  %>

         <td><%=realTotal %></td>
			<td><%=item.getSalesTime() %></td>
			<td><%=item.getTakeDate() %></td>
			<%
				Calendar c = Calendar.getInstance();
				c.setTime(item.getTakeDate());
				int day = c.get(Calendar.DATE);
				c.set(Calendar.DATE, day - 1);
				String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
				Date date = Date.valueOf(dayAfter);
				c = Calendar.getInstance();
				String dayCurr = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
				Date dateCurr = Date.valueOf(dayCurr);
				if(item.getIsValid()==0){
			%>
				<td>
					<button type="button" class="btn " >订单已取消</button>
				</td>
			<%
				}else if(date.compareTo(dateCurr)>=0){
			%>
					<td>
						<button id='js-<%=item.getSrid() %>' type="button" class="btn btn-warning" onclick="cancelOrder(this)">取消订单</button>
					</td>
			<%
				}
			%>
		</tr>
	
	<%} %>
   </tbody>
</table>
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
		function cancelOrder(obj){
			var id = obj.getAttribute("id");
			id = id.substr(3);
			$.ajax({
				type : "post",
				url : "DessertHouse/cancelOrder",
				async : false,
				data : {
					srid:id,
				},
				success : function(data) {
					alert("取消订单成功");
				},
				error : function() {
					alert("取消订单失败");
				}
			});
		}
	</script>
</body>
</html>