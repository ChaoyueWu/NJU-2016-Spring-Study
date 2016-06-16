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
		ShopStaVO ssvo = (ShopStaVO) request.getAttribute("ssvo");
		int sid = (int) request.getAttribute("sid");
		int disid = (int) request.getAttribute("disid");
		int choice = (int) request.getAttribute("choice");
		List<District> disList = ssvo.disList;
		List<Shop> shopList = ssvo.shopList;
		List<ShopStaItemVO> ssiList = ssvo.ssiList;
		InValidAnalysis ia = ssvo.inValidAnalysis;
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
		<div class="leftnav">
			<ul class="nav nav-pills nav-stacked">
				<li><a class="left-nav-item active" id="nav-item-1" href="#">区域店铺盘点</a></li>
				<li><a class="left-nav-item" id="nav-item-2"
					href="/DessertHouse/shopRank">区域店铺排行</a></li>
			</ul>
		</div>
		<div class="right-sta-div">
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

				<div class="radio radio-div" id="sta-radio">
					<label class="checkbox-inline"> <input type="radio"
						name="optionsRadiosinline" id="optionsRadios3" value="0"
						<%if (choice == 0) {%> checked <%}%>> 日统计
					</label> <label class="checkbox-inline"> <input type="radio"
						name="optionsRadiosinline" id="optionsRadios4" value="1"
						<%if (choice == 1) {%> checked <%}%>> 月统计
					</label>
				</div>
				<div class="alert alert-warning invalidAnalysis">
					共有<span class="label label-warning"><%=ia.invalidDeal%></span>笔订单被取消，占总订单的<span
						class="label label-warning"><%=ia.percent%>%</span>,如果挽回这些被取消的订单，则可以挽回<span
						class="label label-warning"><%=ia.invalidSum%>元</span>。
				</div>

			</div>
			<div class="chart-div" id="chart-div"></div>
		</div>
	</div>

	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	function disChange(){
		var ajaxDisid = $("#js-select-district").val();
		var ajaxSid = $("#js-select-shop").val();
		var ajaxChoice = $('#sta-radio input:radio:checked').val();
		$.ajax({
			type : "post",
			url : "DessertHouse/shopSta",
			async : false,
			data : {
				sid:ajaxSid,
				disid: ajaxDisid,
				choice:ajaxChoice
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
		var ajaxChoice = $('#sta-radio input:radio:checked').val();
		$.ajax({
			type : "post",
			url : "DessertHouse/shopSta",
			async : false,
			data : {
				sid:ajaxSid,
				disid: ajaxDisid,
				choice:ajaxChoice
			},
			success : function(data) {
				location.reload();
			},
			error : function() {
				alert("fail");
			}
		});
	}
	$(function(){
		  $(":radio").click(function(){
		   var ajaxDisid = $("#js-select-district").val();
			var ajaxSid = $("#js-select-shop").val();
			var ajaxChoice = $('#sta-radio input:radio:checked').val();
			$.ajax({
				type : "post",
				url : "DessertHouse/shopSta",
				async : false,
				data : {
					sid:ajaxSid,
					disid: ajaxDisid,
					choice:ajaxChoice
				},
				success : function(data) {
					location.reload();
				},
				error : function() {
					alert("fail");
				}
			});
		  });
	});
	
	$(function () {                                                               
	    $('#chart-div').highcharts({                                          
	        chart: {                                                          
	        },                                                                
	        title: {                                                          
	            text: '销售分析图'                                     
	        },                                                                
	        xAxis: {      
	        	gridLineWidth: 1,
	            categories: [
	            	<%for (int i = 0; i < ssiList.size(); i++) {
				if (ssiList.get(i).date.length() > 7) {
					out.print("'" + ssiList.get(i).date.substring(5) + "'");
				} else {
					out.print("'" + ssiList.get(i).date + "'");
				}

				if (i < ssiList.size() - 1) {
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
	        },{ //第3个Y轴，序号为2
	        	min: 0,
	        	max:100,
	            labels: {
	                format: '{value}%',
	                style: {
	                    color: '#AA4643'
	                }
	            },
	            title: {
	                text: '订单比率',
	                style: {
	                    color: '#AA4643'
	                }
	            },
	            opposite: true,
	            
	        }
	        ],
	        tooltip: {                                                        
	        	shared: true                                              
	        },                                                                
	        plotOptions: {
	            column: {
	                stacking: 'normal'
	            },
	            line:{
	                events :{
	                    checkboxClick: function(event) {
	                        if(event.checked==true) {
	                            this.show();
	                        }
	                        else {
	                            this.hide();
	                        }
	                    },
	                    legendItemClick:function(event) {//return false 即可禁用LegendIteml，防止通过点击item显示隐藏系列
	                        return false;
	                    }
	                }
	            }
	        },                                                              
	        series: [{                                                        
	                                                                          
	            type: 'column',                                               
	            name: '会员线上销售单数',      
	            yAxis: 0,
	            stack:'deal',
	            data: [
	            	<%for (int i = 0; i < ssiList.size(); i++) {
				out.print(ssiList.get(i).onlineDeal);
				if (i != ssiList.size() - 1) {
					out.print(",");
				}
			}%>     ] ,
				tooltip: {
	                valueSuffix: ' 笔',
	                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
	            },
	        selected: true//默认checkbox勾选
	        },{                                                              
	            type: 'column',                                               
	            name: '会员线下销售单数',      
	            yAxis: 0,
	            stack:'deal',
	            data: [
	            	<%for (int i = 0; i < ssiList.size(); i++) {
				out.print(ssiList.get(i).totalDeal - ssiList.get(i).onlineDeal - ssiList.get(i).notMemberDeal);
				if (i != ssiList.size() - 1) {
					out.print(",");
				}
			}%>     ]  ,
				tooltip: {
	                valueSuffix: ' 笔',
	                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
	                
	            },
				selected: true//默认checkbox勾选
	        },{                                                              
	            type: 'column',                                               
	            name: '非会员销售单数',      
	            yAxis: 0,
	            stack:'deal',
	            data: [
	            	<%for (int i = 0; i < ssiList.size(); i++) {
				out.print(ssiList.get(i).notMemberDeal);
				if (i != ssiList.size() - 1) {
					out.print(",");
				}
			}%>     ]  ,
				tooltip: {
	                valueSuffix: ' 笔',
	                pointFormat: '<span style="color:{series.color}">{series.name}</span>: <b>{point.y}</b> ({point.percentage:.0f}%)<br/>',
	            },
				selected: true//默认checkbox勾选
	        }
	        , {                                                              
	            type: 'spline',                                               
	            name: '销售额',     
	            yAxis: 1,
	            data: [
					<%for (int i = 0; i < ssiList.size(); i++) {
				out.print(ssiList.get(i).realTotal);
				if (i != ssiList.size() - 1) {
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
	            name: '会员订单比率',     
	            yAxis: 2,
	            data: [
					<%for (int i = 0; i < ssiList.size(); i++) {
				double num = (ssiList.get(i).totalDeal - ssiList.get(i).notMemberDeal)
						/ (double) ssiList.get(i).totalDeal;
				num = (double) Math.round(num * 10000) / 100;
				out.print(num);
				if (i != ssiList.size() - 1) {
					out.print(",");
				}
			}%> 
				], 
				tooltip: {
	                valueSuffix: ' %'
	            }, 
				visible: false,//默认不显示
	            marker: {                                                     
	            	lineWidth: 2,                                               
	            	lineColor: Highcharts.getOptions().colors[3],               
	            	fillColor: 'white'                                          
	            }                                                             
	        }, {                                                              
	            type: 'spline',                                               
	            name: '非会员订单比率',     
	            yAxis: 2,
	            data: [
					<%for (int i = 0; i < ssiList.size(); i++) {
				double num = ssiList.get(i).notMemberDeal / (double) ssiList.get(i).totalDeal;
				num = (double) Math.round(num * 10000) / 100;
				out.print(num);
				if (i != ssiList.size() - 1) {
					out.print(",");
				}
			}%> 
				], 
				tooltip: {
	                valueSuffix: ' %'
	            },    
				visible: false,//默认不显示
	            marker: {                                                     
	            	lineWidth: 2,                                               
	            	lineColor: Highcharts.getOptions().colors[3],               
	            	fillColor: 'white'                                          
	            }                                                             
	        }, {                                                              
	            type: 'spline',                                               
	            name: '线下订单比率',     
	            yAxis: 2,
	            data: [
					<%for (int i = 0; i < ssiList.size(); i++) {
				double num = (ssiList.get(i).totalDeal - ssiList.get(i).onlineDeal) / (double) ssiList.get(i).totalDeal;
				num = (double) Math.round(num * 10000) / 100;
				out.print(num);
				if (i != ssiList.size() - 1) {
					out.print(",");
				}
			}%> 
				], 
				tooltip: {
	                valueSuffix: ' %'
	            }, 
				visible: false,//默认不显示
	            marker: {                                                     
	            	lineWidth: 2,                                               
	            	lineColor: Highcharts.getOptions().colors[3],               
	            	fillColor: 'white'                                          
	            }                                                             
	        }, {                                                              
	            type: 'spline',                                               
	            name: '线上订单比率',     
	            yAxis: 2,
	            data: [
					<%for (int i = 0; i < ssiList.size(); i++) {
				double num = ssiList.get(i).onlineDeal / (double) ssiList.get(i).totalDeal;
				num = (double) Math.round(num * 10000) / 100;
				out.print(num);
				if (i != ssiList.size() - 1) {
					out.print(",");
				}
			}%> 
				],  
				tooltip: {
	                valueSuffix: ' %'
	            }, 
				visible: false,//默认不显示
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