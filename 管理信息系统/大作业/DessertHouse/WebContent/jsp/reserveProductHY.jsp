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
<title>预定产品</title>
</head>
<body class = "main-bg">
	<%
		Member member = (Member)request.getAttribute("member");
		List<Shop> shops = (List<Shop>)request.getAttribute("shops");
		HashMap<Shop,List<Date>> sdMap = (HashMap<Shop,List<Date>>)request.getAttribute("sdMap");
		HashMap<String ,List<DessertVO>> sddMap = (HashMap<String ,List<DessertVO>>)request.getAttribute("sddMap");
	%>
	<nav class="navbar navbar-default nav-bg" role="navigation">
		<div class="navbar-header">
			<label class="navbar-brand active">DessertHouse</label>
		</div>
		<div>
			<ul class="nav navbar-nav ">
				<li><a href="/DessertHouse/memberMain">会员首页</a></li>
				<li><a href="/DessertHouse/reserveProduct">预定产品</a></li>
				<li><a href="/DessertHouse/myOrder">我的订单</a></li>
				<li><a href="/DessertHouse/consumeRecord">消费记录</a></li>
				<li><a href="/DessertHouse/payRecord">缴费记录</a></li>
				<li><a href="/DessertHouse/personalInfo">个人信息</a></li>
			</ul>

			<ul class="nav navbar-nav pull-right">
				<li><a href="/DessertHouse/logout">注销</a></li>
			</ul>
		</div>
		</nav>
		<div class="buy-panel-layout">
			<div class="head-select">
				<select class="plan-select" id="js-select-shop">
					<option value='0'>请选择店铺</option>
					<%
						for (Shop shop : shops) {
					%>
						<option value='<%=shop.getSid() %>'><%=shop.getSid() %> : <%=shop.getSname() %></option>
					<%
						}
					%>
      			</select>
			</div>
      			<%
						for (Shop shop : shops) {
					%>
						<div id='js-shop-panel-<%=shop.getSid() %>' class="buy-table-panle">
							<%
								List<Date> dateList = sdMap.get(shop);
								for(Date date:dateList){
							%>
								<label class="control-label font-set"><%=date %></label><br/>
								<table class="table table-hover table-condensed table-color">
					   			<tbody>
							<% 
									String temp = String.valueOf(shop.getSid())+String.valueOf(date);
									List<DessertVO> dvoList = sddMap.get(temp);
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
												<input id='<%=date %>-<%=dvo.getDaid() %>-<%=dvo.getDid() %>-<%=dvo.getPrice() %>'type="submit" class="btn btn-success " value="购买" onclick="buyDessert(this)"/>
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
						</div>
					<%
						}
					%>
      			
			
			<div class="dessert-item"></div>
		</div>
		
		<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">确认信息</h4>
				</div>
				<div class="modal-body">
					<form method="post" class="login-form" id="js-add-shop-form">
						<lable class=" font-set modal-label" id='js-label-compute'></lable><br/>
						<lable class=" font-set modal-label" id='js-label-member'></lable><br/>
						<lable class=" font-set modal-label" id='js-label-price'></lable><br/>
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
		var ajaxSid;
		var ajaxDid;
		var ajaxTakeDate;
		var ajaxAmount;
		var ajaxDaid;
		var computePrice;
		function buyDessert(obj){
			var daid = obj.getAttribute("id");
			arr = daid.split('-');
			ajaxTakeDate = daid.substr(0,10);
			ajaxDaid = arr[3];
			ajaxDid = arr[4];
			computePrice = arr[5];
			var tempId = "#js-buy-amount-"+ajaxDaid;
			ajaxAmount = $(tempId).val();
			var discount = '<%=member.getDiscount() %>';
			var computeText = ajaxAmount+"*"+computePrice+"=";
			var total = ajaxAmount*computePrice;
			computeText += total;
			$("#js-label-compute").text(computeText);
			var memberText = "您为";
			memberText += <%=member.getLevel() %>;
			memberText += "级会员，可享受商品";
			memberText += <%=member.getDiscount() %>;
			memberText += "折优惠";
			$("#js-label-member").text(memberText);
			var priceText = "您将实际支付：";
			var realTotal = total * <%=member.getDiscount() %>/10.0;
			priceText += realTotal;
			priceText += "元，获得积分：";
			priceText += realTotal;
			priceText += "点";
			$("#js-label-price").text(priceText);
			$('#myModal').modal();
		}
		//确定购买某商品
		function confirmBuy(){
			$.ajax({
				type : "post",
				url : "DessertHouse/buyDessert",
				async : false,
				data : {
					sid: ajaxSid,
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
		$(document).ready(function() {
			$('.buy-table-panle').hide();
			$('#js-select-shop').change(function(){ 
				var sidString = $(this).val();
				ajaxSid = sidString;//提交的商店编号
				$('.buy-table-panle').hide();
				var jsTableId = "#js-shop-panel-"+sidString;
				$(jsTableId).show();
			});
			
		});
		
	</script>
</body>
</html>