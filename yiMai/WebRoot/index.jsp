<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="welcomeImage">
    {<img width="100%" height="150" src="images/banner.jpg" alt="welcome">
</div>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="shopping.jsp" id="shoppingBag" class="shopping">购物车${sum }件</a>
		<c:if test="${empty user}">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
		</c:if>
		<c:if test="${not empty user }">
			欢迎登录:
			<c:if test="${user.status==1}">
				<span style="font-weight:bold;margin-right:5px;">${user.id }</span>您是普通用户
				<a href="guest.action">留言</a>
			</c:if>
			<c:if test="${user.status==2}">
				管理员：${user.name }
				<a href="guest.action">留言</a><a href="manage/index.jsp">后台管理</a>
			</c:if>
			<a class="button" href="loginOut.action">注销</a>		
		</c:if>
	</div>
    <div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="index.action">首页</a></li>
			<c:forEach items="${pb.list}" var="c">
				<li><a href="index.action?cpid=${c.parent.id}">${c.parent.name }</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<c:forEach items="${cli}" var="cli">
				<li><a href="product-list.action?id=${cli.id}">${cli.name}</a></li>
			</c:forEach>
			<!-- <li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li> -->
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			<c:forEach items="${pb.list}" var="li">
				<dt>${li.parent.name }</dt>
				<c:forEach items="${li.childs }" var="lc">
					<dd><a href="product-list.action?id=${lc.id}">${lc.name}</a></dd>
				</c:forEach>
			</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
		<h2>最近浏览</h2>
			<c:forEach items="${lp}" var="lp">
				<dl class="clearfix">
					<dt><img src="pic/${lp.fileName}" style="width:60px;"/></dt>
					<dd><a href="product-view.action?id=${lp.id }"  target="_self">${lp.name}</a><a href="product-view.action?id=${lp.id }"></a></dd>
				</dl>
			</c:forEach>
	  </div>
	</div>
	<div class="main">
		<div class="price-off">
            <div class="slideBox">
                <ul id="slideBox">
                    <li><img src="images/product/banner_1.jpg"/></li>
                    <li><img src="images/product/banner_2.jpg"/></li>
                    <li><img src="images/product/banner_3.jpg"/></li>
                    <li><img src="images/product/banner_4.jpg"/></li>
                </ul>
            </div>
			<h2>商品列表</h2>
			<ul class="product clearfix">
				<c:forEach items="${pbProduct.list }" var="p">
					<li>
						<dl>
							<dt><a href="product-view.action?id=${p.id }"  target="_self"><img src="pic/${p.fileName }" /></a></dt>
							<dd class="title"><a href="product-view.action?id=${p.id}" target="_self">${p.name}</a></dd>
							<dd class="price">￥${p.price }</dd>
						</dl>
					</li>
				</c:forEach>
				
			</ul>
		</div>
		<div class="side">			
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<c:forEach items="${pbNews.list}" var="pn">
						<li><a href="news-view.action?id=${pn.id}"  target="_self">${pn.title}</a><span style="margin-left:15px;"><fmt:formatDate value="${pn.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></span></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
    </div>
</div>
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
