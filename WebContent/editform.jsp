<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.student.doa.StudentDoa,com.student.been.Student"%>  
  
<%  
String id=request.getParameter("id");  
Student u=StudentDoa.getRecordById(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  
<form action="editstudent.jsp" method="post">  
<input type="hidden" name="id" value="<%=u.getId() %>"/>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= u.getName()%>"/></td></tr> 
<tr><td>Address:</td><td>  
<input type="text" name="address" value="<%= u.getAddress()%>"/></td></tr>   
<tr><td>Sex:</td>
<td>
<%if(u.getSex().equalsIgnoreCase("male")) { %>
    <input type="radio" name="sex" value="male" checked/>Male 
    <input type="radio" name="sex" value="female"/>Female 
<% } else if(u.getSex().equalsIgnoreCase("female")) {%>
    <input type="radio" name="sex" value="male" />Male 
    <input type="radio" name="sex" value="female" checked/>Female 
<% } %>
</td></tr> 
  
<tr><td>Phno:</td><td>  
<input type="text" name="phno" value="<%= u.getPhno()%>"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html> 