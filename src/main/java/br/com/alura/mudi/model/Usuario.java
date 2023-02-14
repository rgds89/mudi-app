package br.com.alura.mudi.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Data
public class Usuario implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    private String username;

    private String password;
    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Pedido> pedidos;
}
