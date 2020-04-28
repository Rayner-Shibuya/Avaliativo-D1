package service;

import model.Comentario;

import java.util.List;

import dao.ComentarioDAO;


public class ComentarioService {
	ComentarioDAO dao = new ComentarioDAO();
	
	public int criar(Comentario comentario) {
		return dao.criar(comentario);
	}
	
	public void atualizar(Comentario comentario){
		dao.atualizar(comentario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public void excluirTodas(int noticia_id) {
		dao.excluirTodas(noticia_id);
	}
	
	public Comentario carregar(int id){
		return dao.carregar(id);
	}
	
	public List<Comentario> pegaComentarios(int noticia_id){
		return dao.pegaComentarios(noticia_id);
	}

}
