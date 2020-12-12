package br.com.alura.mvc.mundi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mundi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.User;
import br.com.alura.mvc.mundi.repository.PedidoRepository;
import br.com.alura.mvc.mundi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private UserRepository userRepository;

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
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		Pedido pedido = requisicao.toPedido();
		pedido.setUser(user);
		PedidoRepository.save(pedido);
		return "redirect:/home";
	}
	

}
