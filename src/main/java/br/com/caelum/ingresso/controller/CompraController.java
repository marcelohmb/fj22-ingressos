package br.com.caelum.ingresso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Carrinho;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.form.CarrinhoForm;

@Controller
public class CompraController {

	@Autowired
	private SessaoDao sessaDao;
	
	@Autowired
	private LugarDao lugarDao;
	
	@Autowired
	private Carrinho carrinho;
	
	
	@PostMapping("/compra/ingressos")
	public ModelAndView enviarParaPagamento(CarrinhoForm carrinhoForm){
		ModelAndView modelAndView = new ModelAndView("redirect:/compra");
		System.out.println(carrinhoForm.getIngressos());
		System.out.println(carrinhoForm.getIngressos().get(0).getSessao());
		Sessao objeto = carrinhoForm.getIngressos().get(0).getSessao();
		System.out.println(objeto);
		System.out.println(objeto.getId());
		System.out.println(objeto.getSala());
		objeto.getPreco();
		System.out.println(carrinhoForm.getIngressos().get(0).getSessao().getPreco());
		carrinhoForm.toIngressos(sessaDao, lugarDao).forEach(carrinho::add);
		
		return modelAndView;
	}
}
