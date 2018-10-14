<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>订单管理页面 >> 订单添加页面</span>
        </div>
        <div class="providerAdd">
          <form id="billForm" name="billForm" method="post" action="#">
				<input type="hidden" name="method" value="modifysave">
				
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="billCode">订单编码：</label>
                    <input type="text" name="billCode" id="billCode" value="001" readonly="readonly"> 
                </div>
                <div>
                    <label for="productName">商品名称：</label>
                    <input type="text" name="productName" id="productName" value="商品1"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="productUnit">商品单位：</label>
                    <input type="text" name="productUnit" id="productUnit" value="单位1"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="productCount">商品数量：</label>
                    <input type="text" name="productCount" id="productCount" value="11"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="totalPrice">总金额：</label>
                    <input type="text" name="totalPrice" id="totalPrice" value="1000.0"> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="providerId">供应商：</label>
                    
					<select name="providerId" id="providerId">
					  <option value="0">--请选择--</option>
					<option value="0">供应商1</option>
					 <option value="0">供应商2</option>
					 <option value="0">供应商3</option>
					 <option value="0">供应商4</option>
					 <option value="0">供应商5</option>
					
		        	</select>
					<font color="red"></font>
                </div>
                <div>
                    <label >是否付款：</label>
                    
						<input type="radio" name="isPayment" value="1" checked="checked">未付款
						<input type="radio" name="isPayment" value="2" >已付款
					
                </div>
                <div class="providerAddBtn">
                  <input type="button" name="save" id="save" value="保存">
				  <input type="button" id="back" name="back" value="返回" >
              	</div>
            </form>
        </div>

    </div>
</section>

<%@include file="/jsp/common/foot.jsp" %>
