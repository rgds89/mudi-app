package br.com.alura.mudi.service;

import br.com.alura.mudi.business.PedidoBusiness;
import br.com.alura.mudi.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoBusiness pedidoBusiness;

    public List<Pedido> getPedidosAguardandoOfertas(){
        return  pedidoBusiness.getPedidosAguardandoOfertas();
    }
}
