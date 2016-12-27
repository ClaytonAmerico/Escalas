package br.com.master.escalas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.master.escalas.dao.SetorDAO;
import br.com.master.escalas.model.Setor;

@Controller
public class SetoresController {
	
	private static SetorDAO dao;
	
	@Autowired
	public SetoresController(SetorDAO dao) {
		SetoresController.dao = dao;
	}
	
	@RequestMapping("adicionaSetor")
	public String adiciona(Setor setor) {
		dao.insert(setor);
		return "setor/adicionado";
	}
	
	@RequestMapping("listaSetores")
	public String lista(Model model) {
		model.addAttribute("setores", dao.getSetores());
		return "setor/lista";
	}
	
	public static List<Setor> carSetores() {
		List<Setor> setor = new ArrayList<Setor>();
		setor = dao.getSetores();
		return setor;
	}

}
