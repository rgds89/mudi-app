package br.com.alura.mudi.controllers;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model, Principal principal){
        PageRequest pageRequest = PageRequest.of(0,10);
        List<Pedido> pedidos = pedidoRepository.findByStatusOrderByIdDesc(StatusPedido.ENTREGUE, pageRequest);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
