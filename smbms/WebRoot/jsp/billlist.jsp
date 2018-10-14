<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"providers",
			type:"GET",
			dataType:"json",
			success:function(result){
				var str="<option value='0'>--请选择--</option>";
				for(var i=0;i<result.length;i++){
					str+="<option value='"+result[i].id+"'>"+result[i].proName+"</option>";
				}
				$("#providerId").html(str);
			}
		});
	});
	function findById(id){
		$.ajax({
			url:"bill/"+id,
			type:"GET",
			dataType:"json",
			success:function(result){
				/* var str="<p>用户编号:"+result.userCode+"</p>";
				str+="<p>用户名称:"+result.userName+"</p>"
				var sex=result.gender==1?"男":"女";
				str+="<p>用户性别:"+sex+"</p>";
				str+="<p>用户生日:"+result.birthday+"</p>";
				$("#userView").html(str); */
			}
		});
	}
</script>
<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>订单管理页面</span>
       </div>
       <div class="search">
       <form method="post" action="billlist.html">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>商品名称：</span>
			<input name="productName" type="text" value="">
			<span>供应商：</span>
			<select name="providerId" id="providerId">				
       		</select>			 
			<span>是否付款：</span>
			<select name="isPayment">
				<option value="0">--请选择--</option>
				<option value="1">未付款</option>
				<option value="2">已付款</option>
       		</select>
			 <input	value="查 询" type="submit" id="searchbutton">
			 <a href="billadd.jsp">添加订单</a>
		</form>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="10%">订单编码</th>
              <th width="20%">商品名称</th>
              <th width="10%">供应商</th>
              <th width="10%">订单金额</th>
              <th width="10%">是否付款</th>
              <th width="10%">创建时间</th>
              <th width="30%">操作</th>
          </tr>
          <c:forEach items="${params.li }" var="b" varStatus="vs">
          		<tr
          			<c:if test="${vs.index%2==0}">style="background:#D3D3D3;"</c:if>
          		>
					<td>
					<span>${b.billCode }</span>
					</td>
					<td>
					<span>${b.productName }</span>
					</td>
					<td>
					<span>${b.proName }</span>
					</td>
					<td>
					<span>${b.totalPrice }</span>
					</td>
					<td>
					<span>
						<c:if test="${b.isPayment==1 }">未付款</c:if>
						<c:if test="${b.isPayment==2 }">已付款</c:if>					
					</span>
					</td>
					<td>
					<span>
					<fmt:formatDate value="${b.creationDate }" pattern="yyyy-MM-dd HH:mm:ss"/>
					</span>
					</td>
					<td>
					<span><a class="viewBill" href="billview.html?id=${b.id}"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="viewBill" href="javascript:findById(${b.id })"><img src="${pageContext.request.contextPath }/images/read.png" alt="rest风格查看" title="rest风格查看"/></a></span>
					<span><a class="modifyBill" href="billmodify.jsp"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="rest风格修改" title="rest风格修改"/></a></span>
					<span><a class="modifyBill" href="billmodify.html?id=${b.id }"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteBill" href="#"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
          </c:forEach>
      </table>
       <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${params.count }条记录&nbsp;&nbsp;${params.pageNo }/${params.countPage }页</li>
					<a href="billlist.html?pageNo=1&productName=${params.productName}&providerId=${params.providerId}&isPayment=${params.isPayment}">首页</a>
					<a href="billlist.html?pageNo=${params.pageNo-1}&productName=${params.productName}&providerId=${params.providerId}&isPayment=${params.isPayment}">上一页</a>
					<a href="billlist.html?pageNo=${params.pageNo+1}&productName=${params.productName}&providerId=${params.providerId}&isPayment=${params.isPayment}">下一页</a>
					<a href="billlist.html?pageNo=${params.countPage}&productName=${params.productName}&providerId=${params.providerId}&isPayment=${params.isPayment}">最后一页</a>
				&nbsp;&nbsp;
			</ul>
			<form action="billlist.html">
				 <span class="page-go-form"><label>跳转至</label>
				     <input type="text" name="PageNo" id="inputPage" class="page-key" />页
				     <input type="hidden" name="productName" value="${params.productName }">
				      <input type="hidden" name="providerId" value="${params.providerId }">
				      <input type="hidden" name="isPayment" value="${params.isPayment}">
				     <button type="submit" class="page-btn">GO</button>
				</span>
			</form>
		</div> 
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该订单吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
