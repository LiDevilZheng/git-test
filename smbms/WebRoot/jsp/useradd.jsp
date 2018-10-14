<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<script>
	$(function () {
		$.ajax({
			url:"roles",
			type:"GET",
			dataType:"json",
			success:function(result){
				var str="<option value='0'>--请选择--</option>";
				for(var i=0;i<result.length;i++){
					str+="<option value='"+result[i].id+"'>"+result[i].roleName+"</option>";
				}
				$("#userRole").html(str);
			}
		});
		$("#userForm").submit(function () {
			if (checkUser()&&checkPwd()&&checkRepwd()&&checkMobile()) {
				return true;
			} else {
				$("#userName").val("");
				$("#userPassword").val("");
				$("#ruserPassword").val("");
				$("#phone").val("");
				return false;
			}
		});
	//	$("#user").blur(checkUser);
	//	$("#pwd").blur(checkPwd);
	//	$("#repwd").blur(checkRepwd);
	//	$("#email").blur(checkEmail);
	//	$("#mobile").blur(checkPhone);
	});
	function checkUser() {
		var reg1=/^[a-zA-Z]\w{3,15}$/;
		var u=$("#userName").val();
		if(u==""){
			$("#user_prompt").html("用户名不能为空！");
			return false;
		}
		if(reg1.test(u)==false){
			$("#user_prompt").html("用户名格式不正确！英文字母开始的3-15位");
			return false;
		}
		$("#user_prompt").html("合法的用户名！").css("color","blue");;
		return true;
	}
	var p;
	function checkPwd() {
		var reg2=/^[a-zA-Z][a-zA-Z0-9]{3,9}$/;
		p=$("#userPassword").val();
		if(p==""){
			$("#pwd_prompt").html("密码不能为空！");
			return false;
		}
		if(reg2.test(p)==false){
			$("#pwd_prompt").html("密码格式不正确！");
			return false;
		}
		$("#pwd_prompt").html("密码可以使用！").css("color","blue");
		return true;
	}
	function checkRepwd(){
		var rp=$("#ruserPassword").val();
		if(rp==""){
			$("#repwd_prompt").html("密码不能为空！");
			return false;
		}
		if(rp!=p){
			$("#repwd_prompt").html("两次密码输入不一致！");
			return false;
		}
		$("#repwd_prompt").html("两次密码输入正确！").css("color","blue");
		return true;
	}
	function checkPhone() {
		var regPhone=/^1[0-9]{10}$/;
		var m=$("#phone").val();
		if(m==""){
			$("#phone_prompt").html("手机号不能为空！");
			return false;
		}
		if(regPhone.test(m)==false){
			$("#phone_prompt").html("手机号格式不正确！");
			return false;
		}
		$("#phone_prompt").html("手机号可以使用！").css("color","blue");
		return true;
	}
	function findByUserCode(){
		var userCode=$("#userCode").val();
		if(userCode!=""){
			$.ajax({
				url:"findByUserCode.html?userCode="+userCode,
				type:"GET",
				dataType:"json",
				success:function(result){
					if(result=="error"){
						$("#user_code").html("用户编码已经存在").css("color","red");
					}else{
						$("#user_code").html("用户编码可以使用").css("color","blue");
					}
				}
			});
		}
	}
</script>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
        <div style="color:red;font-size:15px;">${user_error}</div>
            <form id="userForm" name="userForm" method="post" action="addUser.html" enctype="multipart/form-data">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="userCode">用户编码：</label>
                    <input type="text" name="userCode" id="userCode" value="" onblur="findByUserCode()"/> 
					<!-- 放置提示信息 -->
					<font color="red" id="user_code">${error_userCode }</font>
                </div>
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="" onblur="checkUser()"/> 
					<font color="red" id="user_prompt">${error_userName }</font>
                </div>
                <div>
                    <label for="userPassword">用户密码：</label>
                    <input type="password" name="userPassword" id="userPassword" value="" onblur="checkPwd()"/> 
					<font color="red" id="pwd_prompt"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value="" onblur="checkRepwd()"/> 
					<font color="red" id="repwd_prompt"></font>
                </div>
                <div>
                    <label >用户性别：</label>
					<select name="gender" id="gender">
					    <option value="1" selected="selected">男</option>
					    <option value="2">女</option>
					 </select>
                </div>
                <div>
                    <label for="birthday">出生日期：</label>
                    <input type="text" Class="Wdate" id="birthday" name="birthday" 
					readonly="readonly" onclick="WdatePicker();">
					<font color="red"></font>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="" onblur="checkPhone()"> 
					<font color="red" id="phone_prompt">${error_phone }</font>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                   	<input name="address" id="address"  value="">
                </div>
                <div>
                    <label >用户角色：</label>
                    <!-- 列出所有的角色分类 -->
					<select name="userRole" id="userRole">
					</select>
	        		<font color="red"></font>
                </div>
                 <div>
    				<label>身份证照片：</label>
    				<input type="file" name="pics" >
	        		<font color="red">${file_error }</font>
                </div>
                <div>
    				<label>工作照片：</label>
    				<input type="file" name="pics" >
	        		<font color="red">${file_error }</font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>

