package br.com.geile.kiosk.dto;

import java.util.List;
import lombok.Data;

@Data
public class CarrinhoRequest {
	private List<Long> produtos;
}
