package br.com.alura.mudi.controllers;

import br.com.alura.mudi.dto.ResquisicaoNovoPedido;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.Usuario;
import br.com.alura.mudi.repositories.PedidoRepository;
import br.com.alura.mudi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("formulario")
    public String formulario(ResquisicaoNovoPedido resquisicaoNovoPedido) {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid ResquisicaoNovoPedido resquisicaoNovoPedido, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        } else {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            Usuario usuario = usuarioRepository.findByUserName(userName);
            Pedido pedido = resquisicaoNovoPedido.toPedido();
            pedido.setUsuario(usuario);
            pedidoRepository.save(pedido);
            return "redirect:/home";
        }
    }
}
