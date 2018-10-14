<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url:"roles",
			type:"GET",
			dataType:"json",
			success:function(result){
				var str="<option value='0'>--请选择--</option>"
				for(var i=0;i<result.length;i++){
					str+="<option value='"+result[i].id+"'>"+result[i].roleName+"</option>";
				}
				$("#userRole").html(str);
			}
		});
	});
</script>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="updateUser.html">
			<input type="hidden" name="method" value="modifyexe">
			<input type="hidden" name="id" value="${user.id }">				
			 <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${user.userName }"> 
					<font color="red"></font>
             </div>
			 <div>
                    <label >用户性别：</label>
                    <select name="gender" id="gender">
								<option value="1" selected="selected">男</option>
					    		<option value="2">女</option>
					 </select>
             </div>
			 <div>
                    <label for="data">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" value='<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>'
					readonly="readonly" onclick="WdatePicker();">
                    <font color="red"></font>
              </div>
			
		       <div>
                    <label for="userphone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${user.phone }"> 
                    <font color="red"></font>
               </div>
                <div>
                    <label for="userAddress">用户地址：</label>
                    <input type="text" name="address" id="address" value="${user.address }">
                </div>
				<div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<select name="userRole" id="userRole">
					</select>
        			<font color="red"></font>
                </div>
			 <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back" value="返回"/>
                </div>
           </form>
        </div>
    </div>
</section>
<%@include file="/jsp/common/foot.jsp" %>

