<%@page import="java.util.Iterator"%>
<%@page import="service.ComentarioService"%>
<%@page import="model.Comentario"%>
<%@page import="java.util.List"%>
<%@page import="service.NoticiaService"%>
<%@page import="model.Noticia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Real News</title>
<style type="text/css">
.container {
	max-width: 1200px;
	margin: 20px auto;
	position: relative;
}

.news h1 {
	font-size: 30px;
	font-family: arial;
	color: #3b2982;
	border-bottom: 1px solid #929292;
	padding-bottom: 15px;
}

.news h2 {
	font-size: 20px;
}

.comentarios {
	width: 50%;
	margin: 20px 0;
}

.comentarios input {
	width: 100%;
	font-size: 14px;
	margin-bottom: 13px;
	border: 1px solid #929292;
	border-radius: 5px;
	padding: 5px;
}

textarea {
	width: 100%;
	height: 130px;
	padding: 5px 5px;
	box-sizing: border-box;
	border: 1px solid #929292;
	border-radius: 5px;
	resize: none;
	font-size: 14px;
}

.comentarios label {
	font: bold 15px Arial, sans-serif;
	padding-bottom: 3px;
	color: #3b2982;
	display: block;
}

.coments {
	padding-left: 20px;
	border-bottom: 1px solid #929292;
}
</style>

</head>
<body>
	<div class="container">
		<div class="news">
			<%
				Noticia noticia = new Noticia();
				NoticiaService ns = new NoticiaService();
				int id = Integer.parseInt(request.getParameter("id"));
				noticia = ns.carregar(id);
				String titulo = noticia.getTitulo();
      			out.println(request.getParameter("id"));
			%>
			<h1><%=titulo%></h1>

		</div>

		<div class="news">
			<%
				String descricao = noticia.getDescricao();
			%>
			<h2><%=descricao%></h2>
		</div>

		<div class="noticia">
			<p><%=noticia.getTexto()%></p>
		</div>

		<div class="news">
			<h2>Comentários</h2>
		</div>

		<div class="coments">
			<%
				String conteudo = "";
				int noticia_ID = noticia.getId();
				Comentario comentario = new Comentario();
				ComentarioService cs = new ComentarioService();
				List<Comentario> lista = cs.pegaComentarios(noticia.getId());
				Iterator<Comentario> lista_noticia = lista.iterator();

				while (lista_noticia.hasNext()) {
					comentario = lista_noticia.next();
			%>
			<p><%=comentario.getNome()%></p>
			<p><%=comentario.getTexto()%></p>

			<%}%>

		</div>



		<div class="comentarios">
			<form action="Comentario.do" method="get">
				<label for="nome">Nome :</label> 
				<input type="text" name="nome"></input>
				<label for="com_texto"> Comentários:</label>
				<textarea name="com_texto"> </textarea>
				<input name="noticia_id" value=<%=noticia_ID%>>
				<input type="submit">
			</form>
			
			<a href="Menu.html">Menu</a>
			
		</div>
	</div>
</body>
</html>