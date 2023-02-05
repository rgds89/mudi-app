package br.com.alura.mudi.controllers;

import br.com.alura.mudi.dto.ResquisicaoNovoPedido;
import br.com.alura.mudi.models.Pedido;
import br.com.alura.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(ResquisicaoNovoPedido resquisicaoNovoPedido){
        Pedido pedido = resquisicaoNovoPedido.toPedido();
        pedidoRepository.save(pedido);
        return"pedido/formulario";
    }
}
