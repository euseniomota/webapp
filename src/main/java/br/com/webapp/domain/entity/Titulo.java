package br.com.webapp.domain.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Titulo {
	
	public Titulo() {
		
	}	
	
	private Integer id;
	private String descricao;
	private String tipo;
	private LocalDate dataVencimento;
	private String status;
	private Double valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getDataVencimento() {	
		
		/* DateTimeFormatter dataformatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");	 */		
		
		return dataVencimento;
	}
	
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValor() {
		
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Titulo [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", dataVencimento=" + dataVencimento
				+ ", status=" + status + ", valor=" + valor + "]";
	}
}