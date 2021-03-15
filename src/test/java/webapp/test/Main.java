package webapp.test;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.webapp.domain.dao.TituloDao;
import br.com.webapp.domain.dao.jdbc.ConnectionFactory;
import br.com.webapp.domain.entity.Titulo;

public class Main {

	public static void main(String[] args) {
		cadastrarTitulo();

	}
	
	private static void testConexao() {
		Connection con = ConnectionFactory.getConnection();
		
	}
	
	private static void listaTodosTitulos() {
		TituloDao t = new TituloDao();
		System.out.println(t.selecionarTodosTitulos());
	}
	
	private static void cadastrarTitulo() {
		LocalDate data = LocalDate.parse("2019-02-03", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Double valor = 10D;
		
		Titulo t = new Titulo();
		t.setDescricao("teste01");
		t.setTipo("D");
		t.setDataVencimento(data);
		t.setStatus("A");
		t.setValor(valor);
		
		TituloDao tdao = new TituloDao();
		tdao.cadastrarTitulo(t);
		
	}

}
