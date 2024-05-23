package br.com.geile.kiosk.service;

import java.util.ArrayList;
import java.util.List;

import br.com.geile.kiosk.dto.CarrinhoRequest;
import br.com.geile.kiosk.model.CarrinhoBean;
import br.com.geile.kiosk.model.CarrinhoProdutoBean;
import br.com.geile.kiosk.model.ProdutoBean;
import br.com.geile.kiosk.repository.CarrinhoProdutoRepository;
import br.com.geile.kiosk.repository.CarrinhoRepository;
import br.com.geile.kiosk.repository.ProdutoRepository;

public class CarrinhoService {

	private CarrinhoRepository carrRepository;
	private ProdutoRepository prodRepository;
	private CarrinhoProdutoRepository caprRepository;
	
	public CarrinhoService(CarrinhoRepository carrRepository, ProdutoRepository prodRepository, CarrinhoProdutoRepository caprRepository) {
		this.carrRepository = carrRepository;
		this.prodRepository = prodRepository;
		this.caprRepository = caprRepository;
	}
	
	public void insertCarrinho(CarrinhoBean carrBean) {
		carrRepository.save(carrBean);
	}
	
	public void insertCarrinhoProduto(CarrinhoBean carrBean, CarrinhoRequest carrRequest) {
		List<CarrinhoProdutoBean> caprList = new ArrayList<CarrinhoProdutoBean>();
		List<ProdutoBean> prodList = prodRepository.findAllById(carrRequest.getProdutos());
		
		for(ProdutoBean prodBean : prodList) {
			CarrinhoProdutoBean caprBean = new CarrinhoProdutoBean();
			caprBean.setCarrinho(carrBean);
			caprBean.setProduto(prodBean);
			
			caprList.add(caprBean);
		}
		caprRepository.saveAll(caprList);
	}
}
