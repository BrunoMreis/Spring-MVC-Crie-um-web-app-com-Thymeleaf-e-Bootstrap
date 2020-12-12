package br.com.alura.mvc.mundi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("pedido")
	public String home(Model model, Principal principal) {

		List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName() + "");
		model.addAttribute("pedidos", pedidos);

		return "/usuario/home";
	}

	@RequestMapping("pedido/{status}")
	public ModelAndView porStatus(@PathVariable String status, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("/usuario/home");
		List<Pedido> pedidoStatus = pedidoRepository
				.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		modelAndView.addObject("pedidos", pedidoStatus);

		return modelAndView;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
}
