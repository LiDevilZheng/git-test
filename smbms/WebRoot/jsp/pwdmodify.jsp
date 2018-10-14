<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<script type="text/javascript">
	$("#userForm").submit(function(){
		if(checkPwd()&&newPwd()&&newRepwd()){
			return true;
		}else{
			$("#oldpassword").val("");
			$("#newpassword").val("");
			$("#rnewpassword").val("");
			return false;
		}
	});
	function checkPwd(){
		var oldPwd=$("#oldpassword").val();
		if(oldPwd!=""){
			$.ajax({
				url:"checkPwd.html?oldPwd="+oldPwd,
				type:"GET",
				dataType:"json",
				success:function(result){
					if(result=="success"){
						$("#oldPwd").html("密码正确").css("color","green");
						return true;
					}else{
						$("#oldPwd").html("您的密码不正确！").css("color","red");
						return false;
					}
				}
			});
		}else{
			alert("请输入您的密码！");
		}	
	}
	var p;
	function newPwd() {
		var reg2=/^[a-zA-Z][a-zA-Z0-9]{3,9}$/;
		p=$("#newpassword").val();
		if(p==""){
			$("#newPwd").html("密码不能为空！");
			return false;
		}
		if(reg2.test(p)==false){
			$("#newPwd").html("密码格式不正确！");
			return false;
		}
		$("#newPwd").html("密码可以使用！").css("color","blue");
		return true;
	}
	function newRePwd(){
		var rp=$("#rnewpassword").val();
		if(rp==""){
			$("#newRePwd").html("密码不能为空！");
			return false;
		}
		if(rp!=p){
			$("#newRePwd").html("两次密码输入不一致！");
			return false;
		}
		$("#newRePwd").html("两次密码输入正确！").css("color","blue");
		return true;
	}
</script>
<div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>密码修改页面</span>
            </div>
            <div class="providerAdd">
                <form id="userForm" name="userForm" method="post" action="updatePassword.html">
                    <input type="hidden" name="method" value="savepwd">
                    <!--div的class 为error是验证错误，ok是验证成功-->
                    <div class="info">${meg}</div>
                    <div class="">
                        <label for="oldPassword">旧密码：</label>
                        <input type="password" name="oldpassword" id="oldpassword" value="" onblur="checkPwd()"/> 
						<font color="red" id="oldPwd"></font>
                    </div>
                    <div>
                        <label for="newPassword">新密码：</label>
                        <input type="password" name="newpassword" id="newpassword" value="" onblur="newPwd()"> 
						<font color="red" id="newPwd"></font>
                    </div>
                    <div>
                        <label for="reNewPassword">确认新密码：</label>
                        <input type="password" name="rnewpassword" id="rnewpassword" value="" onblur="newRePwd()"> 
						<font color="red" id="newRePwd"></font>
                    </div>
                    <div class="providerAddBtn">
                        <!--<a href="#">保存</a>-->
                        <input type="submit" name="save" id="save" value="保存" class="input-button">
                    </div>
                </form>
            </div>
        </div>
    </section>
<%@include file="/jsp/common/foot.jsp" %>
