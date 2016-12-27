package br.com.master.escalas.model;

import java.sql.Time;

public class Horario {
	
	private Long idH;
	private Time inicio;
	private Time termino;
	
	public Long getIdH() {
		return idH;
	}
	public void setIdH(Long idH) {
		this.idH = idH;
	}
	public Time getInicio() {
		return inicio;
	}
	public void setInicio(Time inicio) {
		this.inicio = inicio;
	}
	public Time getTermino() {
		return termino;
	}
	public void setTermino(Time termino) {
		this.termino = termino;
	}
	
}
