<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/jsp/common/head.jsp"%>
<!-- <script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script> -->
<script type="text/javascript">
	$(function(){
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
	});
	function findById(id){
		$.ajax({
			url:"user/"+id,
			type:"GET",
			dataType:"json",
			success:function(result){
				var str="<p>用户编号:"+result.userCode+"</p>";
				str+="<p>用户名称:"+result.userName+"</p>"
				var sex=result.gender==1?"男":"女";
				str+="<p>用户性别:"+sex+"</p>";
				str+="<p>用户生日:"+result.birthday+"</p>";
				$("#userView").html(str);
			}
		});
	}
	function usermodify(id){
		$.ajax({
			url:"user/"+id,
			type:"GET",
			dataType:"json",
			success:function(result){
				var str="<table border='1'><tr><td>用户编号:</td><td><input type='text' name='user_code' value='"+result.userCode+"'></td></tr>";
				str+="<tr><td>用户名称:</td><td><input type='text' name='user_code' value='"+result.userName+"'></td></tr>"
				if(result.gender==1){
					str+="<tr><td>用户性别:</td><td><input type='radio' name='user_code' value='男' checked/>男<input type='radio' name='user_code' value='女' />女</td></tr>"
				}
				if(result.gender==2){
					str+="<tr><td>用户性别:</td><td><input type='radio' name='user_code' value='男'/>男<input type='radio' name='user_code' value='女' checked/>女</td></tr>"
				}
				str+="</table>"
				$("#user_modify").html(str);
			}
		});
	}
</script>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="post" action="userlist.html">
					<input name="method" value="query" class="input-text" type="hidden">
					 <span>用户名：</span>
					 <input name="userName" class="input-text"	type="text" value="${params.userName }">
					 <span>用户角色：</span>
					 <select name="userRole" id="userRole">		
	        		</select>
					 <input type="hidden" name="pageIndex" value="1"/>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="useradd.jsp" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach items="${params.li}" var="u" varStatus="vs">
					<tr
						<c:if test="${vs.index%2==0 }">style="background:#D3D3D3;"</c:if>
					>
						<td>
						<span>${u.id }</span>
						</td>
						<td>
						<span>${u.userName }</span>
						</td>
						<td>
							<span>
								<c:if test="${u.gender==1 }">男</c:if>
								<c:if test="${u.gender==2 }">女</c:if>
							</span>
						</td>
						<td>
						<span>${u.age }</span>
						</td>
						<td>
						<span>${u.phone }</span>
						</td>
						<td>
							<span>${u.userRoleName }</span>
						</td>
						<td>
						<span><a class="viewUser" href="findById.html?id=${u.id}"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
						<span><a class="viewUser" href="javascript:findById(${u.id});"><img src="${pageContext.request.contextPath }/images/read.png" alt="rest风格查看" title="rest风格查看"/></a></span>
						<span><a class="modifyUser" href="usermodify.html?id=${u.id}" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="modifyUser" href="javascript:usermodify(${u.id});"><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="rest风格修改" title="rest风格修改"/></a></span>
						<span><a class="deleteUser" href="#" ><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<%-- <c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import> --%>
          <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${params.count }条记录&nbsp;&nbsp;${params.pageNo }/${params.countPage }页</li>
					<a href="userlist.html?pageNo=1&userName=${params.userName}&userRole=${params.userRole}">首页</a>
					<a href="userlist.html?pageNo=${params.pageNo-1}&userName=${params.userName}&userRole=${params.userRole}">上一页</a>
					<a href="userlist.html?pageNo=${params.pageNo+1}&userName=${params.userName}&userRole=${params.userRole}">下一页</a>
					<a href="userlist.html?pageNo=${params.countPage}&userName=${params.userName}&userRole=${params.userRole}">最后一页</a>
				&nbsp;&nbsp;
			</ul>
			<form action="userlist.html">
				 <span class="page-go-form"><label>跳转至</label>
				     <input type="text" name="PageNo" id="inputPage" class="page-key" />页
				     <input type="hidden" name="userName" value="${params.userName }">
				      <input type="hidden" name="userRole" value="${params.userRole }">
				     <button type="submit" class="page-btn" >GO</button>
				</span>
			</form>
		</div> 
			<div id="userView"></div>
			<div id="user_modify"></div>
        </div>
    </section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>

