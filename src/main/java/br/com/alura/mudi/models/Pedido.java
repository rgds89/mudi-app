package br.com.alura.mudi.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="pedidos")
@NoArgsConstructor
@Data
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate deliveryDate;
    private BigDecimal value;
    private String urlProduct;
    private String urlImg;
    private String description;
}
