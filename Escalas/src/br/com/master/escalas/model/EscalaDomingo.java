package br.com.master.escalas.model;

import java.sql.Date;
import java.util.ArrayList;

public class EscalaDomingo extends Funcionario {
	
	private int  mes;
	private int  ano;
	private ArrayList<Date> domTra;
	private ArrayList<Date> domFol;
	private ArrayList<Date> diaFol;
	
	
	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public ArrayList<Date> getDomTra() {
		return domTra;
	}

	public void setDomTra(ArrayList<Date> domTra) {
		this.domTra = domTra;
	}
	
	public ArrayList<Date> getDomFol() {
		return domFol;
	}

	public void setDomFol(ArrayList<Date> domFol) {
		this.domFol = domFol;
	}

	public ArrayList<Date> getDiaFol() {
		return diaFol;
	}

	public void setDiaFol(ArrayList<Date> diaFol) {
		this.diaFol = diaFol;
	}
}
