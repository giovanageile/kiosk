package br.com.geile.kiosk.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "carrinhoproduto")
public class CarrinhoProdutoBean {

	@Id
	@Column(name = "capr_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_id")
	private ProdutoBean produto;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carr_id")
	private CarrinhoBean carrinho;
}
