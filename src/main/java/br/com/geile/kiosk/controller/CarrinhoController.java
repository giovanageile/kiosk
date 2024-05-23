package br.com.geile.kiosk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.geile.kiosk.dto.CarrinhoRequest;
import br.com.geile.kiosk.dto.CarrinhoResponse;
import br.com.geile.kiosk.model.CarrinhoBean;
import br.com.geile.kiosk.service.CarrinhoService;

@RestController()
@RequestMapping("/api/v1/carrinho")
public class CarrinhoController {

	private CarrinhoService carrService;
	
	public CarrinhoController(CarrinhoService carrService) {
		this.carrService = carrService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CarrinhoResponse> createCarrinho(@RequestBody CarrinhoRequest carrRequest){
		CarrinhoBean carrBean = new CarrinhoBean();
		carrService.insertCarrinho(carrBean);
		
		return ResponseEntity.ok(CarrinhoResponse.convert(carrBean));
	}
}
