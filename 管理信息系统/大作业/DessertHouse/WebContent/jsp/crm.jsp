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
		List<List<MemberMonthStaVO>> mmsList = (List<List<MemberMonthStaVO>>) request.getAttribute("mmsList");
		int month = (int) request.getAttribute("month");
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
				<li><a class="left-nav-item active" id="nav-item-1" href="#">客户购买统计</a></li>
				<li><a class="left-nav-item" id="nav-item-2"
					href="/DessertHouse/memberSta">客户等级统计</a></li>
				<li><a class="left-nav-item" id="nav-item-3"
					href="/DessertHouse/makePromotion">赠送代金券</a></li>
			</ul>
		</div>
		<div class="right-sta-div">
			<div class="head-select">
				<select class="plan-select" id="js-select-month"
					onchange=monthChange()>

					<%
						for (int i = 1; i <= 6; i++) {
							String m = "2016-0" + i;
					%>
					<option value='<%=i%>' <%if (i == month) {%> selected="selected"
						<%}%>><%=m%></option>
					<%
						}
					%>
				</select>
				<!-- 
				<button type="button" class="btn btn-info float-right"
					data-toggle="modal" data-target="#myModal">赠送代金券</button>
				-->
			</div>

			<div class="panel-group" id="accordion">
				<%
					String[] level = {"银卡会员", "金卡会员", "钻石卡会员"};
					for (int i = 1; i <= 3; i++) {
						List<MemberMonthStaVO> list = mmsList.get(i - 1);
				%>
				<div class="panel panel-default hide-div">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion"
								href='#collapse-<%=i%>'> <span id='js-weekday-<%=i%>'><%=level[i - 1]%></span>
							</a>
						</h4>
					</div>
					<br />
					<div id="collapse-<%=i%>" class="panel-collapse collapse in">
						<div class="panel-body">
							<table class="table table-hover table-condensed " id="js-table">
								<thead>
									<tr>
										<th>会员编号</th>
										<th>本月总消费单数</th>
										<th>本月总消费金额</th>
										<th>上一月消费单数</th>
										<th>上一月消费金额</th>
										<th>本月与上月消费单数比率</th>
									</tr>
								</thead>
								<tbody>
									<%
										int j = 0;
											for (MemberMonthStaVO item : list) {
									%>
									<tr>
										<td><label class="control-label "
											id='js-did-<%=i%>-<%=j%>'><%=item.cid%></label></td>
										<td><label class="control-label"
											id='js-name-<%=i%>-<%=j%>'><%=item.deal%>笔</label></td>
										<td><label class="control-label "
											id='js-did-<%=i%>-<%=j%>'><%=item.total%>元</label></td>
										<td><label class="control-label"
											id='js-name-<%=i%>-<%=j%>'><%=item.lastDeal%>笔</label></td>
										<td><label class="control-label "
											id='js-did-<%=i%>-<%=j%>'><%=item.lastTotal%>元</label></td>
										<td><label class="control-label"
											id='js-name-<%=i%>-<%=j%>'> <%
 	double p = item.deal;
 			if (item.lastDeal == 0) {
 				p = p * 10000 / 100;
 			} else {
 				p = item.percent;
 			}
 %> <%=p%> %
										</label></td>

									</tr>

									<%
										j++;

											}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">赠送代金券</h4>
				</div>
				<div class="modal-body">
					<form class="login-form" id="js-promotion-form">
						<div class="control-group">
							<label class="control-label" style="font-weight: bold">赠送对象类别：</label>
							<div class="controls">
								<div class="radio radio-div" id="level-radio">
									<label class="checkbox-inline"> <input type="radio"
										name="optionsRadiosinline" id="optionsRadios3" value="1"
										checked> 银卡会员
									</label> <label class="checkbox-inline"> <input type="radio"
										name="optionsRadiosinline" id="optionsRadios4" value="2">
										金卡会员
									</label> <label class="checkbox-inline"> <input type="radio"
										name="optionsRadiosinline" id="optionsRadios5" value="3">
										钻石卡会员
									</label>
								</div>
							</div>
						</div>
						<br />
						<div class="control-group">

							<div class="controls">
								<label class="control-label" style="font-weight: bold">代金券金额:</label>

								<input type="number" name="value" class="plan-amount"
									id='js-value' min="0" value="0"> <label
									class="control-label ">元</label>
							</div>
						</div>
						<br />
						<div class="control-group">

							<div class="controls">
								<label class="control-label" style="font-weight: bold">使用规则:</label>
								<label class="control-label" style="font-weight: bold">满</label>
								<input type="number" name="value" class="plan-amount"
									id='js-require' min="0" value="0"> <label
									class="control-label ">元可用</label>
							</div>
						</div>
						<br />
						<div class="control-group">

							<div class="controls">
								<label class="control-label " style="font-weight: bold">使用期限:</label>
								<input type="date" name="ddl" id='js-ddl' class="date-pick"
									value="0"> <label class="control-label ">之前</label>
							</div>
						</div>
						<br /> <input type="submit" class="btn btn-success login-btn"
							value="提交">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
	<!-- /.modal -->
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script src="js/highcharts.js" type="text/javascript"></script>
	<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$("#js-promotion-form").submit(function() {
			alert("???");
			var level = $('#level-radio input:radio:checked').val();
			var value = $("#js-value").val();
			var require = $("#js-require").val();
			var date = $("#js-ddl").val();
			var month = $("#js-select-month").val();
			alert("level:"+level+",value:"+value+",require:"+require+",date:"+date+",month:"+month);
			$.ajax({
				type : "post",
				url : "DessertHouse/makePromotion",
				async : false,
				data : {
					level:level,
					value:value,
					require:require,
					date:date,
					month:month,
				},
				success : function(data) {
					alert("success");
				},
				error : function() {
					alert("fail");
				}
			});
		})
		
	});
	function monthChange(){
		var month = $("#js-select-month").val();
		$.ajax({
			type : "post",
			url : "DessertHouse/crm",
			async : false,
			data : {
				month:month,
			},
			success : function(data) {
				location.reload();
			},
			error : function() {
				alert("fail");
			}
		});
	}
	
	</script>
</body>
</html>