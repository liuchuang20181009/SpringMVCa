<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

     <form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
       <input type="hidden" name="_method" value="PUT">
      <form:hidden path="id"/>
     
     	lastName:<form:input path="lastName"/><br/>
     	email:<form:input path="email"/><br/>
     	gender:<form:radiobuttons path="gender" items="${genders }"/>
     	departName:<form:select path="department.id" items="${departments }"
     	itemLabel="departmentName"  itemValue="id"
     	></form:select>
     	<input type="submit" value="提交">
     
     
     </form:form>
  


</body>
</html>