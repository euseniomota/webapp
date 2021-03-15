package br.com.webapp.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import br.com.webapp.domain.dao.jdbc.ConnectionFactory;
import br.com.webapp.domain.entity.Titulo;

public class TituloDao {

	private static final Connection conexao = ConnectionFactory.getConnection();

	public void cadastrarTitulo(Titulo pTitulo) {

		String sqlInsert = "insert into tbl_titulo(descricao, tipo, dtaVencimento, status, valor) values (?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmInsert = conexao.prepareStatement(sqlInsert);
			stmInsert.setString(1, pTitulo.getDescricao());
			stmInsert.setString(2, pTitulo.getTipo());
			stmInsert.setDate(3, Date.valueOf(pTitulo.getDataVencimento()));
			stmInsert.setString(4, pTitulo.getStatus());
			stmInsert.setDouble(5, pTitulo.getValor());
			stmInsert.execute();
			stmInsert.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void alterarTitulo(Titulo pTitulo) {

		String sqlUpdate = "update tbl_titulo set descricao = ?, tipo = ?, dtaVencimento = ?, status = ?, valor = ? where id = ?";

		try {
			PreparedStatement stmUpdate = conexao.prepareStatement(sqlUpdate);
			stmUpdate.setString(1, pTitulo.getDescricao());
			stmUpdate.setString(2, pTitulo.getTipo());
			stmUpdate.setDate(3, Date.valueOf(pTitulo.getDataVencimento()));
			stmUpdate.setString(4, pTitulo.getStatus());
			stmUpdate.setDouble(5, pTitulo.getValor());
			stmUpdate.setInt(6, pTitulo.getId());
			stmUpdate.execute();
			stmUpdate.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void apagarTitulo(Integer id) {

		String sqlDelete = "delete from tbl_titulo where id = ?";

		try {
			PreparedStatement stmDelete = conexao.prepareStatement(sqlDelete);
			stmDelete.setInt(1, id);
			stmDelete.execute();
			stmDelete.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/*
	 * Realiza a busca de todos os titulos financeiro
	 * 
	 * @return Retorna uma lista de titulos ou pode retornar null caso a lista
	 * esteja vazia
	 */
	public List<Titulo> selecionarTodosTitulos() {

		List<Titulo> listaTitulos = new ArrayList<Titulo>();

		String querySelect = "select * from vw_titulos";
		try {
			PreparedStatement stmSelect = conexao.prepareStatement(querySelect);
			ResultSet retorno = stmSelect.executeQuery();

			while (retorno.next()) {
				Titulo titulo = new Titulo();
				titulo.setId(retorno.getInt("id"));
				titulo.setDescricao(retorno.getString("descricao"));
				titulo.setTipo(retorno.getString("tipo"));
				titulo.setDataVencimento(retorno.getDate("dtaVencimento").toLocalDate());
				titulo.setStatus(retorno.getString("status"));
				titulo.setValor(retorno.getDouble("valor"));

				listaTitulos.add(titulo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (listaTitulos.isEmpty()) {
			return null;
		}
		return listaTitulos;
	}

	public Titulo buscaTitulo(int id) {

		Titulo titulo = null;
		
		String querySelect = "select * from tbl_titulo where id = ?";
		try {
			PreparedStatement stmSelect = conexao.prepareStatement(querySelect);
			stmSelect.setInt(1, id);
			ResultSet retorno = stmSelect.executeQuery();

			while(retorno.next()) {
				titulo = new Titulo();
				titulo.setId(retorno.getInt("id"));
				titulo.setDescricao(retorno.getString("descricao"));
				titulo.setTipo(retorno.getString("tipo"));
				titulo.setDataVencimento(retorno.getDate("dtaVencimento").toLocalDate());
				titulo.setStatus(retorno.getString("status"));
				titulo.setValor(retorno.getDouble("valor"));

				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return titulo;
	}
}
