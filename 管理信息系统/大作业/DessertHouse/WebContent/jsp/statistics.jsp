<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.*" %>
<%@ page import="edu.nju.desserthouse.model.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>统计</title>
</head>
<body class = "">
	<%
		List<Member> memberList = (List<Member>)request.getAttribute("memberList");
		String[] ageArr = (String[])request.getAttribute("ageArr");
		int[] angNumArr = (int[])request.getAttribute("angNumArr");
		List<Shop> sList = (List<Shop>)request.getAttribute("sList");
		HashMap<Integer,Integer> reserveMap = (HashMap<Integer,Integer>)request.getAttribute("reserveMap");
		HashMap<Integer,Integer> saleMap = (HashMap<Integer,Integer>)request.getAttribute("saleMap");
		List<DessertVO> dvoList = (List<DessertVO>)request.getAttribute("dvoList");
		double cSum = 0.0;
		for(int i = 0;i<angNumArr.length;i++){
			cSum += angNumArr[i];
		}
	%>
	<nav class="navbar navbar-default nav-bg" role="navigation">
		<div class="navbar-header">
			<label class="navbar-brand active">DessertHouse</label>
		</div>
		<div>
			<ul class="nav navbar-nav ">
				<li><a href="/DessertHouse/planPending">产品计划</a></li>
				<li><a href="/DessertHouse/statistics">统计</a></li>
			</ul>

			<ul class="nav navbar-nav pull-right">
				<li><a href="/DessertHouse/logout">注销</a></li>
			</ul>
		</div>
		</nav>
	<div class="main">
		<div>
			<table class="table table-hover table-condensed ">
			<caption >会员基本信息</caption>
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
		
		<div>
		<div id = 'age' ></div>
			<table class="table table-hover table-condensed ">
			<caption >会员年龄分布</caption>
			 <tr>
			         <th>年龄段</th>
			         <th>人数</th>
			         <th>百分比</th>
			      </tr>
				</thead>
			   <tbody>
			   <%
					for (int i = 0;i<ageArr.length;i++){
				%>
					<tr>
						<td><%=ageArr[i] %></td>
				        <td><%=angNumArr[i] %></td>
				        <%
					        double rate = angNumArr[i]/cSum;
							NumberFormat nf = NumberFormat.getPercentInstance();
							nf.setMinimumFractionDigits(2);//设置保留小数位
							String percent = nf.format(rate);
				        %>
				        <td><%=percent %></td>
			     	 </tr>
				<%} %>
			   </tbody>
		   </table>
		</div>	
		
		<div>
			<div id = 'shop' ></div>
			<table class="table table-hover table-condensed ">
			<caption >店铺运营情况</caption>
			 <tr>
			         <th>店铺编号</th>
			         <th>店铺名称</th>
			         <th>预定单数</th>
			         <th>销售单数</th>
			      </tr>
				</thead>
			   <tbody>
			   <%
					for (Shop shop:sList){
				%>
					<tr>
						<td><%=shop.getSid() %></td>
				        <td><%=shop.getSname() %></td>
				        <%
				        	Integer amount = reserveMap.get(shop.getSid()); 
				        	if(amount == null){
				        		amount = 0;
				        	}
				        %>
				        <td><%=amount %></td>
				         <%
				        	Integer amount1 = saleMap.get(shop.getSid()); 
				        	if(amount1 == null){
				        		amount1 = 0;
				        	}
				        %>
				        <td><%=amount1 %></td>
			     	 </tr>
				<%} %>
			   </tbody>
		   </table>
		</div>	
		
		<div>
			<div id = 'dessert' ></div>
			<table class="table table-hover table-condensed ">
			<caption >热卖产品</caption>
			 <tr>
			         <th>产品编号</th>
			         <th>产品名称</th>
			         <th>销售个数</th>
			      </tr>
				</thead>
			   <tbody>
			   <%
					for (DessertVO dvo:dvoList){
				%>
					<tr>
						<td><%=dvo.getDid() %></td>
				        <td><%=dvo.getName() %></td>
				        <td><%=dvo.getAmount() %></td>
			     	 </tr>
				<%} %>
			   </tbody>
		   </table>
		</div>	
	</div>
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	$(function () {
	    $('#age').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: '会员年龄分布情况'
	        },
	        tooltip: {
	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                }
	            }
	        },
	        series: [{
	            type: 'pie',
	            name: 'age percent',
	            data: [
				<%
				int i = 0;
				for(;i<4;i++){
					   out.print("['"+ageArr[i]+"',"+angNumArr[i]+"]");
					   if(i!=3){out.print(",");}
				}
				%>
	            ]
	        }]
	    });
	});
	
	$(function () {
	    $('#shop').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '店铺运营情况'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	                <%
	                	for(i = 0;i<sList.size();i++){
	                		out.print("'"+sList.get(i).getSname()+"'");
		                	if(i<sList.size()-1){out.print(",");}
	                	}
	                %>
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '订单个数 '
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f} 单</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '预定单数',
	            data: [
					<%
						for(i = 0;i<sList.size();i++){
							out.print(reserveMap.get(sList.get(i).getSid()));
		                	if(i!=sList.size()-1){out.print(",");}
						}
					%>
				]

	        }, {
	            name: '销售单数',
	            data: [
						<%
							for(i = 0;i<sList.size();i++){
								out.print(saleMap.get(sList.get(i).getSid()));
			                	if(i!=sList.size()-1){out.print(",");}
							}
						%>
					]

	        }]
	    });
	});
	
	$(function () {
	    $('#dessert').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '热卖产品'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            categories: [
	                <%
	                	for(i = 0;i<dvoList.size();i++){
	                		out.print("'"+dvoList.get(i).getName()+"'");
		                	if(i<dvoList.size()-1){out.print(",");}
	                	}
	                %>
	            ]
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '销售个数 '
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	                '<td style="padding:0"><b>{point.y:.1f} 个</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: [{
	            name: '销售个数',
	            data: [
					<%
						for(i = 0;i<dvoList.size();i++){
							out.print(dvoList.get(i).getAmount());
		                	if(i!=dvoList.size()-1){out.print(",");}
						}
					%>
				]


	        }]
	    });
	});
	</script>
</body>
</html>