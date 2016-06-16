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
		ProductTrendVO ptvo = (ProductTrendVO) request.getAttribute("ptvo");
		int sid = (int) request.getAttribute("sid");
		int disid = (int) request.getAttribute("disid");
		int did = (int) request.getAttribute("did");
		List<District> disList = ptvo.disList;
		List<Shop> shopList = ptvo.shopList;
		List<Dessert> dessertList = ptvo.dessertList;
		List<ProductTrendItemVO> ptiList = ptvo.ptiList;
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
				<li><a class="left-nav-item " id="nav-item-2"
					href="/DessertHouse/categorySta">商品分类统计</a></li>
				<li><a class="left-nav-item active" id="nav-item-3" href="#">趋势分析</a></li>
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
				</select> <select class="plan-select" id="js-select-dessert"
					onchange=dessertChange()>

					<%
						for (Dessert dessert : dessertList) {
					%>
					<option value='<%=dessert.getDid()%>'
						<%if (dessert.getDid() == did) {%> selected="selected" <%}%>><%=dessert.getName()%></option>
					<%
						}
					%>
				</select>
			</div>
			
			<div class="charts-div" id="charts"></div>

		</div>
	</div>

	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	
	function disChange(){
		var ajaxDisid = $("#js-select-district").val();
		var ajaxSid = $("#js-select-shop").val();
		var ajaxDid = $("#js-select-dessert").val();
		
		$.ajax({
			type : "post",
			url : "DessertHouse/productTrend",
			async : false,
			data : {
				sid:ajaxSid,
				disid: ajaxDisid,
				did:ajaxDid
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
		var ajaxDid = $("#js-select-dessert").val();
		
		$.ajax({
			type : "post",
			url : "DessertHouse/productTrend",
			async : false,
			data : {
				sid:ajaxSid,
				disid: ajaxDisid,
				did:ajaxDid
			},
			success : function(data) {
				location.reload();
			},
			error : function() {
				alert("fail");
			}
		});
	}
	
	function dessertChange(){
		var ajaxDisid = $("#js-select-district").val();
		var ajaxSid = $("#js-select-shop").val();
		var ajaxDid = $("#js-select-dessert").val();
		
		$.ajax({
			type : "post",
			url : "DessertHouse/productTrend",
			async : false,
			data : {
				sid:ajaxSid,
				disid: ajaxDisid,
				did:ajaxDid
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
	    $('#charts').highcharts({                                          
	        chart: {                                                          
	        },                                                                
	        title: {                                                          
	            text: '商品销售趋势图'                                     
	        },                                                                
	        xAxis: {      
	        	gridLineWidth: 1,
	            categories: [
	            	<%for (int i = 0; i < ptiList.size(); i++) {
				out.print("'" + ptiList.get(i).date + "'");
				if (i < ptiList.size() - 1) {
					out.print(",");
				}
			}%>
                ]
                
	        },  
	        yAxis: [{ //第1个Y轴，序号为0
	        	min:0,
	        	allowDecimals:false,
	            title: {
	                text: '销售单数',
	                style: {
	                    color: '#4572A7'
	                }
	            },
	            labels: {
	                format: '{value} 笔',
	                style: {
	                    color: '#4572A7'
	                }
	            },
	            
	            
	        },{ //第2个Y轴，序号为1
	        	min:0,
	            labels: {
	                format: '{value}元',
	                style: {
	                    color: '#89A54E'
	                }
	            },
	            title: {
	                text: '销售金额',
	                style: {
	                    color: '#89A54E'
	                }
	            },
	            
	            opposite: true
	        }],
	        tooltip: {                                                        
	        	shared: true                                              
	        },                                                                                                                              
	        series: [{                                                              
	            type: 'spline',                                               
	            name: '销售额',     
	            yAxis: 1,
	            data: [
					<%for (int i = 0; i < ptiList.size(); i++) {
				out.print(ptiList.get(i).total);
				if (i != ptiList.size() - 1) {
					out.print(",");
				}
			}%> 
				],   
				tooltip: {
	                valueSuffix: ' 元'
	            },
				selected: true,//默认checkbox勾选
	            marker: {                                                     
	            	lineWidth: 2,                                               
	            	lineColor: Highcharts.getOptions().colors[3],               
	            	fillColor: 'white'                                          
	            }                                                             
	        }
	        , {                                                              
	            type: 'spline',                                               
	            name: '销售单数',     
	            yAxis: 0,
	            data: [
					<%for (int i = 0; i < ptiList.size(); i++) {

				out.print(ptiList.get(i).amount);
				if (i != ptiList.size() - 1) {
					out.print(",");
				}
			}%> 
				], 
				tooltip: {
	                valueSuffix: ' 笔'
	            }, 
	            marker: {                                                     
	            	lineWidth: 2,                                               
	            	lineColor: Highcharts.getOptions().colors[3],               
	            	fillColor: 'white'                                          
	            }                                                             
	        }]                                                                
	    });                                                                   
	});
	</script>
</body>
</html>