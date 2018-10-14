<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="shopping.jsp" class="shopping">购物车${sum}件</a>
		<c:if test="${empty user}">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
		</c:if>
		<c:if test="${not empty user}">
			欢迎登录
			<c:if test="${user.status==1}">
				您是普通用户:${user.id }
				<a href="guestbook.jsp">留言</a>
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
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
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
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.action">易买网</a>&gt;<c:if test="${not empty pc}"><a href="product-list.action?pcid=${pc.id}">${pc.name}</a>&gt;${c.name}</c:if>
	<c:if test="${empty pc }">${cname}</c:if>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${pb.list }" var="li">
				<dt>${li.parent.name }</dt>
				<c:forEach items="${li.childs }" var="lc">
					<dd><a href="product-list.action?id=${lc.id}">${lc.name }</a></dd>
				</c:forEach>
			</c:forEach>
			</dl>
		</div>
		<div class="spacer"></div>
		<%-- <div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach items="${lp}" var="lp">
					<dt><img src="pic/${lp.fileName}"/></dt>
					 <dd><a href="product-view.action?id=${lp.id }"  target="_self">${lp.name}</a><a href="product-view.action?id=${lp.id }"></a></dd>
					<dt>&nbsp;</dt>
					<dd>&nbsp;</dd>
				</c:forEach>
		  </dl>
		</div> --%>
	</div>
	<div class="main">
		<div class="product-list">
			<h2>全部商品</h2>			
			<div class="clear"></div>
			<ul class="product clearfix">
				<c:forEach items="${pbProduct.list}" var="p">
					<li>
						<dl>
							<dt><a href="product-view.action?id=${p.id}" target="_self"><img src="pic/${p.fileName }" /></a></dt>
							<dd class="title"><a href="product-view.action?id=${p.id}" target="_self">${p.name }</a></dd>
							<dd class="price">￥${p.price}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pbProduct.pageNo>1}">
	   					<li><a href="product-list.action?pageNo=1&pageSize=${pbProduct.pageSize}&id=${id}&pcid=${pcid}">首页</a></li>
	   					<li><a href="product-list.action?pageNo=${pbProduct.pageNo-1}&pageSize=${pbProduct.pageSize}&id=${id}&pcid=${pcid}">上一页</a></li>
	   					<li>...</li>
	   				</c:if>
					<li class="current">当前页${pb.pageNo}</li>
					<c:if test="${pbProduct.pageNo<pbProduct.countPage }">
						<li>...</li>
	   					<li><a href="product-list.action?pageNo=${pbProduct.pageNo+1}&pageSize=${pbProduct.pageSize }&id=${id}&pcid=${pcid}">下一页</a></li>
	   					<li><a href="product-list.action?pageNo=${pbProduct.countPage}&pageSize=${pbProduct.pageSize }&id=${id}&pcid=${pcid}">尾页</a></li>
	   				</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
