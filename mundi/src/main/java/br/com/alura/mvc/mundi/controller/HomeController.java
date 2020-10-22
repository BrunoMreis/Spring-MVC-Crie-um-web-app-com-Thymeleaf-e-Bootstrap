package br.com.alura.mvc.mundi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;
import br.com.alura.mvc.mundi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model) {

		List<Pedido> pedidos = pedidoRepository.findAll();
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

	@RequestMapping("/{status}")
	public ModelAndView porStatus(@PathVariable String status) {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Pedido> pedidoStatus = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		modelAndView.addObject("pedidos", pedidoStatus);

		return modelAndView;
	}

}
