package br.com.geile.kiosk.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProdutoRequest {
	private String descricao;
	private BigDecimal valor;
}
