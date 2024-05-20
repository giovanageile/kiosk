package br.com.geile.kiosk.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "produto")
public class ProdutoBean {

	@Id
	@Column(name = "prod_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "prod_descricao", length = 255)
	private String descricao;
	
	@Column(name = "prod_valor")
	private BigDecimal valor;
	
}
