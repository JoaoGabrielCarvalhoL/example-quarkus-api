package br.com.carv.model.dto;

import java.math.BigDecimal;

public class CadastrarProdutoDTO {
	
	private String nome; 
	
	private BigDecimal valorUnitario;
	
	public CadastrarProdutoDTO() {
		
	}
	
	public CadastrarProdutoDTO(String nome, BigDecimal valorUnitario) {
		this.nome = nome; 
		this.valorUnitario = valorUnitario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
