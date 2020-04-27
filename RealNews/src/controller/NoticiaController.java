package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

/**
 * Servlet implementation class noticiacontroller
 */
@WebServlet("/Noticia.do")
public class NoticiaController extends HttpServlet {
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
		String pDescricao = request.getParameter("descricao");
		String pTitulo = request.getParameter("titulo");
		String pTexto = request.getParameter("texto");
		
		//instanciar o javabean
		if (pDescricao != "" && pTitulo != "" && pTexto != "") {
		Noticia noticia = new Noticia();
		noticia.setDescricao(pDescricao);;
		noticia.setTitulo(pTitulo);
		noticia.setTexto(pTexto);
		
		//instanciar o service
		NoticiaService cs = new NoticiaService();
		cs.criar(noticia);
		noticia = cs.carregar(noticia.getId());
		
		RequestDispatcher view =
		request.getRequestDispatcher("listaNoticia.jsp");
		view.forward(request, response);
		}
		
		else {
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>comentario Cadastrada</title></head><body>");
			out.println(	"Favor verificar os campos, dados incorretos" + "<br>");
			out.println("<a href=" + "Menu.html" + ">Menu</a>");
		    out.println("</body></html>");
		}
		
	}

}
