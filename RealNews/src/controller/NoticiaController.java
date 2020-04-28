package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

/**
 * Servlet implementation class noticiacontroller
 */
@WebServlet("/Noticia.do")
public class NoticiaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Noticia noticia;
	NoticiaService ns;
	Comentario comentario;
	ComentarioService cs;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pComando = request.getParameter("comando");
		
		switch (pComando) {
		case "criar":
			cadastraNoticia(request, response);
			break;
		case "edita":
			atualizaNoticia(request, response);
			break;
		case "delete":
			deletaNoticia(request, response);
			break;
		
		}
	}
		
		
	private void cadastraNoticia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String pDescricao = request.getParameter("descricao");
		String pTitulo = request.getParameter("titulo");
		String pTexto = request.getParameter("texto");

		// instanciar o javabean
		if (pDescricao != "" && pTitulo != "" && pTexto != "") {
			noticia = new Noticia();
			noticia.setDescricao(pDescricao);
			noticia.setTitulo(pTitulo);
			noticia.setTexto(pTexto);

			// instanciar o service
			ns = new NoticiaService();
			ns.criar(noticia);
			noticia = ns.carregar(noticia.getId());

			RequestDispatcher view = request.getRequestDispatcher("listaNoticia.jsp");
			view.forward(request, response);
		}

		else {
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>comentario Cadastrada</title></head><body>");
			out.println("Favor verificar os campos, dados incorretos" + "<br>");
			out.println("<a href=" + "Menu.html" + ">Menu</a>");
			out.println("</body></html>");
		}
	}
	
	
	private void atualizaNoticia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");

		
	}
	
	private void deletaNoticia(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		int id = Integer.parseInt(pId);
		cs = new ComentarioService();
		ns = new NoticiaService();
		
		cs.excluirTodas(id);
		ns.excluir(id);
		RequestDispatcher view = request.getRequestDispatcher("deletaNoticia.jsp");
		view.forward(request, response);
	}


}
