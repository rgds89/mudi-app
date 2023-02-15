package br.com.alura.mudi.controllers;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("pedido")
    public String home(Model model, Principal principal){
        List<Pedido> pedidos = pedidoRepository.findByUser(principal.getName());
        model.addAttribute("pedidos", pedidos);
        return "usuario/home";
    }

    @GetMapping("pedido/{status}")
    public String status(@PathVariable("status") String status, Model model, Principal principal){
        List<Pedido> pedidosAguardando = pedidoRepository.findByStatusAndUser(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        model.addAttribute("pedidos", pedidosAguardando);
        model.addAttribute("status", status);
        return "usuario/home";
    }

    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    public String onError(){
        return "redirect:usuario/home";
    }
}
