package br.com.master.escalas.model;

import java.sql.Date;

public class TrabalhoFolga {
	
	private Long codigo;
	private Date dia;
		
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Date getDia() {
		return dia;
	}
	
	public void setDia(Date dia) {
		this.dia = dia;
	}
}
