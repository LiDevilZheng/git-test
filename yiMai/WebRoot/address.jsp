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
<script type="text/javascript">
	function addAddress(){
		var address=$("#addAddr").val();
		if(typeof(address)!="undefined"){
			$.get("addAddress.action","address="+address,function(result){
				if(result=="true"){
					alert("添加地址成功！");
				}else{
					alert("添加地址失败！");
				}
				window.location.href="address.action";
			});
		}
	}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help"><a href="shopping.jsp" class="shopping">购物车${sum }件</a>
	<c:if test="${empty user}">
			<a href="login.jsp">登录</a>
			<a href="register.jsp">注册</a>
		</c:if>
		<c:if test="${not empty user }">
			欢迎登录
			<c:if test="${user.status==1}">
				您是普通用户:${user.id }
				<a href="guest.action">留言</a>
			</c:if>
			<c:if test="${user.status==2}">
				管理员：${user.name }
				<a href="guest.action">留言</a><a href="manage/index.jsp">后台管理</a>
			</c:if>
			<a class="button" href="loginOut.action">注销</a>			
		</c:if></div>
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
<div id="position0" class="wrap">
	您现在的位置：<a href="index.action">易买网</a> &gt; 结账
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<c:forEach items="${pb.list}" var="li">
					<dt>${li.parent.name }</dt>
					<c:forEach items="${li.childs }" var="lc">
						<dd><a href="product-list.action?id=${lc.id}">${lc.name }</a></dd>
					</c:forEach>
				</c:forEach>
			</dl>
		</div>
	</div>
</div>
<div id="news" class="right-main">
		<h1>&nbsp;</h1>
		<div class="content">
            <form action="settleAccounts.action" method="post">
                收货地址:<input name="addr" id="addr" type="button"  value="添加新地址" onclick="addAddress()"/>
                <span id="span"></span> <br />
                <c:forEach items="${arr }" var="a" varStatus="vs">
                	 <input name="address" type="radio" id="address0" value="${a}" <c:if test="${vs.first }">checked="checked"</c:if>/><span>${a}</span><br />
                </c:forEach>	
                <div class="button"> <input type="hidden" name="pid" value="${id}"/> <input type="submit" value="结账" /></div>
            </form>
		</div>
	</div>
<div class="clear"></div>
<div id="position1" class="wrap"></div>
<div class="wrap">
	<div id="shopping"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
