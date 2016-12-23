package br.com.master.escalas.model;

public class Funcionario {

	private Long    idS;
	private Long    idF;
	private String  nome;
	private String  carteira;
	private Long    idH;
	private int     ativo;
	
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
		return this.idH;
	}

	public void setIdH(Long idH) {
		this.idH = idH;
	}
	
	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

}
