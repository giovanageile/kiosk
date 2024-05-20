package br.com.geile.kiosk.dto;

import java.math.BigDecimal;
import java.util.List;

import br.com.geile.kiosk.model.ProdutoBean;
import lombok.Data;

@Data
public class ProdutoResponse {
	private Long id;
	private String descricao;
	private BigDecimal valor;

	public static ProdutoResponse convert(ProdutoBean prodBean) {
		ProdutoResponse prodDto = new ProdutoResponse();
		prodDto.setId(prodBean.getId());
		prodDto.setDescricao(prodBean.getDescricao());
		prodDto.setValor(prodBean.getValor());

		return prodDto;
	}
	
	public static List<ProdutoResponse> convert(List<ProdutoBean> prodList) {
		return prodList.stream()
				.map(ProdutoResponse::convert)
				.toList();
	}
}
