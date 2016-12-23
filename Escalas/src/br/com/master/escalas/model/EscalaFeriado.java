package br.com.master.escalas.model;

import java.sql.Date;

public class EscalaFeriado extends Funcionario{

	private Date feriado;
	private Date folga;
	
	public Date getFolga() {
		return folga;
	}

	public void setFolga(Date folga) {
		this.folga = folga;
	}

	public Date getFeriado() {
		return feriado;
	}

	public void setFeriado(Date feriado) {
		this.feriado = feriado;
	}	
	
}
