<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
<title>计划管理</title>
</head>
<body class = "main-bg">
	<%
		HashMap<Integer,String> shopMap = (HashMap<Integer,String>)request.getAttribute("shopMap");
		HashMap<Integer,String> dessertMap = (HashMap<Integer,String>)request.getAttribute("dessertMap");
		List<PlanVO> planvoList = (List<PlanVO>)request.getAttribute("planvoList");
	%>
	<nav class="navbar navbar-default nav-bg" role="navigation">
		<div class="navbar-header">
			<label class="navbar-brand active">DessertHouse</label>
		</div>
		<div>
			<ul class="nav navbar-nav ">
				<li><a href="/DessertHouse/planPending">产品计划</a></li>
				<li><a href="/DessertHouse/productSta">商品销售管理</a></li>
				<li><a href="/DessertHouse/shopSta">店铺销售管理</a></li>
			</ul>

			<ul class="nav navbar-nav pull-right">
				<li><a href="/DessertHouse/logout">注销</a></li>
			</ul>
		</div>
		</nav>
	<div class="main color-white">
		 
		 <div class="right-table">
		 <%
		 	if(planvoList.size() == 0){
		 %>
		 	<h3>暂无新计划</h3>
		 <%
		 	}
		 %>
		 	<%
		 		for(PlanVO pvo:planvoList){
		 		
		 	%>
		 	<div>
		 	<br/>
		 		<div>
		 			<label class="control-label">所属店面：</label>
			 		<label class="control-label"><%=pvo.getSid() %>-<%=shopMap.get(pvo.getSid()) %></label>
			 		<br/>
			 		<label class="control-label">计划开始日期：</label>
			 		<label class="control-label"><%=pvo.getStartDate() %></label>
			 		<br/>
		 		</div>
		 		<%
					Date date = pvo.getStartDate();
			 		Calendar c = Calendar.getInstance();
					c.setTime(date);
					int day = c.get(Calendar.DATE);
					c.set(Calendar.DATE, day - 1);
					String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
					date = Date.valueOf(dayAfter);
					HashMap<Date,List<Goods>> map = pvo.getMap();
					for (int i = 0; i < 7; i++) {
						c = Calendar.getInstance();
						c.setTime(date);
						day = c.get(Calendar.DATE);
						c.set(Calendar.DATE, day + 1);
						dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
						date = Date.valueOf(dayAfter);
				%>
						<label class="control-label font-set"><%=date %></label><br/>
						<table class="table table-hover table-condensed table-color">
					   <tbody>
				<%
						List<Goods> list = map.get(date);
						for(Goods goods:list){
				%>
							<tr>
								<td><%=goods.getDid() %></td>
								<td><%=dessertMap.get(goods.getDid()) %></td>
								<td>
									<%=goods.getAmount() %>
									<label class="control-label font-set"> 个</label>
								</td>
								<td>
									<%=goods.getPrice() %>
									<label class="control-label font-set"> 元</label>
								</td>
							</tr>
				<%			
						}
				%>
				</tbody>
				</table>
				
				<%
					}
		 		%>
		 		<div class="pull-right ">
		 			<button type="button" class="btn btn-success" id='js-permit-<%=pvo.getPid() %>' onclick="permit(this)">批准</button>
		 			<button type="button" class="btn btn-danger" id='js-reject-<%=pvo.getPid() %>' onclick="reject(this)">不批准</button>
		 			<br/>
		 		</div>
		 	</div>
		 	
		 	<%
		 		}
		 	%>
		 </div>
		 
	</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
		function permit(obj){
			var id = obj.getAttribute("id");
			var pid = id.substr(10);
			$.ajax({
				type : "post",
				url : "DessertHouse/handlePlan",
				async : false,
				data : {
					pid : pid,
					permit:1
				},
				success : function(data) {
					alert("批准成功");
					location.reload();
				},
				error : function() {
					alert("批准失败");
				}
			});
		}
		function reject(obj){
			var id = obj.getAttribute("id");
			var pid = id.substr(10);
			$.ajax({
				type : "post",
				url : "DessertHouse/handlePlan",
				async : false,
				data : {
					pid : pid,
					permit:0
				},
				success : function(data) {
					alert("成功");
					location.reload();
				},
				error : function() {
					alert("失败");
				}
			});
		}
	</script>
</body>
</html>