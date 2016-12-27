package br.com.master.escalas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.master.escalas.dao.FuncionarioDAO;
import br.com.master.escalas.model.Funcionario;

@Controller
public class FuncionariosController {

	
	private final FuncionarioDAO dao;
	

	@Autowired
	public FuncionariosController(FuncionarioDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("adicionaFuncionario")
	public String adiciona(@Valid Funcionario funcionario, BindingResult result, @RequestParam(value = "idS") Long idS,
			@RequestParam(value = "ativo") String ativo) {
		
		if(result.hasFieldErrors("nome")) {
			return "funcionario/formulario";
		}		
		funcionario.setIdS(idS);
		funcionario.setSituacao(Integer.parseInt(ativo));
		dao.insert(funcionario);
		return "funcionario/adicionado";
		
		/*if(result.hasErrors()) {
			return "funcionario/formulario";
			}*/
	}
	
	@RequestMapping("listaFuncionarios")
	public String lista(Model model) {
		model.addAttribute("funcionarios", dao.getFuncionarios());
		return "funcionario/lista";
	}
	
	@RequestMapping("novoFuncionario")
	public String form(Model model) {
		model.addAttribute("setores", SetoresController.carSetores());
		model.addAttribute("horarios", HorariosController.carHorarios());
		return "funcionario/formulario";
	}
	

	/*
	 @RequestMapping("addFuncionario") 
	 public ModelAndView adminPage(ModelAndView model) { 
		 SetorDAO setorDao = new SetorDAO();
		 HorarioDAO horarioDao = new HorarioDAO(); 
		 model.addObject("setores", setorDao.getSetores()); 
		 model.addObject("horarios", horarioDao.getHorarios()); 
		 model.setViewName("funcionario/formulario");
		 return model; 
	 }
	 */
	
}
