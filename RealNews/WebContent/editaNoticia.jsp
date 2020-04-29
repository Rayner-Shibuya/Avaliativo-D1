<%@page import="model.Noticia"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Real News</title>
<style type="text/css">
.container{
	max-width:1200px;
	margin:20px auto;
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
.comentarios{
	width:50%;
	margin:20px 0;
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

</style>

</head>
<body>

<div class="container">
	<div class="news">
		<h1>Edita Noticia</h1>

	</div>
	<%Noticia noticia= (Noticia)request.getAttribute("noticia"); %>
	<%=noticia.getTexto() %>
	
	<div class="comentarios">
		<form action="Noticia.do" method="get">
		
			<input type="hidden" name="comando" value="atualiza">
			<input type="hidden" name="id" value=<%=noticia.getId() %>>
			
			<label for="titulo"> Titulo da noticia:</label> 
			<input type="text" name="titulo" value=<%=noticia.getTitulo() %> ></input>
			
			<label for="descricao"> Descrição da noticia:</label> 
			<input type="text" name="descricao" value=<%=noticia.getDescricao() %>></input>
			
			<label for="texto"> Texto da noticia:</label>
			<textarea name="texto"><%=noticia.getTexto() %>
			</textarea>
			
			<input type="submit">
		</form>
	</div>
	
	<a href="Menu.html">Menu</a>
</div>
</body>
</html>