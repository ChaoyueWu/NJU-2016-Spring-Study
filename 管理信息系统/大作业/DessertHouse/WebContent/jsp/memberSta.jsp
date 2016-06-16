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
	List<List<MemberStaVO>> list = (List<List<MemberStaVO>>)request.getAttribute("list");
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
				<li><a class="left-nav-item " id="nav-item-1"
					href="/DessertHouse/crm">客户购买统计</a></li>
				<li><a class="left-nav-item active" id="nav-item-2"
					href="#">客户等级统计</a></li>
				<li><a class="left-nav-item " id="nav-item-3"
					href="/DessertHouse/makePromotion">赠送代金券</a></li>
			</ul>
		</div>
		<div class="right-sta-div">
			<div id='chart-div' class = 'chart-div'></div>
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
			            text: '客户类型购买统计图'                                     
			        },                                                                
			        xAxis: {      
			        	gridLineWidth: 1,
			            categories: [
			            	<%
			            	List<MemberStaVO> temp = list.get(0);
			            	for (int i = 0; i < temp.size(); i++) {
						
							out.print("'" + temp.get(i).date + "'");
						

						if (i < temp.size() - 1) {
							out.print(",");
						}
					}%>
		                ]
		                
			        },  
			        yAxis: [{ //第1个Y轴，序号为0
			        	min: 0,
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
			        	min: 0,
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
			        }
			        ],
			        tooltip: {                                                        
			        	shared: true                                              
			        },                                                                
			                                                                      
			        series: [{                                                        
			                                                                          
			            type: 'spline',                                               
			            name: '银卡会员销售单数',      
			            yAxis: 0,
			            data: [
			            	<%
			            	
			            	for (int i = 0; i < temp.size(); i++) {
						out.print(temp.get(i).deal);
						if (i != temp.size() - 1) {
							out.print(",");
						}
					}%>     ] ,
						tooltip: {
			                valueSuffix: ' 笔',
			                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ',
			            },
			        selected: true//默认checkbox勾选
			        },{                                                              
			            type: 'spline',                                               
			            name: '金卡会员销售单数',      
			            yAxis: 0,
			            data: [
			            	<%
			            	List<MemberStaVO> temp1 = list.get(1);
			            	for (int i = 0; i < temp1.size(); i++) {
						out.print(temp1.get(i).deal);
						if (i != temp1.size() - 1) {
							out.print(",");
						}
					}%>     ]  ,
						tooltip: {
			                valueSuffix: ' 笔',
			                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ',
			                
			            },
						selected: true//默认checkbox勾选
			        },{                                                              
			            type: 'spline',                                               
			            name: '白金卡会员销售单数',      
			            yAxis: 0,
			            data: [
			            	<%
			            	List<MemberStaVO> temp2 = list.get(2);
			            	for (int i = 0; i < temp2.size(); i++) {
						out.print(temp2.get(i).deal);
						if (i != temp2.size() - 1) {
							out.print(",");
						}
					}%>     ]  ,
						tooltip: {
			                valueSuffix: ' 笔',
			                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ',
			                
			            },
						selected: true//默认checkbox勾选
			        }
			        , {                                                              
			            type: 'spline',                                               
			            name: '银卡会员销售额',     
			            yAxis: 1,
			            data: [
							<%for (int i = 0; i < temp.size(); i++) {
						out.print(temp.get(i).total);
						if (i != temp.size() - 1) {
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
			        }, {                                                              
			            type: 'spline',                                               
			            name: '金卡会员销售额',     
			            yAxis: 1,
			            data: [
							<%for (int i = 0; i < temp1.size(); i++) {
						out.print(temp1.get(i).total);
						if (i != temp1.size() - 1) {
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
			        }, {                                                              
			            type: 'spline',                                               
			            name: '白金卡会员销售额',     
			            yAxis: 1,
			            data: [
							<%for (int i = 0; i < temp2.size(); i++) {
						out.print(temp2.get(i).total);
						if (i != temp2.size() - 1) {
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
			        ]                                                                
			    });                                                                   
			});
			</script>
</body>
</html>