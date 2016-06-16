<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
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
<script src="js/bootstrap.min.js"></script>
<title>销售产品</title>
</head>
<body class = "main-bg">
	<%
		List<Date> dateList = (List<Date>)request.getAttribute("dateList");
		HashMap<Date,List<DessertVO>> ddMap = (HashMap<Date,List<DessertVO>>)request.getAttribute("ddMap");
	%>
	<nav class="navbar navbar-default nav-bg" role="navigation">
		<div class="navbar-header">
			<label class="navbar-brand active">DessertHouse</label>
		</div>
		<div>
			<ul class="nav navbar-nav ">
				<li><a href="/DessertHouse/saleDessert">销售商品</a></li>
				<li><a href="/DessertHouse/memberManage">会员管理</a></li>
			</ul>

			<ul class="nav navbar-nav pull-right">
				<li><a href="/DessertHouse/logout">注销</a></li>
			</ul>
		</div>
	</nav>
	<div class="buy-panel-layout">
			<div class="head-select">
				<select class="plan-select" id="js-select-date">
					<option value='0'>请选择预定时间</option>
					<%
						for (Date date : dateList) {
					%>
						<option value='<%=date %>'><%=date %></option>
					<%
						}
					%>
      			</select>
			</div>
			<%
				for (Date date : dateList) {
			%>
						<div id='js-shop-panel-<%=date %>' class="buy-table-panle">
							<table class="table table-hover table-condensed table-color">
					   			<tbody>
								<% 
									List<DessertVO> dvoList = ddMap.get(date);
									for(DessertVO dvo:dvoList){
										
								%>
										<tr>
											<td><%=dvo.getDid() %></td>
											<td><%=dvo.getName() %></td>
											<td>
												<img src='<%=dvo.getImg() %>' class="img-rounded">
											</td>
											<td>
												<label class="control-label font-set">数量：</label>
												<%=dvo.getAmount() %>
											</td>
											<td>
												<label class="control-label font-set">价格：</label>
												<%=dvo.getPrice() %>
											</td>
											<td>
												<label class="control-label font-set">购买数量：</label>
												<input id='js-buy-amount-<%=dvo.getDaid() %>' type="number" name="value" class="plan-amount" id='' min = "00" max='<%=dvo.getAmount() %>' value = "0">
												<label class="control-label font-set">个</label>
											</td>
											<td>
												<input id='<%=date %>-<%=dvo.getDaid() %>-<%=dvo.getDid() %>-<%=dvo.getPrice() %>-1'type="submit" class="btn btn-success " value="现金购买" onclick="buyDessertXJ(this)"/>
												<input id='<%=date %>-<%=dvo.getDaid() %>-<%=dvo.getDid() %>-<%=dvo.getPrice() %>-2'type="submit" class="btn btn-success " value="会员卡购买" onclick="buyDessertHY(this)"/>
											</td>
										</tr>
							<% 
									}
							%>
							</tbody>
							</table>
							</div>
							<% 
								}
							%>
						
		</div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">输入会员信息</h4>
				</div>
				<div class="modal-body">
					<form method="post" class="login-form" id="js-add-shop-form">
						<lable class=" font-set modal-label">请输入七位会员卡号</lable><br/>
						<input id="js-cid" type="text" class="form-control" name="name"  />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal" onclick='confirmBuy()'>确定购买 </button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消 </button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
		<!-- /.modal -->
		
	<script src="../dist/js/jquery-1.9.1.min.js"></script>
	<script src="../dist/js/bootstrap.js"></script>
	<script type="text/javascript" charset="utf-8">
		var ajaxDid;//
		var ajaxTakeDate;//
		var ajaxAmount;
		var ajaxDaid;//
		var computePrice;//
		var ajaxCid;//选择会员卡支付时
		$(document).ready(function() {
			$('.buy-table-panle').hide();
			$('#js-select-date').change(function(){ 
				var dateString = $(this).val();
				$('.buy-table-panle').hide();
				var jsTableId = "#js-shop-panel-"+dateString;
				$(jsTableId).show();
			});
		});
		//现金支付
		function buyDessertXJ(obj){
			var daid = obj.getAttribute("id");
			arr = daid.split('-');
			ajaxTakeDate = daid.substr(0,10);
			ajaxDaid = arr[3];
			ajaxDid = arr[4];
			computePrice = arr[5];
			var tempId = "#js-buy-amount-"+ajaxDaid;
			ajaxAmount = $(tempId).val();
			$.ajax({
				type : "post",
				url : "DessertHouse/saleDessertMoney",//to be added
				async : false,
				data : {
					did: ajaxDid,
					takeDate: ajaxTakeDate,
					amount: ajaxAmount,
					daid: ajaxDaid,
					price: computePrice,
				},
				success : function(data) {
					alert("购买成功");
					location.reload();
				},
				error : function() {
					alert("购买失败");
				}
			});
		}
		//会员卡支付
		function buyDessertHY(obj){
			var daid = obj.getAttribute("id");
			arr = daid.split('-');
			ajaxTakeDate = daid.substr(0,10);
			ajaxDaid = arr[3];
			ajaxDid = arr[4];
			computePrice = arr[5];
			var tempId = "#js-buy-amount-"+ajaxDaid;
			ajaxAmount = $(tempId).val();
			ajaxAmount = $(tempId).val();
			$('#myModal').modal();
			//从modal中获得ajaxCid
		}
		//会员卡确认购买
		function confirmBuy(){
			var ajaxCid = $("#js-cid").val();
			$.ajax({
				type : "post",
				url : "DessertHouse/saleDessertMember",//to be added
				async : false,
				data : {
					did: ajaxDid,
					takeDate: ajaxTakeDate,
					amount: ajaxAmount,
					daid: ajaxDaid,
					price: computePrice,
					cid: ajaxCid,
				},
				success : function(data) {
					alert("购买成功");
					location.reload();
				},
				error : function() {
					alert("购买失败");
				}
			});
		}
	</script>
</body>
</html>