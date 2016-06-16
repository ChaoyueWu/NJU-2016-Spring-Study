<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="edu.nju.desserthouse.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>店员管理</title>
</head>
<body class="main-bg">
	<%
		List<ShopClerk> shopClerkList = (List<ShopClerk>) request.getAttribute("shopClerkList");
		List<Shop> shopList = (List<Shop>) request.getAttribute("shopList");
	%>
	<nav class="navbar navbar-default nav-bg" role="navigation">
	<div class="navbar-header">
		<label class="navbar-brand active">DessertHouse</label>
	</div>
	<div>
		<ul class="nav navbar-nav ">
			<li><a href="/DessertHouse/shopManage">店面管理</a></li>
			<li><a href="/DessertHouse/shopClerkManage">店员管理</a></li>
		</ul>

		<ul class="nav navbar-nav pull-right">
			<li><a href="/DessertHouse/logout">注销</a></li>
		</ul>
	</div>
	</nav>
	<div class="main">
		<div class="btn-add-shop">
			<button type="button" class="btn btn-success" data-toggle="modal"
				data-target="#myModal">新增店员</button>
		</div>
		<table class="table table-hover table-condensed ">
			<thead>
				<tr>
					<th>店员编号</th>
					<th>所属店面编号</th>
					<th>店员姓名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (ShopClerk item : shopClerkList) {
				%>
				<tr>
					<td><%=item.getScid() %></td>
					<td><%=item.getSid() %></td>
					<td><%=item.getName() %></td>
					<td>
						<button type="button" class="btn btn-success"
							id='js-modify-<%=item.getScid()%>' onclick="modifyShopClerk(this)">修改</button>
						<button type="button" class="btn btn-danger"
							id='js-delete-<%=item.getScid()%>' onclick="deleteShopClerk(this)">删除</button>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增店员</h4>
				</div>
				<div class="modal-body">
					<form method="post" class="login-form" id="js-add-shop-form">
						<div class="control-group">
							<label class="control-label" style="font-weight: bold">店员姓名：</label>
							<div class="controls">
								<input id="js-scname" type="text" class="form-control"
									name="scname" class="form-control" required />

							</div>
						</div>
						<br />
						<div class="control-group">
							<label class="control-label" style="font-weight: bold">登录密码：</label>
							<div class="controls">
								<input id="js-pwd" type="password" class="form-control"
									name="pwd" class="form-control" required />

							</div>
						</div>
						<br />
						<div class="control-group">
							<label class="control-label">所属店面编号：</label>
							<select class="form-control" id="js-select-shop">
							<%
								for (Shop temp : shopList) {
							%>
								<option><%=temp.getSid() %></option>
							<%
								}
							%>
      						</select>
						</div>
						<br /> <input type="submit" class="btn btn-success login-btn"
							value="增加">
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
		
			<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改店员</h4>
				</div>
				<div class="modal-body">
					<form method="post" class="login-form" id="js-add-shop-form1">
						<div class="control-group">
							<label class="control-label" style="font-weight: bold">店员姓名：</label>
							<div class="controls">
								<input id="js-scname1" type="text" class="form-control"
									name="scname" class="form-control" required />

							</div>
						</div>
						<br />
						<div class="control-group">
							<label class="control-label" style="font-weight: bold">登录密码：</label>
							<div class="controls">
								<input id="js-pwd1" type="password" class="form-control"
									name="pwd" class="form-control" required />

							</div>
						</div>
						<br />
						<div class="control-group">
							<label class="control-label">所属店面编号：</label>
							<select class="form-control" id="js-select-shop1">
							<%
								for (Shop temp : shopList) {
							%>
								<option><%=temp.getSid() %></option>
							<%
								}
							%>
      						</select>
						</div>
						<br /> <input type="submit" class="btn btn-success login-btn js-btn-modify"
							value="确定修改">
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
		<script type="text/javascript" charset="utf-8">
			function modifyShopClerk(obj) {
				var id = obj.getAttribute("id");
				id = id.substr(10);
				$(".js-btn-modify").attr("id",id);
				$('#myModal1').modal();
			}
			function deleteShopClerk(obj) {
				var id = obj.getAttribute("id");
				id = id.substr(10);
				$.ajax({
					type : "post",
					url : "DessertHouse/deleteShopClerk",
					async : false,
					data : {
						scid : id,
					},
					success : function(data) {
						alert("删除成功");
						location.reload();
					},
					error : function() {
						alert("删除失败");
					}
				});
			}
			$(document).ready(function() {
				//增加
				$("#js-add-shop-form").submit(function() {
					$.ajax({
						type : "post",
						url : "DessertHouse/addShopClerk",
						async : false,
						data : {
							scname : $("#js-scname").val(),
							pwd : $("#js-pwd").val(),
							sid : $("#js-select-shop").val(),
						},
						success : function(data) {
							alert("增加成功");
						},
						error : function() {
							alert("增加失败");
						}
					});
				})
				//修改
				$("#js-add-shop-form1").submit(function() {
					$.ajax({
						type : "post",
						url : "DessertHouse/updateShopClerk",
						async : false,
						data : {
							scname : $("#js-scname1").val(),
							pwd : $("#js-pwd1").val(),
							sid : $("#js-select-shop1").val(),
							scid : $(".js-btn-modify").attr("id")
						},
						success : function(data) {
							alert("修改成功");
							location.reload();
						},
						error : function() {
							alert("修改失败");
						}
					});
				})
			});
		</script>
</body>
</html>