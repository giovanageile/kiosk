package br.com.geile.kiosk.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.geile.kiosk.dto.ProdutoRequest;
import br.com.geile.kiosk.dto.ProdutoResponse;
import br.com.geile.kiosk.service.ProdutoService;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

	private ProdutoService prodService;

	public ProdutoController(ProdutoService prodService) {
		this.prodService = prodService;
	}

	@RequestMapping
	public ResponseEntity<List<ProdutoResponse>> getAllProdutos() {
		return ResponseEntity.ok(prodService.getAllProduto());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ProdutoResponse> createProduto(@RequestBody ProdutoRequest produtoRequest) {
		return ResponseEntity.ok(prodService.insertProduto(produtoRequest));
	}
	
	@RequestMapping(value = "/{prodId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProdutoById(@PathVariable Long prodId) {
		prodService.deleteProdutoById(prodId);
		
		return ResponseEntity.ok().build();
		
	}
	
	@RequestMapping(value = "/{prodId}", method = RequestMethod.PUT)
	public ResponseEntity<ProdutoResponse> updateProdutoById(@RequestBody ProdutoRequest prodRequest, @PathVariable Long prodId) {
		return ResponseEntity.ok(prodService.updateProdutoById(prodRequest, prodId));
	}
	
	
	
	
	
	
	
	
	
}