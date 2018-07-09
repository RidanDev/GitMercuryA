<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="it.mercurya.model.Provincia"%>
<%@ page import="it.mercurya.model.Comune"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>pagina di test</h1>

	<%
		ArrayList<Provincia> a = (ArrayList<Provincia>) session.getAttribute("province");
		out.println("size "+ a.size());
		for (int i = 0; i < a.size(); i++)
		{
			out.println(a.get(i).getNome());
		}
		
		ArrayList<Comune> b = (ArrayList<Comune>) session.getAttribute("comune");
		out.println("size "+ b.size());
		for (int i = 0; i < b.size(); i++)
		{
			out.println(b.get(i).getNome());
		}
	%>

</body>
</html>