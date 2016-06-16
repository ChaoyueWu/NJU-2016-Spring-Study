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
<body class="main-bg">
	<%
		CategoryStaVO csvo = (CategoryStaVO) request.getAttribute("csvo");
		int sid = (int) request.getAttribute("sid");
		int disid = (int) request.getAttribute("disid");
		List<District> disList = csvo.disList;
		List<Shop> shopList = csvo.shopList;
		List<ProductCategory> pcList = csvo.pcList;
		List<CategoryOnlyStaVO> coList = csvo.coList;
		HashMap<String, List<ProductOnlyStaVO>> cpMap = csvo.cpMap;
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

	<div class="main">
		<div class="leftnav">
			<ul class="nav nav-pills nav-stacked">
				<li><a class="left-nav-item" id="nav-item-1"
					href="/DessertHouse/productSta">商品统计</a></li>
				<li><a class="left-nav-item active" id="nav-item-2" href="#">商品分类统计</a></li>
				<li><a class="left-nav-item" id="nav-item-3"  href="/DessertHouse/productTrend">趋势分析</a></li>
			</ul>
		</div>
		<div class="right-table">
			<div class="head-select">
				<select class="plan-select" id="js-select-district"
					onchange=disChange()>
					<option value='0'>所有地区</option>
					<%
						for (District dis : disList) {
					%>
					<option value='<%=dis.getDisid()%>'
						<%if (dis.getDisid() == disid) {%> selected="selected" <%}%>><%=dis.getDisname()%></option>
					<%
						}
					%>
				</select> <select class="plan-select" id="js-select-shop"
					onchange=shopChange()>

					<%
						for (Shop shop : shopList) {
					%>
					<option value='<%=shop.getSid()%>' <%if (shop.getSid() == sid) {%>
						selected="selected" <%}%>><%=shop.getSname()%></option>
					<%
						}
					%>
				</select>
			</div><br/>
			<div class = "charts-div-category">
				<div id='chart-category-amount' class="chart-category"></div>
				<div id='chart-category-sum' class="chart-category"></div>
			</div>
			<div class="sta-div" id="js-sta-div">
				<div>
					<!-- table div -->

					<table class="table  ">
						<tr>
							<th>商品编号</th>
							<th>商品名</th>
							<th>总销售量</th>
							<th>总销售额</th>
						</tr>


						<tbody>
							<%
								for (ProductCategory dpvo : pcList) {
									List<ProductOnlyStaVO> list = cpMap.get(dpvo.getPcname());
							%>
							<tr class="tr-title">
								<td><%=dpvo.getPcname()%></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<%
								for (ProductOnlyStaVO povo : list) {
							%>
							<tr>
								<td><%=povo.did%></td>
								<td><%=povo.dname%></td>
								<td><%=povo.amount%></td>
								<td><%=povo.sum%></td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>

				</div>

			</div>

		</div>
	</div>

	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	
	function disChange(){
		var ajaxDisid = $("#js-select-district").val();
		var ajaxSid = $("#js-select-shop").val();
		
		$.ajax({
			type : "post",
			url : "DessertHouse/categorySta",
			async : false,
			data : {
				sid:ajaxSid,
				disid: ajaxDisid
			},
			success : function(data) {
				location.reload();
			},
			error : function() {
				alert("fail");
			}
		});
	}
	
	function shopChange(){
		var ajaxDisid = $("#js-select-district").val();
		var ajaxSid = $("#js-select-shop").val();
		
		$.ajax({
			type : "post",
			url : "DessertHouse/categorySta",
			async : false,
			data : {
				sid:ajaxSid,
				disid: ajaxDisid
			},
			success : function(data) {
				location.reload();
			},
			error : function() {
				alert("fail");
			}
		});
	}
	
	$(function () {
	    $('#chart-category-amount').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: '商品销售个数类别占比情况'
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
	            name: '销售个数占比',
	            data: [
				<%int i = 0;
			for (; i < coList.size(); i++) {
				out.print("['" + coList.get(i).pcname + "'," + coList.get(i).amount + "]");
				if (i != coList.size() - 1) {
					out.print(",");
				}
			}%>
	            ]
	        }]
	    });
	});
	
	$(function () {
	    $('#chart-category-sum').highcharts({
	        chart: {
	            plotBackgroundColor: null,
	            plotBorderWidth: null,
	            plotShadow: false
	        },
	        title: {
	            text: '商品销售额类别占比情况'
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
	            name: '销售额占比',
	            data: [
				<%i = 0;
			for (; i < coList.size(); i++) {
				out.print("['" + coList.get(i).pcname + "'," + coList.get(i).sum + "]");
				if (i != coList.size() - 1) {
					out.print(",");
				}
			}%>
	            ]
	        }]
	    });
	});
	</script>
</body>
</html>