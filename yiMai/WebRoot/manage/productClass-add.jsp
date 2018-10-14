<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE jsp PUBLIC "-//W3C//DTD jsp 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/jsp; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../scripts/function.js"></script>
<script>
	function getTime(){			
			//document.getElementById("time").innerHTML=new Date().toLocaleString();
			$("#time").html(new Date().toLocaleString());
			window.setInterval("getTime()", 1000);
		} 
		window.onload=getTime();      
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.action">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.action">用户</a></li>
			<li class="current"><a href="product.action">商品</a></li>
			<li><a href="order.action">订单</a></li>
			<li><a href="guestbook.action">留言</a></li>
			<li><a href="news.action">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员<span style="color:blue;">${user.name}</span>您好，今天是<span id="time"></span>，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<dl>
				<dt>用户管理</dt>
				<dd><a href="user.action">用户管理</a></dd>
			  <dt>商品信息</dt>
				<dd><em><a href="allProduct.action">新增</a></em><a href="productClass.action">分类管理</a></dd>
				<dd><em><a href="productClass.action?id=1">新增</a></em><a href="product.action">商品管理</a></dd>
				<dt>订单管理</dt>
				<dd><a href="order.jsp">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.action">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.action">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>添加分类</h2>
		<div class="manage">
			<form action="addProduct.action" method="post">
				<table class="form">
					<tr>
						<td class="field">父分类：</td>
						<td>
							<select name="parentId">
								<option value="0" selected="selected">根栏目</option>
								<c:forEach items="${li}" var="li">
									<option value="${li.id}">${li.name}</option>
								</c:forEach>
								<!-- <option value="1">电器</option>
								<option value="2">衣服</option> -->
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">分类名称：</td>
						<td><input type="text" class="text" name="className" value="电脑" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
