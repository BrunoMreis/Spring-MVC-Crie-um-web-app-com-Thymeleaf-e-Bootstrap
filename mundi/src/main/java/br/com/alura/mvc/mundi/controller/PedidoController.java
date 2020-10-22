package br.com.alura.mvc.mundi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.alura.mvc.mundi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository PedidoRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido requisicao) {
		return "pedido/formulario";
	}

	@RequestMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "pedido/formulario";
		}
		Pedido pedido = requisicao.toPedido();
		PedidoRepository.save(pedido);
		return "redirect:/home";
	}
	

}
