<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<!-- <script type="text/javascript" src="scripts/function.js"></script> -->
<script type="text/javascript">
		function changeNum(op,id){
			var num=$("#number_id_"+id).val();
			//var total=$("#total_price").val();
			//$("#total_price").html(total.toFixed(2));
			if(op=="+"){
				num++;
			}else if(op=="-"){
				if(num>1){
					num--;
				}else{
					alert("数量不能小于1");
				}
			}
			$("#number_id_"+id).val(num);
			window.location.href="updateNum.action?id="+id+"&num="+num;
		}
	</script>
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
	您现在的位置：<a href="index.action">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	
	<c:if test="${empty  cart}">
		<h3>您还没有加入商品！请先去<a href="index.action">购物</a></h3>
	</c:if>
	<c:if test="${not empty cart }">
	<div id="shopping">
		<form action="address.action">
			<table>
				<tr>
					<th>商品名称</th>
					<th>商品价格</th>
				 	<th>购买数量</th>
				 	<th>小计</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${cart.lines}" var="line">
					<tr id="product_id_0">
						<td class="thumb"><img src="pic/${line.product.fileName}" /><a href="product-view.action?id=${line.product.id }">${line.product.name}</a></td>
						<td class="price" id="price_id_0">
							<span>￥${line.product.price}</span>
							<input type="hidden" value="99" />
						</td>
						<td class="number">
	                        <span name="del" onclick="changeNum('-',${line.product.id})">-</span>
	                        <input id="number_id_${line.product.id}" type="text" name="number" value="${line.num}" onblur="changeNum(${line.product.id})"/>
	                        <span name="add" onclick="changeNum('+',${line.product.id})">+</span>
						</td>
						<td class="price" id="total_price">
							￥${line.sum}
						</td>
						<td class="delete"><a href="delCart.action?id=${line.product.id}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
            <div class="total"><span id="total">总计：￥${cart.total }</span></div>
			<div class="button"><input type="submit" value="" /></div>
		</form>
		<a href="clear.action">清空购物车</a>
		</div>		
	</c:if>	
		
	</div>
	
<div id="footer">
	Copyright &copy; 2013 北大青鸟 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
