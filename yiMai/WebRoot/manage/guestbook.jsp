<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	function delById(id){
		$.get("delGuest.action","id="+id,function(result){
			if(result=="true"){
					alert("删除成功！");
				}else{
					alert("删除失败！");
				}
				window.location.href="guestbook.action";
		});
	}
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
			<li><a href="product.action">商品</a></li>
			<li><a href="order.action">订单</a></li>
			<li class="current"><a href="guestbook.action">留言</a></li>
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
				<dd><a href="order.action">订单管理</a></dd>
				<dt>留言管理</dt>
				<dd><a href="guestbook.action">留言管理</a></dd>
				<dt>新闻管理</dt>
				<dd><em><a href="news-add.jsp">新增</a></em><a href="news.action">新闻管理</a></dd>
			</dl>
		</div>
	</div>
	<div class="main">
		<h2>留言管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>留言内容</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${pb.list}" var="li" varStatus="vs">
					<tr
						<c:if test="${vs.index%2==0}">
							style="background:gray;"
						</c:if>
					>
					<td class="first w4 c">${li.id}</td>
					<td class="w1 c">${li.nickName}</td>
					<td>${li.content}</td>
					<td class="w1 c">
					<c:if test="${not empty li.reply }">
						已回复
					</c:if>
					</td>
					<td class="w1 c"><a href="guestbook-modify.action?id=${li.id}">
					<c:if test="${not empty li.reply }">
						修改
					</c:if>
					<c:if test="${empty li.reply }">
						回复
					</c:if>
					</a> <a class="manageDel" href="javascript:delById(${li.id})">删除</a></td>				
				</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pb.pageNo>1 }">
	   					<li><a href="guestbook.action?pageNo=1&pageSize=${pb.pageSize}">首页</a></li>
	   					<li><a href="guestbook.action?pageNo=${pb.pageNo-1}&pageSize=${pb.pageSize }">上一页</a></li>
	   					<li>...</li>
	   				</c:if>
					<li class="current">当前页${pb.pageNo}</li>
					<c:if test="${pb.pageNo<pb.countPage }">
						<li>...</li>
	   					<li><a href="guestbook.action?pageNo=${pb.pageNo+1}&pageSize=${pb.pageSize }">下一页</a></li>
	   					<li><a href="guestbook.action?pageNo=${pb.countPage}&pageSize=${pb.pageSize }">尾页</a></li>
	   				</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
