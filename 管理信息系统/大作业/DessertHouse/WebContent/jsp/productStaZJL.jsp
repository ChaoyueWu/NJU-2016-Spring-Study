<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.nju.desserthouse.model.stavo.*" %>
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
<title>Welcome</title>
</head>
<body class = "main-bg">
<%
	ProductStaVO psvo = (ProductStaVO)request.getAttribute("psvo");
	List<District> disList = psvo.disList;
	List<Shop> shopList = psvo.shopList;
	List<DisProductStaVO> tdpList = psvo.tdpList;
	HashMap<String,List<DisProductStaVO>> dpMap = psvo.dpMap;
	HashMap<String, List<DisProductStaVO>> spMap = psvo.spMap;
%>
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
		<div class = "leftnav">
			<ul class="nav nav-pills nav-stacked">
				<li><a class="left-nav-item active" id="nav-item-1" href="#">商品统计</a></li>
				<li><a class="left-nav-item" id="nav-item-2"  href="/DessertHouse/categorySta">商品分类统计</a></li>
				<li><a class="left-nav-item" id="nav-item-3"  href="/DessertHouse/productTrend">趋势分析</a></li>
			</ul>
		</div>
		<div class="right-table">
			<div class="head-select">
				<select class="plan-select" id="js-select-district" onchange = disChange()>
					<option value='0'>所有地区</option>
					<%
						for (District dis : disList) {
					%>
						<option value='<%=dis.getDisid() %>'><%=dis.getDisname() %></option>
					<%
						}
					%>
      			</select>
      			<select class="plan-select shop-select " id="js-select-shop-所有地区">
					<option value='0'>所有店铺</option>
					</select>
      			<%
						for (District dis : disList) {
					%>
      			<select class="plan-select shop-select display-none" id="js-select-shop-<%=dis.getDisname() %>" onchange = shopChange(this)>
					<option value='<%=dis.getDisname() %>'>所有店铺</option>
					<%
						for (Shop shop : shopList) {
							if(shop.getDisid() == dis.getDisid()){
					%>
						<option value='<%=shop.getDisname() %>'><%=shop.getSname() %></option>
					<%
							}}
					%>
      			</select>
      			<%
						}
					%>
			</div>
			<!-- 下方循环表格&图标[每个地区总计-对应地区select -->
			<div class="sta-div" id="js-sta-div-所有地区">
				<div><!-- table div -->
				<table class="table table-hover table-condensed ">
				<caption >本年度商品统计</caption>
				 <tr>
				         <th>商品编号</th>
				         <th>商品名</th>
				         <th>商品类别</th>
				         <th>总销售量</th>
				         <th>总销售额</th>
				      </tr>
				   <tbody>
				   <%
						for (DisProductStaVO dpvo :tdpList){
					%>
						<tr>
							<td><%=dpvo.pid %></td>
							<td><%=dpvo.product %></td>
							<td><%=dpvo.category %></td>
							<td><%=dpvo.amount %></td>
							<td><%=dpvo.sum %></td>
				     	 </tr>
					<%} %>
				   </tbody>
			   </table>
			</div>
			<div id = 'chart-所有地区' ></div>
		</div>
		<%
						for (District dis : disList) {
							List<DisProductStaVO> list =  dpMap.get(dis.getDisname());
		%>
		<div class="sta-div" id="js-sta-div-<%=dis.getDisname() %>">
				<div><!-- table div -->
				<table class="table table-hover table-condensed ">
				<caption >本年度商品统计</caption>
				 <tr>
				         <th>商品编号</th>
				         <th>商品名</th>
				         <th>商品类别</th>
				         <th>总销售量</th>
				         <th>总销售额</th>
				      </tr>
				   <tbody>
				   <%
						for (DisProductStaVO dpvo :list){
					%>
						<tr>
							<td><%=dpvo.pid %></td>
							<td><%=dpvo.product %></td>
							<td><%=dpvo.category %></td>
							<td><%=dpvo.amount %></td>
							<td><%=dpvo.sum %></td>
				     	 </tr>
					<%} %>
				   </tbody>
			   </table>
			</div>
			<div id = 'chart-<%=dis.getDisname() %>' >here</div>
		</div>
		<%} %>
		
		<%
						for (Shop shop : shopList) {
							List<DisProductStaVO> list =  spMap.get(shop.getSname());
		%>
		<div class="sta-div" id="js-sta-div-<%=shop.getSname() %>">
				<div><!-- table div -->
				<table class="table table-hover table-condensed ">
				<caption >本年度商品统计</caption>
				 <tr>
				         <th>商品编号</th>
				         <th>商品名</th>
				         <th>商品类别</th>
				         <th>总销售量</th>
				         <th>总销售额</th>
				      </tr>
				   <tbody>
				   <%
						for (DisProductStaVO dpvo :list){
					%>
						<tr>
							<td><%=dpvo.pid %></td>
							<td><%=dpvo.product %></td>
							<td><%=dpvo.category %></td>
							<td><%=dpvo.amount %></td>
							<td><%=dpvo.sum %></td>
				     	 </tr>
					<%} %>
				   </tbody>
			   </table>
			</div>
			<div id = 'chart-<%=shop.getSname() %>' ></div>
		</div>
		<%} %>
		
		</div>
		</div>
	
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('.shop-select').hide();
		$('.sta-div').hide();
		$('#js-select-shop-所有地区').show();
		$('#js-sta-div-所有地区').show();
	});
	function disChange(){
		var disSelected = $("#js-select-district").find("option:selected").text();
		$('.shop-select').hide();
		var shopSelect = "#js-select-shop-"+disSelected;
		$(shopSelect).show();
		$('.sta-div').hide();
		var staSelect = "#js-sta-div-"+disSelected;
		$(staSelect).show();
		
	}
	
	function shopChange(obj){
		var id = obj.getAttribute("id");
		id = "#"+id;
		var shopSelected = $(id).find("option:selected").text();
		if(shopSelected != "所有店铺"){
			$('.sta-div').hide();
			var staSelect = "#js-sta-div-"+shopSelected;
			$(staSelect).show();
		}else{
			var dis = $(id).val();
			$('.sta-div').hide();
			var staSelect = "#js-sta-div-"+dis;
			//$(staSelect).show();
			//var charSelect = "#chart-"+dis;
		}
		
	}
	//之前没规划好  应该用ajax实现 每选择一次 都和后台进行交互 只传当前选中的选项的相关数据（当然 select内容每次传全部），但是list只有一个
		$(function () {
		    $('#chart-所有地区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<tdpList.size();i++){
		                		out.print("'"+tdpList.get(i).product+"'");
			                	if(i<tdpList.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<tdpList.size()&&i<5;i++){
			                	out.print(tdpList.get(i).amount);
			                	if(i!=tdpList.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
	
		$(function () {
			<%
				List<DisProductStaVO> list = dpMap.get("玄武区");
			%>
		    $('#chart-玄武区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = dpMap.get("秦淮区");
			%>
		    $('#chart-秦淮区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = dpMap.get("鼓楼区");
			%>
		    $('#chart-鼓楼区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		
		$(function () {
			<%
				list = dpMap.get("建邺区");
			%>
		    $('#chart-建邺区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = dpMap.get("雨花台区");
			%>
		    $('#chart-雨花台区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		
		$(function () {
			<%
				list = dpMap.get("浦口区");
			%>
		    $('#chart-浦口区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = dpMap.get("栖霞区");
			%>
		    $('#chart-栖霞区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = dpMap.get("江宁区");
			%>
		    $('#chart-江宁区').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		//店铺
		$(function () {
			<%
				list = spMap.get("珠江路店");
			%>
		    $('#chart-珠江路店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("文鼎店");
			%>
		    $('#chart-文鼎店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("竹山店");
			%>
		    $('#chart-竹山店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("健康路店");
			%>
		    $('#chart-健康路店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("石鼓路店");
			%>
		    $('#chart-石鼓路店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("龙江店");
			%>
		    $('#chart-龙江店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("广州路店");
			%>
		    $('#chart-广州路店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("华灯坊店");
			%>
		    $('#chart-华灯坊店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("虹悦城店");
			%>
		    $('#chart-虹悦城店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("湖南路店");
			%>
		    $('#chart-湖南路店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("宁海路店");
			%>
		    $('#chart-宁海路店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("银城东苑映象店");
			%>
		    $('#chart-银城东苑映象店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("清江苏宁店");
			%>
		    $('#chart-清江苏宁店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("南京万达店");
			%>
		    $('#chart-南京万达店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("桥北店");
			%>
		    $('#chart-桥北店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		$(function () {
			<%
				list = spMap.get("和燕店");
			%>
		    $('#chart-和燕店').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'TOP5商品统计'
		        },
		        subtitle: {
		            text: ''
		        },
		        xAxis: {
		            categories: [
		                <%
		                	for(int i = 0;i<list.size();i++){
		                		out.print("'"+list.get(i).product+"'");
			                	if(i<list.size()-1){out.print(",");}
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
		            headerFormat: '<span style="font-size:10px">{point.key}</span>',
		            pointFormat: '<div><span style="color:{series.color};padding:0">{series.name}: </span>' +
		                '<span style="padding:0"><b>{point.y} 个</b></span></div>',
		            footerFormat: '',
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
		            name: '销售总个数',
		            data: [
						<%
							for(int i = 0;i<list.size()&&i<5;i++){
			                	out.print(list.get(i).amount);
			                	if(i!=list.size()-1||i!=4){out.print(",");}
		                	}
						%>
					]
		        }]
		    });
		});
		
	</script>
</body>
</html>