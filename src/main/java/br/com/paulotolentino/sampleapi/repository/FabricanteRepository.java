package br.com.paulotolentino.sampleapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.paulotolentino.sampleapi.model.Fabricante;

/**
 * Camada de respositorio para a entidade fabricante, optei por usar o crudRepository 
 * pois não tenho queries especiais
 * @author Paulo Tolentino
 *
 */
@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Integer> {

	
}
