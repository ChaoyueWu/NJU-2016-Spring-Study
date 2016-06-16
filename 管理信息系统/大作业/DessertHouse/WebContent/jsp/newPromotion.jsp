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
				<li><a class="left-nav-item " id="nav-item-1" href="/DessertHouse/promotionManage">查看促销策略</a></li>
				<li><a class="left-nav-item active" id="nav-item-2"
					href="#">制定代金券</a></li>
				<li>
			</ul>
		</div>
		<div class="right-sta-div">
			<!-- 制定代金券 -->

			<div class="m-panel" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
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
								<br /> <button type="button" class="btn btn-info submit-promotion-but" onclick= submitPromotion()>赠送代金券</button>
							</form>
						</div>
						<div class="modal-footer">
							
						</div>
					</div>
<!-- 
					<div class="panel panel-success promotion-make-panel">
						<div class="panel-heading">
							<h3 class="panel-title">制定代金券</h3>
						</div>
						<div class="panel-body">
							<div class="control-group pro-little-div">
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
							<div class="control-group pro-little-div">
								<label class="control-label" style="font-weight: bold">代金券金额：</label>
								<div class="controls">
									<input type="number" name="value" class="plan-amount"
										id='js-value' min="0" value="0"> <label
										class="control-label ">元</label>
								</div>
							</div>
							<br />
							<div class="control-group pro-little-div">
								<label class="control-label" style="font-weight: bold">使用规则：</label>
								<div class="controls">

									<label class="control-label" style="font-weight: bold">满</label>
									<input type="number" name="value" class="plan-amount"
										id='js-require' min="0" value="0"> <label
										class="control-label ">元可用</label>
								</div>
							</div>
							<br />
							<div class="control-group pro-little-div">
								<label class="control-label " style="font-weight: bold">使用期限:</label>
								<div class="controls">

									<input type="date" name="ddl" id='js-ddl' class="date-pick"
										value="0"> <label class="control-label ">之前</label>
								</div>
							</div>
							<br /> <input type="submit" class="btn btn-success" value="提交">
							-->
							<!--  
					<div class="">
						<label class="control-label" style="font-weight: bold">赠送对象类别：</label>
						<div class="">
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
					<div class="">

						<div class="">
							<label class="control-label" style="font-weight: bold">代金券金额:</label>

							<input type="number" name="value" class="plan-amount"
								id='js-value' min="0" value="0"> <label
								class="control-label ">元</label>
						</div>
					</div>
					<br />
					<div class="">

						<div class="">
							<label class="control-label" style="font-weight: bold">使用规则:</label>
							<label class="control-label" style="font-weight: bold">满</label>
							<input type="number" name="value" class="plan-amount"
								id='js-require' min="0" value="0"> <label
								class="control-label ">元可用</label>
						</div>
					</div>
					<br />
					<div class="">

						<div class="">
							<label class="control-label " style="font-weight: bold">使用期限:</label>
							<input type="date" name="ddl" id='js-ddl' class="date-pick"
								value="0"> <label class="control-label ">之前</label>
						</div>
					</div>
					<div class="">

						<div class="">
							<button type="button" class="btn btn-success"
								onclick='submitPromotion()'>制定</button>
						</div>
					</div>
					-->
						</div>
					</div>
				</div>
			</div>

			<script src="../dist/js/jquery-1.9.1.min.js"></script>
			<script src="../dist/js/bootstrap.js"></script>
			<script src="js/highcharts.js" type="text/javascript"></script>
			<script type="text/javascript" charset="utf-8">
				function submitPromotion() {
					var level = $('#level-radio input:radio:checked').val();
					var value = $("#js-value").val();
					var require = $("#js-require").val();
					var date = $("#js-ddl").val();
					$.ajax({
						type : "post",
						url : "DessertHouse/makePromotion",
						async : false,
						data : {
							level:level,
							value:value,
							require:require,
							date:date,
						},
						success : function(data) {
							alert("制定成功");
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