package br.com.alura.mudi.dto;

import br.com.alura.mudi.models.Pedido;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ResquisicaoNovoPedido {
    @NotBlank
    private String nameProduct;
    @NotBlank
    private String urlProduct;
    @NotBlank
    private String urlImgProduct;
    private String descriptionProduct;

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setName(this.nameProduct);
        pedido.setDescription(this.descriptionProduct);
        pedido.setUrlProduct(this.urlProduct);
        pedido.setUrlImg(this.urlImgProduct);
        return pedido;
    }
}
