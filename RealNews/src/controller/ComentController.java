package controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import service.ComentarioService;

/**
 * Servlet implementation class ComentController
 */
@WebServlet("/Comentario.do")
public class ComentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String pCom_Texto = request.getParameter("com_texto");
		String pNoticia_id = request.getParameter("noticia_id");
		
		//instanciar o javabean
		Comentario comentario = new Comentario();
		comentario.setNome(pNome);;
		comentario.setTexto(pCom_Texto);
		comentario.setNoticia_id(Integer.parseInt(pNoticia_id));
		
		//instanciar o service
		ComentarioService cs = new ComentarioService();
		cs.criar(comentario);
		
		response.sendRedirect("http://localhost:8080/RealNews/noticia.jsp");

		
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>comentario Cadastrada</title></head><body>");
//		out.println(	"id: "+comentario.getId()+"<br>");
//		out.println(	"Nome: "+comentario.getNome()+"<br>");
//		out.println(	"Comentario: "+comentario.getTexto()+"<br>");
//		out.println(	"Noticia: "+comentario.getNoticia_id()+"<br>");
//	    out.println("</body></html>");
		
	}

}
