<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prova</title>
</head>
<body>

<%

ArrayList<String> s=(ArrayList<String>)session.getAttribute("lista");

for (int i=0; i<s.size() ;i++){
       out.println(s.get(i));  		
}
%>

</body>
</html>