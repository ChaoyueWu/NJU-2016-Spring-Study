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
		ShopRankVO srvo = (ShopRankVO) request.getAttribute("srvo");
		List<ShopYearRankItemVO> syrList = srvo.syrList;
		List<DistrictYearRankVO> dyrList = srvo.dyrList;
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
				<li><a class="left-nav-item " id="nav-item-1"
					href="/DessertHouse/shopSta">区域店铺盘点</a></li>
				<li><a class="left-nav-item active" id="nav-item-2" href="#">区域店铺排行</a></li>
			</ul>
		</div>
		<div class="right-sta-div">
			<div class="chart-div" id="chart-div"></div>
		</div>
	</div>

	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	$(function () {                                                               
	    $('#chart-div').highcharts({                                          
	        chart: {                                                          
	        },                                                                
	        title: {                                                          
	            text: '区域店铺排行'                                     
	        },                                                                
	        xAxis: {      
	        	gridLineWidth: 1,
	            categories: [
	            	<%for (int i = 0; i < syrList.size(); i++) {
					out.print("'" + syrList.get(i).sname+"（"+syrList.get(i).disname + "）'");
				

				if (i < syrList.size() - 1) {
					out.print(",");
				}
			}%>
                ]
                
	        },  
	        yAxis: [{ //第1个Y轴，序号为0
	        	minorTickInterval: 'auto',
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
	        	minorTickInterval: 'auto',
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
	                                                          
	        series: [{                                                        
	                                                                          
	            type: 'column',                                               
	            name: '销售单数',      
	            yAxis: 0,
	            data: [
	            	<%for (int i = 0; i < syrList.size(); i++) {
				out.print(syrList.get(i).deal);
				if (i != syrList.size() - 1) {
					out.print(",");
				}
			}%>     ] ,
				tooltip: {
	                valueSuffix: ' 笔',
	                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ',
	            },
	        selected: true//默认checkbox勾选
	        },{                                                              
	            type: 'column',                                               
	            name: '销售金额',      
	            yAxis: 1,
	            data: [
	            	<%for (int i = 0; i < syrList.size(); i++) {
				out.print(syrList.get(i).sum);
				if (i != syrList.size() - 1) {
					out.print(",");
				}
			}%>     ]  ,
				tooltip: {
	                valueSuffix: ' 元',
	                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b>',
	                
	            },
				selected: true//默认checkbox勾选
	        }, {                                                              
	            type: 'pie',  
	            title: {
		            text: '地区销售单数'
		        },
	            name: '地区销售单数',    
	            tooltip: {
		    	    pointFormat: '{series.name}:<b>{point.y}笔</b>(<b>{point.percentage:.1f}%</b>)'
		        },
	            data: [
	   				<%
	   			for (int i = 0; i < dyrList.size(); i++) {
	   				out.print("['" + dyrList.get(i).disname + "'," + dyrList.get(i).deal + "]");
	   				if (i != dyrList.size() - 1) {
	   					out.print(",");
	   				}
	   			}%>
	   	            ],                                                           
	            center: [730, 30],                                            
	            size: 80,                                                    
	            showInLegend: false,                                          
	            dataLabels: {                                                 
	                enabled: false                                            
	            }                                                             
	        }, {                                                              
	            type: 'pie',   
	            title: {
		            text: '地区销售金额'
		        },
	            name: '地区销售金额',    
	            tooltip: {
		    	    pointFormat: '{series.name}:<b>{point.y}元</b>(<b>{point.percentage:.1f}%</b>)'
		        },
	            data: [
	   				<%
	   			for (int i = 0; i < dyrList.size(); i++) {
	   				out.print("['" + dyrList.get(i).disname + "'," + dyrList.get(i).sum + "]");
	   				if (i != dyrList.size() - 1) {
	   					out.print(",");
	   				}
	   			}%>
	   	            ],                                                           
	            center: [630, 30],                                            
	            size: 80,                                                    
	            showInLegend: false,                                          
	            dataLabels: {                                                 
	                enabled: false                                            
	            }                                                             
	        }]                                                                
	    });                                                                   
	});
	</script>
</body>
</html>