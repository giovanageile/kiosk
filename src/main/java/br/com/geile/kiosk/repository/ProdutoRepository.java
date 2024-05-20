package br.com.geile.kiosk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.geile.kiosk.model.ProdutoBean;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoBean, Long> {
	
	Optional<ProdutoBean> findById(Long id);
	
}
