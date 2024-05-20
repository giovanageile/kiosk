package br.com.geile.kiosk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.geile.kiosk.dto.ProdutoRequest;
import br.com.geile.kiosk.dto.ProdutoResponse;
import br.com.geile.kiosk.model.ProdutoBean;
import br.com.geile.kiosk.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository prodRepository;
	
	public ProdutoService(ProdutoRepository prodRepository) {
		this.prodRepository = prodRepository;
	}
	
	@Transactional(readOnly = true)
	public ProdutoBean getProdutoById(Long id) {
		return prodRepository.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public List<ProdutoResponse> getAllProduto() {
		return ProdutoResponse.convert(prodRepository.findAll());
	}

	@Transactional(readOnly = false)
	public ProdutoResponse insertProduto(ProdutoRequest prodRequest) {
		ProdutoBean prodBean = new ProdutoBean();
		prodBean.setDescricao(prodRequest.getDescricao());
		prodBean.setValor(prodRequest.getValor());
		
		prodRepository.save(prodBean);
		
		return ProdutoResponse.convert(prodBean);
	}

	@Transactional(readOnly = false)
	public void deleteProdutoById(Long prodId) {
		prodRepository.deleteById(prodId);
	}

	public ProdutoResponse updateProdutoById(ProdutoRequest prodRequest, Long prodId) {
		ProdutoBean prodBean = prodRepository.findById(prodId).orElse(null);
		
		prodBean.setDescricao(prodRequest.getDescricao());
		prodBean.setValor(prodRequest.getValor());

		prodRepository.save(prodBean);
		
		return ProdutoResponse.convert(prodBean);
	}
}
