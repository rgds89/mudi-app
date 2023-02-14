package br.com.alura.mudi.repositories;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p JOIN p.usuario u WHERE u.username = :usuario AND p.status = :status")
    List<Pedido> findByStatusAndUser(@Param("status") StatusPedido status, @Param("usuario") String usuario);

    @Query("SELECT p FROM Pedido p JOIN p.usuario u WHERE u.username = :usuario")
    List<Pedido> findByUser(@Param("usuario") String usuario);

    List<Pedido> findByStatusOrderByDeliveryDateDesc(StatusPedido entregue);
}
