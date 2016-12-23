package br.com.master.escalas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.master.escalas.dao.FuncionarioDAO;
import br.com.master.escalas.model.Funcionario;

@Controller
public class FuncionariosController {
	
	@RequestMapping("novoFuncionario")
	public String form() {
		return "funcionario/formulario";
	}
	
	@RequestMapping("adicionaFuncionario")
	public String adiciona(Funcionario funcionario) {
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.insert(funcionario);
		System.out.println("Passei no Controller");
		return "funcionario/adicionado";
	}
}
