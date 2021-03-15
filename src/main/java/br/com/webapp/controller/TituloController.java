package br.com.webapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.webapp.domain.dao.TituloDao;
import br.com.webapp.domain.entity.Titulo;

@WebServlet("/")
public class TituloController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TituloDao tituloDao;

	public void init() {
		tituloDao = new TituloDao();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getServletPath();

		switch (acao) {
		case "/novo":
			novoTitulo(request, response);
			break;
		case "/cadastrar":
			cadastrarTitulo(request, response);
			break;
		case "/deletar":
			deletarTitulo(request, response);
			break;
		case "/editar":
			editarTitulo(request, response);
			break;
		case "/alterar":
			alterarTitulo(request, response);
			break;
		default:
			listarTitulos(request, response);
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listarTitulos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Titulo> listaTitulos = tituloDao.selecionarTodosTitulos();
		request.setAttribute("listaTitulos", listaTitulos);
		RequestDispatcher dispacher = request.getRequestDispatcher("index.jsp");
		dispacher.forward(request, response);
	}

	private void novoTitulo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-titulo.jsp");
		dispatcher.forward(request, response);
	}
	
	private void cadastrarTitulo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String descricao = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
		LocalDate data = LocalDate.parse(request.getParameter("dataVencimento"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String status = request.getParameter("status");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		
		Titulo titulo = new Titulo();
		titulo.setDescricao(descricao);
		titulo.setTipo(tipo);
		titulo.setDataVencimento(data);
		titulo.setStatus(status);
		titulo.setValor(valor);
		
		tituloDao.cadastrarTitulo(titulo);
		
		response.sendRedirect("listarTitulos");
		
		
	}
	
	private void editarTitulo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Titulo titulo = tituloDao.buscaTitulo(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrar-titulo.jsp");
		request.setAttribute("titulo", titulo);
		dispatcher.forward(request, response);
		
		response.sendRedirect("listarTitulos");
	}
	
	private void alterarTitulo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String descricao = request.getParameter("descricao");
		String tipo = request.getParameter("tipo");
		LocalDate data = LocalDate.parse(request.getParameter("dataVencimento"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String status = request.getParameter("status");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		
		Titulo titulo = new Titulo();
		titulo.setId(id);
		titulo.setDescricao(descricao);
		titulo.setTipo(tipo);
		titulo.setDataVencimento(data);
		titulo.setStatus(status);
		titulo.setValor(valor);
		
		tituloDao.alterarTitulo(titulo);
		
		response.sendRedirect("listarTitulos");
	}
	
	private void deletarTitulo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		tituloDao.apagarTitulo(id);
		response.sendRedirect("listarTitulos");
	}
}
