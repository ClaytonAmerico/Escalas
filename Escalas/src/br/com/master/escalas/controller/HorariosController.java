package br.com.master.escalas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.master.escalas.dao.HorarioDAO;
import br.com.master.escalas.model.Horario;

@Controller
public class HorariosController {
	
	private static HorarioDAO dao;
	
	@Autowired
	public HorariosController(HorarioDAO dao) {
		HorariosController.dao = dao;
	}
	
	public String adiciona(Horario horario) {
		
		return "";
	}
	
	public static List<Horario> carHorarios() {
		List<Horario> horario = new ArrayList<Horario>();
		horario = dao.getHorarios();
		return horario;
	}

}
