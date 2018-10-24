<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	
$(function(){
	
	$(".delbtn").click(function(){
		var action=$(this).attr("href");
		$("#delForm").attr("action",action).submit();
		return false;
	})
	
})


</script>

</head>
<body>
  <%--  ${requestScope.employees } --%>
  <c:if test="${empty requestScope.employees }">
  	sorry,IT`S  nothing~~
  
  </c:if>
   <c:if test="${!empty requestScope.employees }">
  
  <center>
  	<table border="1" cellpadding="1" cellspacing="1">
  		<tr>
  			<td>id</td>
  			<td>lastName</td>
  			<td>email</td>
  			<td>gender</td>
  			<td>department</td>
  			<td colspan="2">操作</td>
  		</tr>
  		<c:forEach items="${ requestScope.employees }" var="v">
  		<tr>
  			<td>${v.id}</td>
  			<td>${v.lastName }</td>
  			<td>${v.email }</td>
  			<td>${v.gender==0?"男":"女" }</td>
  			<td>${v.department.departmentName }</td>
  			<td>
  				<a href="${pageContext.request.contextPath }/emp/${v.id}">修改</a>
  			</td>
  			<td>
  				<a class="delbtn" href="${pageContext.request.contextPath }/emp/${v.id}">删除</a>
  			</td>
  		</tr>
  		
  		
  		</c:forEach>
  	
  	
  	</table>
      
  
  </center>

     
  
  
  
  
</c:if>
 <a href="${pageContext.request.contextPath }/emp">addEmployee</a>
<form id="delForm" action="" method="post">
       <input type="hidden" name="_method" value="DELETE">
     </form>
</body>
</html>