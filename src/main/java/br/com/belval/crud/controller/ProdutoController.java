package br.com.belval.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.belval.crud.model.Produto;

@Controller
public class ProdutoController {
	
	private static List<Produto> lista = new ArrayList<>();
	private static int proxid = 1;
	@GetMapping("/produto/novo")
	public String novo() {
		return "novo-produto";
	}
		/*vivitest*/
	@PostMapping("/produto/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView modelAndView = new ModelAndView("novo-produto-criado");
		produto.setId(proxid++);
		
		lista.add(produto);
		modelAndView.addObject("novoProduto", produto);
		return modelAndView;
	}
		@GetMapping ("/produto/list")
		public ModelAndView list() {
			ModelAndView modelAndView = new ModelAndView("lista-produtos");
			modelAndView.addObject("produtos", lista);
			return modelAndView;
		}
}