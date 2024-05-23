package br.com.geile.kiosk.dto;

import java.util.List;
import br.com.geile.kiosk.model.CarrinhoBean;
import lombok.Data;

@Data
public class CarrinhoResponse {
	private Long id;
	
	public static CarrinhoResponse convert(CarrinhoBean carrBean) {
		CarrinhoResponse carrDto = new CarrinhoResponse();
		carrDto.setId(carrBean.getId());
		
		return carrDto;
	}
	
	public static List<CarrinhoResponse> convert(List<CarrinhoBean> carrList) {
		return carrList.stream()
			   .map(CarrinhoResponse::convert)
			   .toList();
	}
	
	
	
	
	
	
	
	
	
	
}
