<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<div class="right">
     <div class="location">
         <strong>你现在所在的位置是:</strong>
         <span>订单管理页面 >> 信息查看</span>
     </div>
     <div class="providerView">
         <p><strong>订单编号：</strong><span>001</span></p>
         <p><strong>商品名称：</strong><span>商品1</span></p>
         <p><strong>商品单位：</strong><span>单位1</span></p>
         <p><strong>商品数量：</strong><span>100</span></p>
         <p><strong>总金额：</strong><span>1000.0</span></p>
         <p><strong>供应商：</strong><span>供应商1</span></p>
         <p><strong>是否付款：</strong>
         	<span>
         		
				已付款
			</span>
		</p>
		<div class="providerAddBtn">
         	<input type="button" id="back" name="back" value="返回" >
        </div>
     </div>
 </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
