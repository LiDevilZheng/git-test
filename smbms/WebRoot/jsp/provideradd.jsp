<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<script type="text/javascript">
	function findByproCode(){
		var proCode=$("#proCode").val();
		if(proCode!=""){
			$.ajax({
				url:"findByproCode.html?proCode="+proCode,
				type:"GET",
				dataType:"json",
				success:function(result){
					if(result=="error"){
						$("#pro_code").html("用户编码已经存在").css("color","red");
					}else{
						$("#pro_code").html("用户编码可以使用").css("color","blue");
					}
				}
			});
		}
	}
</script>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面 >> 供应商添加页面</span>
        </div>
        <div class="providerAdd">
           <form id="providerForm" name="providerForm" method="post" action="addProvider.html" enctype="multipart/form-data">
			<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div class="">
                    <label for="proCode">供应商编码：</label>
                    <input type="text" name="proCode" id="proCode" value="" onblur="findByproCode()"> 
					<!-- 放置提示信息 -->
					<font color="red" id="pro_code"></font>
                </div>
                <div>
                    <label for="proName">供应商名称：</label>
                   <input type="text" name="proName" id="proName" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proContact">联系人：</label>
                    <input type="text" name="proContact" id="proContact" value=""> 
					<font color="red"></font>

                </div>
                <div>
                    <label for="proPhone">联系电话：</label>
                    <input type="text" name="proPhone" id="proPhone" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="proAddress">联系地址：</label>
                    <input type="text" name="proAddress" id="proAddress" value=""> 
                </div>
                <div>
                    <label for="proFax">传真：</label>
                    <input type="text" name="proFax" id="proFax" value=""> 
                </div>
                <div>
                    <label for="proDesc">描述：</label>
                    <input type="text" name="proDesc" id="proDesc" value=""> 
                </div>
                 <div>
    				<label>营业执照：</label>
    				<input type="file" name="pics" >
	        		<font color="red">${file_error }</font>
                </div>
                <div>
    				<label>组织机构代码证：</label>
    				<input type="file" name="pics" >
	        		<font color="red">${file_error}</font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存"/>
					<input type="button" id="back" name="back" value="返回" />
                </div>
            </form>
     </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>

