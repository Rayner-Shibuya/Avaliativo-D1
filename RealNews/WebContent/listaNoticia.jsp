<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="service.NoticiaService"%>
<%@page import="model.Noticia"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente</title>
</head>
<body>

<h3>Lista de noticias</h3>

		<div>
			<%
				
			Noticia noticia = new Noticia();
			NoticiaService ns = new NoticiaService();
			String conteudo = "";
      		int noticia_ID = noticia.getId();
			List<Noticia> lista = ns.pegaNoticias();
			Iterator<Noticia> lista_noticia = lista.iterator();

			while (lista_noticia.hasNext()) {
				noticia = lista_noticia.next();
			
			%>
			<p><%=noticia.getTitulo()%>
			<a href="noticia.jsp?id=<%=noticia.getId()%>">Open</a>
			<a href="editaNoticia.jsp?id=<c:out value=<%=noticia_ID%>/>">Edit</a>
			<a href="cadastraNoticia?id=<c:out value=<%=noticia_ID%>/>">Delete</a>
			</p>
			<%}%>
</div>

<br>
<a href="Menu.html">Menu</a>


</body>
</html>