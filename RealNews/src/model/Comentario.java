package model;

import java.io.Serializable;

public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String texto;
	private int noticia_id;
	

	public Comentario() {
	}
	
	public Comentario(String nome, String texto) {
		super();
		this.nome = nome;
		this.texto = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getNoticia_id() {
		return noticia_id;
	}

	public void setNoticia_id(int noticia_id) {
		this.noticia_id = noticia_id;
	}
	
	

}
