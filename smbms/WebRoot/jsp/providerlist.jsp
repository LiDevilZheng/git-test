<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
function providerview(id){
	$.ajax({
		url:"provider/"+id,
		type:"GET",
		dataType:"json",
		success:function(result){
			var str="<p>用户编号:"+result.proCode+"</p>";
			str+="<p>用户名称:"+result.proName+"</p>"
			str+="<p>用户电话:"+result.proPhone+"</p>";
			str+="<p>联系人:"+result.proContact+"</p>";
			str+="<p>用户生日:"+result.proAddress+"</p>";
			$("#providerView").html(str);
		}
	});
}
</script>
<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>供应商管理页面</span>
        </div>
        <div class="search">
        	<form method="post" action="providerlist.html">
				<input name="method" value="query" type="hidden">
				<span>供应商编码：</span>
				<input name="proCode" type="text" value="">
				<span>供应商名称：</span>
				<input name="proName" type="text" value="">
				<input value="查 询" type="submit" id="searchbutton">
				<a href="provideradd.jsp">添加供应商</a>
			</form>
        </div>
        <!--供应商操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">供应商编码</th>
                <th width="20%">供应商名称</th>
                <th width="10%">联系人</th>
                <th width="10%">联系电话</th>
                <th width="10%">传真</th>
                <th width="10%">创建时间</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${params.li}" var="pli" varStatus="vs">
            	<tr
            		<c:if test="${vs.index%2==0 }">style="background:#D3D3D3;"</c:if>
            	>
					<td>
					<span>${pli.proCode }</span>
					</td>
					<td>
					<span>${pli.proName }</span>
					</td>
					<td>
					<span>${pli.proContact }</span>
					</td>
					<td>
					<span>${pli.proPhone }</span>
					</td>
					<td>
					<span>${pli.proFax }</span>
					</td>
					<td>
					<span>
						<fmt:formatDate value="${pli.creationDate }" pattern="yyyy-MM-dd HH:mm:ss"/>	
					</span>
					</td>
					<td>
					<span><a class="viewProvider" href="providerview.html?id=${pli.id }" ><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
					<span><a class="viewProvider" href="javascript:providerview(${pli.id });" ><img src="${pageContext.request.contextPath }/images/read.png" alt="rest风格查看" title="rest风格查看"/></a></span>
					<span><a class="modifyProvider" href="providermodify.jsp" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span><a class="deleteProvider" href="#"><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
					</td>
				</tr>
            </c:forEach>
        </table>
        <div class="page-bar">
			<ul class="page-num-ul clearfix">
				<li>共${params.count }条记录&nbsp;&nbsp;${params.pageNo }/${params.countPage }页</li>
					<a href="providerlist.html?pageNo=1&proName=${params.proName}&proCode=${params.proCode}">首页</a>
					<a href="providerlist.html?pageNo=${params.pageNo-1}&proName=${params.proName}&proCode=${params.proCode}">上一页</a>
					<a href="providerlist.html?pageNo=${params.pageNo+1}&proName=${params.proName}&proCode=${params.proCode}">下一页</a>
					<a href="providerlist.html?pageNo=${params.countPage}&proName=${params.proName}&proCode=${params.proCode}">最后一页</a>
				&nbsp;&nbsp;
			</ul>
			<form action="providerlist.html">
				 <span class="page-go-form"><label>跳转至</label>
				     <input type="text" name="PageNo" id="inputPage" class="page-key" />页
				     <input type="hidden" name="proName" value="${params.proName }">
				      <input type="hidden" name="proRole" value="${params.proCode }">
				     <button type="submit" class="page-btn" >GO</button>
				</span>
			</form>
		</div> 
		<div id="providerView"></div>
    </div>
</section>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该供应商吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>

