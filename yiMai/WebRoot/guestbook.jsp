<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script>
	function addGuest(){
		var json=$("#guestBook").serializeArray();
		var data=$.param(json);//转成json对象数组
		$.post("addGuest.action",data,function(result){
			if(result==true){
				alert("留言成功！");
			}else{
				alert("留言失败！");
			}
			window.location.href="guest.action";
		});
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
	您现在的位置：<a href="index.action">易买网</a> &gt; 在线留言
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
			<c:forEach items="${pbNews.list}" var="p">
				<dt>${p.parent.name }</dt>
				<c:forEach items="${p.childs }" var="c">
					<dd><a href="product-list.action?id=${c.id}">${c.name }</a></dd>
				</c:forEach>
			</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>
			<c:forEach items="${pb.list }" var="p">
				<li>
					<dl>
						<dt>${p.content}</dt>
						<dd class="author">网友：${p.nickName } <span class="timer"><fmt:formatDate value="${p.createTime }" pattern="yyyy:MM:dd HH:mm:ss"/></span></dd>
						<dd><span style="font-weight:bold;">回复内容:</span>${p.reply}<c:if test="${empty p.reply }">未回复</c:if></dd>
					</dl>
				</li>			
			</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<c:if test="${pb.pageNo>1 }">
	   					<li><a href="guest.action?pageNo=1&pageSize=${pb.pageSize}">首页</a></li>
	   					<li><a href="guest.action?pageNo=${pb.pageNo-1}&pageSize=${pb.pageSize }">上一页</a></li>
	   					<li>...</li>
	   				</c:if>
					<li class="current">当前页${pb.pageNo}</li>
					<c:if test="${pb.pageNo<pb.countPage }">
						<li>...</li>
	   					<li><a href="guest.action?pageNo=${pb.pageNo+1}&pageSize=${pb.pageSize }">下一页</a></li>
	   					<li><a href="guest.action?pageNo=${pb.countPage}&pageSize=${pb.pageSize }">尾页</a></li>
	   				</c:if>
				</ul>
			</div>
			<div id="reply-box">
				<form id="guestBook">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="guestName" readonly="readonly" value="${user.id }"/></td><!-- disabled="disabled"无法获取值 -->
						</tr>						
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea name="guestContent"></textarea><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="button" name="submit" value="提交留言" onclick="addGuest()"/></label></td>
						</tr>
					</table>
				</form>
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
