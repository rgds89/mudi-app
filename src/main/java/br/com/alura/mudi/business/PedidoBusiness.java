package br.com.alura.mudi.business;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoBusiness {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getPedidosAguardandoOfertas() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        return pedidoRepository.findByStatusOrderByIdDesc(StatusPedido.AGUARDANDO, pageRequest);
    }
}
