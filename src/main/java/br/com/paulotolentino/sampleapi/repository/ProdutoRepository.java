package br.com.paulotolentino.sampleapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.paulotolentino.sampleapi.model.Produto;

/**
 * Camada de respositorio de produtos, foi utilizado os JpaRepository 
 * pois precisei de uma querie por field
 * @author Paulo Tolentino
 *
 */
@Repository
public interface  ProdutoRepository extends JpaRepository<Produto,Integer> {

	List<Produto> findByFabricanteId(Integer fabricante_id);
}
