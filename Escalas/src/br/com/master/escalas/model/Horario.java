package br.com.master.escalas.model;

import java.sql.Time;

public class Horario {
	
	private Long idH;
	private Time horaIni;
	private Time horaFin;
	
	public Long getIdH() {
		return idH;
	}
	public void setIdH(Long idH) {
		this.idH = idH;
	}
	public Time getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(Time horaIni) {
		this.horaIni = horaIni;
	}
	public Time getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}
	
}
