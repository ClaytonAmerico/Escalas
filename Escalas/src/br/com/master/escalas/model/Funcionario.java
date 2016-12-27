package br.com.master.escalas.model;

import javax.validation.constraints.Size;

import com.sun.istack.internal.NotNull;

public class Funcionario {

	@NotNull
	private Long    idS;
	
	@NotNull
	private Long    idF;
	
	@NotNull//(message="{tarefa.descricao.vazia}")
	@Size(min=5)
	private String  nome;
	
	@NotNull
	private String  carteira;
	
	@NotNull
	private Long    idH;
	
	@NotNull 
	private int     situacao;
	
	public Long getIdS() {
		return this.idS;
	}

	public void setIdS(Long idS) {
		this.idS = idS;
	}
	
	public Long getIdF() {
		return idF;
	}

	public void setIdF(Long id) {
		this.idF = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	
	public Long getIdH() {
		return idH;
	}

	public void setIdH(Long idH) {
		this.idH = idH;
	}
	
	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int ativo) {
		this.situacao = ativo;
	}
}
