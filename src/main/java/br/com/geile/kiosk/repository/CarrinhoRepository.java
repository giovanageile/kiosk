package br.com.geile.kiosk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.geile.kiosk.model.CarrinhoBean;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoBean, Long>{

	Optional<CarrinhoBean> findById(Long id);
}
