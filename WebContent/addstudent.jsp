<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.student.doa.StudentDoa"%>  
<jsp:useBean id="u" class="com.student.been.Student"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int i=StudentDoa.save(u);  
if(i>0){  
response.sendRedirect("addstudent-success.jsp");  
}else{  
response.sendRedirect("addstudent-error.jsp");  
}  
%>
</body>
</html>