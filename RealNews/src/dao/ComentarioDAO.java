package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comentario;

public class ComentarioDAO {
	public int criar(Comentario comentario) {
		String sqlInsert = "INSERT INTO comentario(nome, texto, fk_noticia_id) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTexto());
			stm.setInt(3, comentario.getNoticia_id());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					comentario.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comentario.getId();
	}

	public void atualizar(Comentario comentario) {
		String sqlUpdate = "UPDATE comentario SET nome=?, texto=?, fk_noticia_id WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, comentario.getNome());
			stm.setString(2, comentario.getTexto());
			stm.setInt(3, comentario.getNoticia_id());
			stm.setInt(4, comentario.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluirTodas(int id) {
		String sqlDelete = "DELETE FROM comentario WHERE fk_noticia_id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(int id) {
		String sqlDelete = "DELETE FROM comentario WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Comentario carregar(int id) {
		Comentario comentario = new Comentario();
		comentario.setId(id);
		String sqlSelect = "SELECT nome, texto, fk_noticia_id FROM comentario WHERE comentario.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, comentario.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					comentario.setNome(rs.getString("nome"));
					comentario.setTexto(rs.getString("texto"));
					comentario.setNoticia_id(rs.getInt("fk_noticia_id"));
				} else {
					comentario.setId(-1);
					comentario.setNome(null);
					comentario.setTexto(null);
					comentario.setNoticia_id(0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return comentario;
	}

	public List<Comentario> pegaComentarios(int noticia_id) {
		String sqlLista = "SELECT * FROM comentario where fk_noticia_id = ?";
		Comentario coment;
		List<Comentario> lista = new ArrayList<>();
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlLista);) {
			stm.setInt(1, noticia_id);

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					coment = new Comentario();
					coment.setNome(rs.getString(2));
					coment.setTexto(rs.getString(3));
					lista.add(coment);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;

	}

}
