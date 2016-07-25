package br.com.bebelin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.bebelin.models.Cliente;
import br.com.bebelin.repositories.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@RequestMapping("/cadastrar")
	public ModelAndView form(Cliente cliente){
		return new ModelAndView("cliente/form");
	}
	
	@RequestMapping(value="/salvar", method=RequestMethod.POST)
	public ModelAndView salvar(Cliente cliente, RedirectAttributes redirectAttributes){
		clienteRepository.save(cliente);
		redirectAttributes.addFlashAttribute("status", "Cliente salvo com sucesso!");
		return new ModelAndView("redirect:/cliente/cadastrar");
	}
	
	@RequestMapping("/lista")
	public ModelAndView lista(){
		ModelAndView view = new ModelAndView("cliente/lista");
		view.addObject("clientes", clienteRepository.findAll());
		return view;
	}
}
