package test;


import static org.junit.Assert.assertEquals;
import model.Noticia;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.NoticiaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NoticiaTest {
	Noticia noticia, copia;
	NoticiaService noticiaService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		noticia = new Noticia();
		noticia.setId(id);
		noticia.setTitulo("Titulo teste");
		noticia.setDescricao("Descricao teste");
		noticia.setTexto("texto teste");;
		copia = new Noticia();
		copia.setId(id);
		copia.setTitulo("Titulo teste");
		copia.setDescricao("Descricao teste");
		copia.setTexto("texto teste");
		noticiaService = new NoticiaService();
		System.out.println(noticia);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Noticia fixture = new Noticia();
		fixture.setId(1);
		fixture.setTitulo("Titulo teste");
		fixture.setDescricao("Descricao teste");
		fixture.setTexto("texto teste");
		NoticiaService novoService = new NoticiaService();
		Noticia novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = noticiaService.criar(noticia);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", noticia, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		noticia.setDescricao("Descricao teste 2");
		copia.setDescricao("Descricao teste 2");		
		noticiaService.atualizar(noticia);
		noticia = noticiaService.carregar(noticia.getId());
		assertEquals("testa atualizacao", noticia, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setTitulo(null);
		copia.setDescricao(null);
		copia.setTexto(null);
		noticiaService.excluir(id);
		noticia = noticiaService.carregar(id);
		assertEquals("testa exclusao", noticia, copia);
	}
}